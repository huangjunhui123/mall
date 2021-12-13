package com.macro.mall.demo.demo.bo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 黄俊辉
 */
@Data
public class ConsumerInfoResVo {

    @ApiModelProperty(value = "姓名/昵称")
    private String name;

    @ApiModelProperty(value = "密码（手机号）")
    private String phone;

}
