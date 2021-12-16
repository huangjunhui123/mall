package com.macro.mall.demo.demo.service;

import com.baomidou.mybatisplus.service.IService;
import com.macro.mall.demo.demo.bo.MoviePageListResVo;
import com.macro.mall.demo.demo.bo.common.PageView;
import com.macro.mall.demo.demo.bo.req.MoviePageListReqVo;
import com.macro.mall.demo.demo.model.MovieEntity;

import java.util.List;


/**
 * 
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2021-12-06 15:43:58
 */
public interface MovieService extends IService<MovieEntity> {

    /**
     * 列表
     * @param vo
     * @return
     */
    PageView<MoviePageListResVo> list(MoviePageListReqVo vo);

    /**
     * 新增
      * @param movie
     */
    void add(MoviePageListResVo movie);
}

