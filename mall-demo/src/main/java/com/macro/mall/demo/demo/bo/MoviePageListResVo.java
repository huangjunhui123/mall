package com.macro.mall.demo.demo.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 黄俊辉
 */
@Data
@ApiModel(value = "MoviePageListResVo", description = "电影列表信息")
public class MoviePageListResVo {
    /**
     * 电影信息唯一id
     */
    @ApiModelProperty(value = "电影信息唯一id")
    private String id;
    /**
     * 电影标题
     */
    @ApiModelProperty(value = "电影标题")
    private String title;
    /**
     * 封面
     */
    @ApiModelProperty(value = "封面")
    private String cover;
    /**
     * 评分
     */
    @ApiModelProperty(value = "评分")
    private String rate;
    /**
     * 该电影的演员名称
     */
    @ApiModelProperty(value = "该电影的演员名称")
    private String casts;
    /**
     * 该电影的导演
     */
    @ApiModelProperty(value = "该电影的导演")
    private String directors;
}
