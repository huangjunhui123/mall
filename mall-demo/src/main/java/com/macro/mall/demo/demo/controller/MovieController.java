package com.macro.mall.demo.demo.controller;

import com.macro.mall.demo.demo.bo.MoviePageListResVo;
import com.macro.mall.demo.demo.common.MessageResponse;
import com.macro.mall.demo.demo.config.PermissionLimit;
import com.macro.mall.demo.demo.model.MovieEntity;
import com.macro.mall.demo.demo.service.MovieService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;


/**
 * 
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2021-12-06 15:43:58
 */
@RestController
@RequestMapping("/movie")
@Api(value = "商品模块", tags = "商品模块")
public class MovieController {
    @Autowired
    private MovieService movieService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @ApiOperation(value = "列表", notes = "列表", httpMethod = "POST")
    public List<MoviePageListResVo> list(){
        List<MoviePageListResVo> list = movieService.list();
        return list;
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @ApiOperation(value = "信息", notes = "信息", httpMethod = "POST")
    public void info(@PathVariable("id") String id){

//        return R.ok().put("movie", movie);
    }

    /**
     * 保存
     */
    @PermissionLimit(limit = false)
    @RequestMapping("/save")
    @ApiOperation(value = "保存", notes = "保存", httpMethod = "POST")
    public MessageResponse save(@Valid MoviePageListResVo movie){
        movieService.add(movie);
        return MessageResponse.data();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @ApiOperation(value = "修改", notes = "修改", httpMethod = "POST")
    public void update(@RequestBody MovieEntity movie){

        
//        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @ApiOperation(value = "删除", notes = "删除", httpMethod = "POST")
    public void delete(@RequestBody String[] ids){

//        return R.ok();
    }

}
