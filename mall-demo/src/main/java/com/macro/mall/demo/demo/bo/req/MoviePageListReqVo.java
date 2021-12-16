package com.macro.mall.demo.demo.bo.req;

import com.macro.mall.demo.demo.bo.common.PageReqVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 黄俊辉
 */
@Data
@ApiModel(value = "MoviePageListReqVo", description = "电影列表分页请求")
public class MoviePageListReqVo extends PageReqVO {

    @ApiModelProperty(value = "关键字")
    private String keyword;

}
