package com.macro.mall.demo.demo.controller;

import com.macro.mall.demo.demo.common.MessageResponse;
import com.macro.mall.demo.demo.config.PermissionLimit;
import com.macro.mall.demo.demo.service.LoginService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;

/**
 * @author 黄俊辉
 */
@RestController
@RequestMapping("/user")
@Api(value = "登录模块", tags = "登录模块")
public class LogInController {

    @Autowired
    private LoginService loginService;

    @PermissionLimit(limit = false)
    @GetMapping("/login")
    @ApiOperation(value = "登录", notes = "登录", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "admin"),
            @ApiImplicitParam(name = "password", value = "123456"),
    })
    public MessageResponse<String> login(@NotBlank(message = "请输入用户名") String userName,@NotBlank(message = "请输入密码") String passWord) {
        String token = loginService.login(userName, passWord);
        return MessageResponse.data(token);
    }
}
