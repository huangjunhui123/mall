package com.macro.mall.demo.demo.bo.common;

import com.baomidou.mybatisplus.plugins.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by shkstart on 2020/4/13 0013.
 *
 * @author panhong.
 * @time 2020/4/13 0013.
 */
@Data
@ApiModel(value = "PageReqVO", description = "分页通用请求类")
public class PageReqVO {

    @ApiModelProperty(value = "页码", example = "1")
    private Integer pageNum = 1;

    @ApiModelProperty(value = "每页条数", example = "10")
    private Integer pageSize = 10;

    @ApiModelProperty(hidden = true)
    public Page findPage(){
        return new Page(pageNum == null || pageNum <= 0 ? 1 : pageNum,
                pageSize == null || pageSize <= 0 && pageSize != -1 ? 10 : pageSize);
    }
}
