package com.macro.mall.demo.demo.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.macro.mall.demo.demo.bo.MoviePageListResVo;
import com.macro.mall.demo.demo.dao.MovieDao;
import com.macro.mall.demo.demo.model.MovieEntity;
import com.macro.mall.demo.demo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author 黄俊辉
 */
@Service("movieService")
public class MovieServiceImpl extends ServiceImpl<MovieDao, MovieEntity> implements MovieService {

    @Autowired
    private MovieDao movieDao;

    /**
     * 列表
     * @return
     */
    @Override
    public List<MoviePageListResVo> list() {
        List<MoviePageListResVo> vo = movieDao.selectMovieList("123");
        return vo;
    }

    /**
     * 新增
     * @param movie
     */
    @Override
    public void add(MoviePageListResVo movie) {

    }

}
