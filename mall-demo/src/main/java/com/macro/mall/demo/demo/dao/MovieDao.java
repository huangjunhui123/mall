package com.macro.mall.demo.demo.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.macro.mall.demo.demo.bo.MoviePageListResVo;
import com.macro.mall.demo.demo.bo.req.MoviePageListReqVo;
import com.macro.mall.demo.demo.model.MovieEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 
 * 
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2021-12-06 15:43:58
 */
//@Mapper
@Repository
public interface MovieDao extends BaseMapper<MovieEntity> {

    /**
     * 列表
     * @param page
     * @param vo
     * @return
     */
    List<MoviePageListResVo> selectMovieList(Page page, @Param("vo") MoviePageListReqVo vo);
}
