package com.macro.mall.demo.demo.config;

import com.macro.mall.demo.demo.bo.ConsumerInfoResVo;
import com.macro.mall.demo.demo.common.FrchainException;
import com.macro.mall.demo.demo.common.MessageCode;
import com.macro.mall.demo.demo.config.consts.RedisConst;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.data.redis.core.RedisTemplate;


import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;


/**
 * 权限拦截
 * @author 黄俊辉
 */
@Aspect
@Slf4j
@Component
public class PermissionInterceptor {
    private String USER_TOKEN = "U-Token";

    @Autowired
    private RedisTemplate redisTemplate;

    @Pointcut("execution(* com.macro.mall.demo.demo.controller..*.*(..))")
    public void checkLogin(){}

    @Around("checkLogin()")
    public Object processAuthority(ProceedingJoinPoint point) throws Throwable {
        try{
            HttpServletRequest servletRequest = getHttpServletRequest();
            MethodSignature signature = (MethodSignature) point.getSignature();
            Method method = signature.getMethod();
            PermissionLimit annotation = method.getAnnotation(PermissionLimit.class);
            if (annotation != null && !annotation.limit()) {
                Object proceed = point.proceed();
                return proceed;
            }

            String token = servletRequest.getHeader(USER_TOKEN);
            if (StringUtils.isBlank(token)) {
                throw new FrchainException(MessageCode.CODE_UNLOGIN, "未登录");
            }
            Object cache = redisTemplate.opsForValue().get(RedisConst.USER_LOGIN + token);
            if (cache == null) {
                throw new FrchainException(MessageCode.CODE_UNLOGIN, "未登录");
            }
            ConsumerInfoResVo userResVo = (ConsumerInfoResVo) cache;

            redisTemplate.opsForValue().set(RedisConst.USER_LOGIN + token, userResVo, RedisConst.USER_TOKEN_TIME, TimeUnit.HOURS);
            UserInfoThreadLocal.set(userResVo);

            return point.proceed();
        }catch (Exception e){
            throw e;
        }finally {
            UserInfoThreadLocal.clean();
        }
    }

    private HttpServletRequest getHttpServletRequest() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes attributes = (ServletRequestAttributes) requestAttributes;
        return attributes.getRequest();
    }
}
