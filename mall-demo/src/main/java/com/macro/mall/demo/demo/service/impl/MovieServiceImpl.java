package com.macro.mall.demo.demo.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.macro.mall.demo.demo.bo.MoviePageListResVo;
import com.macro.mall.demo.demo.bo.common.PageView;
import com.macro.mall.demo.demo.bo.req.MoviePageListReqVo;
import com.macro.mall.demo.demo.dao.MovieDao;
import com.macro.mall.demo.demo.model.MovieEntity;
import com.macro.mall.demo.demo.service.MovieService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;


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
    public PageView<MoviePageListResVo> list(MoviePageListReqVo vo) {
        Page page = vo.findPage();
        List<MoviePageListResVo> list = movieDao.selectMovieList(page,vo);
        page.setRecords(list);
        return new PageView<>(page);
    }

    /**
     * 新增
     * @param movie
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(MoviePageListResVo movie) {
        MovieEntity entity = new MovieEntity();
        movie.setId(getNumber(8));
        BeanUtils.copyProperties(movie,entity);
        movieDao.insert(entity);
    }

    /**
     * 根据位数生成验证码
     * @param size
     * @return
     */
    private String getNumber(int size) {
        String retNum = "";
        String codeStr = "1234567890";
        Random r = new Random();
        for (int i = 0; i < size; i++) {
            retNum += codeStr.charAt(r.nextInt(codeStr.length()));
        }
        return retNum;
    }

}
