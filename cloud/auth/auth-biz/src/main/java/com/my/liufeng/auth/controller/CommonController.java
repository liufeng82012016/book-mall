package com.my.liufeng.auth.controller;

import com.my.liufeng.auth.config.KeyFactory;
import com.my.liufeng.auth.service.ISysUserService;
import com.my.liufeng.auth.utils.GoogleAuthUtil;
import com.my.liufeng.common.Asserts;
import com.my.liufeng.common.enums.ErrorCode;
import com.my.liufeng.common.user.dto.RegisterDTO;
import com.my.liufeng.common.user.vo.LoginVO;
import com.my.liufeng.common.user.vo.RegisterVO;
import com.my.liufeng.common.utils.RegUtils;
import com.my.liufeng.provider.support.DistributeLock;
import com.my.liufeng.provider.utils.CacheUtil;
import com.my.liufeng.provider.utils.LockUtil;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;


@RestController
@RequestMapping("/public")
public class CommonController {
    @Autowired
    private ISysUserService userService;

    @GetMapping("/checkAccount")
    @Parameter(name = "account", description = "用户账号")
    public boolean checkAccountRepeat(@RequestParam String account) {
        account = account.trim();
        Asserts.assertTrue(RegUtils.accountMatch(account, ErrorCode.ACCOUNT_FORMAT_ERROR), ErrorCode.ACCOUNT_FORMAT_ERROR);
        return userService.checkIfExist(account);
    }

    @GetMapping(value = "/getSecret")
    public String getSecret(@RequestParam String account) {
        account = account.trim();
        Asserts.assertFalse(checkAccountRepeat(account), ErrorCode.ACCOUNT_REPEAT_ERROR);
        String secret = GoogleAuthUtil.generateSecretKey();
        // 缓存secret
        CacheUtil.set(KeyFactory.SECRET.getKey(account), secret, 30, TimeUnit.MINUTES);
        return GoogleAuthUtil.getQRBarcodeURL(account, "liufeng", secret);
    }

    @PostMapping("/register")
    public RegisterDTO register(@RequestBody RegisterVO registerVO) {
        Asserts.assertTrue(RegUtils.accountMatch(registerVO.getAccount(), ErrorCode.ACCOUNT_FORMAT_ERROR), ErrorCode.ACCOUNT_FORMAT_ERROR);
        Asserts.assertTrue(RegUtils.passwordMatch(registerVO.getPassword(), ErrorCode.PASSWORD_FORMAT_ERROR), ErrorCode.PASSWORD_FORMAT_ERROR);
        String lockKey = KeyFactory.REGISTER.getKey(registerVO.getAccount());
        DistributeLock lock = LockUtil.getLock(lockKey);
        lock.lock();
        try {
            Asserts.assertFalse(userService.checkIfExist(registerVO.getAccount()), ErrorCode.ACCOUNT_REPEAT_ERROR);
            String secret = CacheUtil.get(KeyFactory.SECRET.getKey(registerVO.getAccount()), String.class);
            Asserts.assertNotEmpty(secret, ErrorCode.SECRET_EXPIRED_ERROR);
            registerVO.setSecret(secret);
            return userService.register(registerVO);
        } finally {
            lock.unlock();
        }
    }

    @PostMapping("/login")
    public RegisterDTO login(@RequestBody LoginVO loginVO) {
        // todo 参数校验，后续优化
        Asserts.assertNotEmpty(loginVO.getAccount(), ErrorCode.ACCOUNT_EMPTY_ERROR);
        Asserts.assertNotEmpty(loginVO.getPassword(), ErrorCode.PASSWORD_ERROR);
        Asserts.assertPositive(loginVO.getCode(), ErrorCode.DYNAMIC_PASSWORD_ERROR);

        String lockKey = KeyFactory.REGISTER.getKey(loginVO.getAccount());
        DistributeLock lock = LockUtil.getLock(lockKey);
        lock.lock();
        try {
            return userService.login(loginVO);
        } finally {
            lock.unlock();
        }
    }
}
