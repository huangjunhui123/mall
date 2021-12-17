package com.macro.mall.demo.demo.bo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 黄俊辉
 */
@Data
@ApiModel(value = "PmsBrandPageListReqVo", description = "品牌案例分页请求")
public class PmsBrandPageListReqVo {
    /**
     * 品牌名称
     */
    @ApiModelProperty(value = "关键字（如品牌名称）")
    private String keyword;
}
