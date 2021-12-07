package com.macro.mall.demo.demo.bo;

import lombok.Data;

/**
 * @author 黄俊辉
 */
@Data
public class MoviePageListResVo {
    /**
     * 电影信息唯一id
     */
    private String id;
    /**
     * 电影标题
     */
    private String title;
    /**
     * 封面
     */
    private String cover;
    /**
     * 评分
     */
    private String rate;
    /**
     * 该电影的演员名称
     */
    private String casts;
    /**
     * 该电影的导演
     */
    private String directors;
}
