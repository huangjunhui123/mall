package com.macro.mall.demo.demo.controller;

import com.macro.mall.demo.demo.bo.MoviePageListResVo;
import com.macro.mall.demo.demo.model.MovieEntity;
import com.macro.mall.demo.demo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
public class MovieController {
    @Autowired
    private MovieService movieService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public List<MoviePageListResVo> list(){
        List<MoviePageListResVo> list = movieService.list();
        return list;
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public void info(@PathVariable("id") String id){

//        return R.ok().put("movie", movie);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public void save(@RequestBody MovieEntity movie){

//        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public void update(@RequestBody MovieEntity movie){

        
//        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public void delete(@RequestBody String[] ids){

//        return R.ok();
    }

}
