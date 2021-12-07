package com.macro.mall.demo.demo.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.macro.mall.demo.demo.bo.MoviePageListResVo;
import com.macro.mall.demo.demo.model.MovieEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 
 * 
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2021-12-06 15:43:58
 */
@Mapper
//@Repository
public interface MovieDao extends BaseMapper<MovieEntity> {

    /**
     *  ge
      * @param str
     * @return
     */
    List<MoviePageListResVo> selectMovieList(@Param("str") String str);

}
