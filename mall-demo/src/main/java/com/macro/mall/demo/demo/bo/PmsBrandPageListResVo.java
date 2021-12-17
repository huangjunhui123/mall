package com.macro.mall.demo.demo.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 黄俊辉
 */
@Data
@ApiModel(value = "PmsBrandPageListResVo", description = "品牌案例列表")
public class PmsBrandPageListResVo {
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
}
