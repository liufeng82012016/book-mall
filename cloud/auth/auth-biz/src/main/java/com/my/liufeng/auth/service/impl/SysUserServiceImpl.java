package com.my.liufeng.auth.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.my.liufeng.Asserts;
import com.my.liufeng.auth.entity.SysUser;
import com.my.liufeng.auth.mapper.SysUserMapper;
import com.my.liufeng.auth.service.ISysUserService;
import com.my.liufeng.auth.utils.GoogleAuthUtil;
import com.my.liufeng.enums.ErrorCode;
import com.my.liufeng.excaption.BrokenException;
import com.my.liufeng.provider.enums.CacheLevel;
import com.my.liufeng.provider.utils.CacheUtil;
import com.my.liufeng.user.dto.RegisterDTO;
import com.my.liufeng.user.vo.LoginVO;
import com.my.liufeng.user.vo.RegisterVO;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author liufeng
 * @since 2023-03-02
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Override
    public boolean checkIfExist(String account) {
        SysUser condition = new SysUser();
        condition.setAccount(account);
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>(condition);
        return getOne(queryWrapper) != null;
    }

    @Override
    public RegisterDTO register(RegisterVO registerVO) {
        // 校验动态密码
        verifyDynamicPassword(registerVO.getSecret(), registerVO.getCode());

        // 密码处理
        SysUser sysUser = new SysUser();
        sysUser.setAccount(registerVO.getAccount());
        sysUser.setSecret(registerVO.getSecret());
        String salt = RandomStringUtils.random(16);
        sysUser.setSalt(salt);
        sysUser.setPassword(signPassword(registerVO.getPassword(), salt));
        try {
            Asserts.assertTrue(save(sysUser), ErrorCode.LOCK_ERROR);
            return generatorToken(sysUser);
        } catch (DuplicateKeyException e) {
            throw new BrokenException(ErrorCode.ACCOUNT_REPEAT_ERROR);
        }
    }

    @Override
    public RegisterDTO login(LoginVO loginVO) {
        // 数据库查询对应账号
        SysUser condition = new SysUser();
        condition.setAccount(loginVO.getAccount());
        SysUser sysUser = getOne(new QueryWrapper<>(condition));
        Asserts.assertNotNull(sysUser, ErrorCode.ACCOUNT_EMPTY_ERROR);
        // 校验动态密码
        verifyDynamicPassword(sysUser.getSecret(), loginVO.getCode());
        // 校验密码
        String signPassword = signPassword(loginVO.getPassword(), sysUser.getSalt());
        Asserts.assertTrue(signPassword.equals(loginVO.getPassword()), ErrorCode.PASSWORD_ERROR);
        return generatorToken(sysUser);
    }

    /**
     * 对密码进行md5处理
     *
     * @param password 密码
     * @param salt     盐
     * @return 加密后的密码
     */
    private String signPassword(String password, String salt) {
        return DigestUtils.md5DigestAsHex((password + salt).getBytes(StandardCharsets.UTF_8));
    }

    /**
     * 校验动态口令
     *
     * @param secret 密钥
     * @param code   口令
     */
    private void verifyDynamicPassword(String secret, Long code) {
        boolean checkSuccess = GoogleAuthUtil.checkCode(secret, code, System.currentTimeMillis());
        Asserts.assertTrue(checkSuccess, ErrorCode.DYNAMIC_PASSWORD_ERROR);
    }

    /**
     * 注册/登录后生成token
     *
     * @param sysUser 用户信息
     * @return /
     */
    private RegisterDTO generatorToken(SysUser sysUser) {
        String token = RandomStringUtils.random(32);
        CacheUtil.set(token, sysUser, CacheLevel.WEB_TOKEN);
        RegisterDTO registerDTO = new RegisterDTO();
        registerDTO.setToken(token);
        return registerDTO;
    }
}
