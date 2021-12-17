package com.macro.mall.demo.demo.bo.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 黄俊辉
 */
@Data
@ApiModel(value = "PmsBrandInfoResVo", description = "品牌案例详情信息")
public class PmsBrandInfoResVo {
    @ApiModelProperty(value = "id")
    private Long id;
    /**
     * 品牌名称
     */
    @ApiModelProperty(value = "品牌名称")
    private String name;
    /**
     * 首字母
     */
    @ApiModelProperty(value = "首字母")
    private String firstLetter;
    /**
     * 品牌logo
     */
    @ApiModelProperty(value = "品牌logo")
    private String logo;
    /**
     * 是否为品牌制造商：0->不是；1->是
     */
    @ApiModelProperty(value = "是否为品牌制造商：0->不是；1->是")
    private Integer factoryStatus;
    /**
     * 产品数量
     */
    @ApiModelProperty(value = "产品数量")
    private Integer productCount;
    /**
     * 产品评论数量
     */
    @ApiModelProperty(value = "产品评论数量")
    private Integer productCommentCount;
    /**
     * 专区大图
     */
    @ApiModelProperty(value = "专区大图")
    private String bigPic;
    /**
     * 品牌故事
     */
    @ApiModelProperty(value = "品牌故事")
    private String brandStory;
}
