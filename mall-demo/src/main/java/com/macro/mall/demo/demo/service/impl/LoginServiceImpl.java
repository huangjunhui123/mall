package com.macro.mall.demo.demo.service.impl;

import com.macro.mall.demo.demo.bo.ConsumerInfoResVo;
import com.macro.mall.demo.demo.common.FrchainException;
import com.macro.mall.demo.demo.config.consts.RedisConst;
import com.macro.mall.demo.demo.service.LoginService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author 黄俊辉
 */
@Service("LoginService")
public class LoginServiceImpl implements LoginService {

    private String name = "admin";
    private String word = "123456";

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 用户登录
     * @param userName
     * @param password
     * @return
     */
    @Override
    public String login(String userName, String password) {
        // 判断用户名密码是否正确
        if (!name.equals(userName) && !word.equals(password)) {
            throw new FrchainException("密码或用户名错误！");
        }

        // 生成token
        ConsumerInfoResVo userInfo = new ConsumerInfoResVo();
        userInfo.setName(name);
        userInfo.setPhone(word);
        String token = DigestUtils.md5Hex(UUID.randomUUID().toString() + System.currentTimeMillis());
        redisTemplate.opsForValue().set(RedisConst.USER_LOGIN + token, userInfo, RedisConst.USER_TOKEN_TIME, TimeUnit.HOURS);
        return token;
    }

//    public String login(String username, String password, String requestId, String code) {
//        //数字验证码
//        Object obj = redisTemplate.opsForValue().get(RedisConfig.WEB_LOGIN_CODE + requestId);
//        if (obj == null) {
//            throw new FrchainException("验证码已过期，请重新获取");
//        }
//        if (!obj.toString().equals(code)) {
//            throw new FrchainException("验证码错误，请重新输入");
//        }
//        redisTemplate.delete(RedisConfig.WEB_LOGIN_CODE + requestId);
//
//        // 判断用户是否存在
//        UserEntity user = getByAccount(username);
//        if (CommonUtils.isEmpty(user)) {
//            throw new FrchainException(MessageCode.CODE_EXPIRED_CODE, "用户不存在");
//        }
//
//        // 判断用户名密码是否正确
//        String md5Pwd = SaltUtils.md5Encrypt(password, Const.SALT_PASSWORD);
//        String dbMd5 = user.getPassword();
//        if (user.getUserName() == null || dbMd5 == null || !md5Pwd.equals(dbMd5)) {
//            throw new FrchainException(MessageCode.CODE_EXPIRED_CODE, "密码或用户名错误！");
//        }
//        //用户是否禁用
//        Assert.isTrue(EntityStatusEnum.ENABLE.getKey().equals(user.getStatus()), "该用户无使用权限");
//        //角色是否禁用
//        RoleEntity role = roleDao.selectById(user.getRoleId());
//        Assert.isTrue(role != null && EntityStatusEnum.ENABLE.getKey().equals(role.getRoleStatus()), "该用户无使用权限");
//        String token = DigestUtils.md5Hex(UUID.randomUUID().toString() + System.currentTimeMillis());
//        AuthencticationUserResVo vo = new AuthencticationUserResVo();
//        vo.setId(user.getId());
//        vo.setRealName(user.getRealName());
//        vo.setUserName(user.getUserName());
//        List<MenuResVo> menuResVos = null;
//        if (Const.ADMIN_ROLE_ID.equals(user.getRoleId())) {
//            menuResVos = this.menuDao.selectAll();
//        } else {
//            menuResVos = this.menuDao.selectByRoleId(user.getRoleId());
//        }
//        //是否有菜单
//        Assert.notEmpty(menuResVos, "该用户无使用权限");
//        vo.setMenuResVos(menuResVos);
//        vo.setToken(token);
//        vo.setType(user.getType());
//        redisTemplate.opsForValue().set(RedisConfig.USER_TOKEN + token, vo, RedisConfig.USER_TOKEN_TIME, TimeUnit.HOURS);
//
//        UserOperationLog userOperationLog = new UserOperationLog();
//        userOperationLog.setTaskType(DictionaryConst.LOGIN_SYSTEM);
//        userOperationLog.setOperationType(DictionaryConst.LOGIN_SUCCESS);
//        userOperationLog.setParams("");
//        userOperationLog.setUserId(user.getId());
//        userOperationLog.setIp(RealIpUtil.getRealIp(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest()));
//        userOperationLogDao.insert(userOperationLog);
//
//        return token;
//    }
}
