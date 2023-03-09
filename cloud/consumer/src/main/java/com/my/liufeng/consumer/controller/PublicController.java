package com.my.liufeng.consumer.controller;

import com.my.liufeng.auth.RemoteUserService;
import com.my.liufeng.common.Asserts;
import com.my.liufeng.common.Result;
import com.my.liufeng.common.enums.ErrorCode;
import com.my.liufeng.common.user.dto.RegisterDTO;
import com.my.liufeng.common.user.vo.LoginVO;
import com.my.liufeng.common.user.vo.RegisterVO;
import com.my.liufeng.common.utils.RegUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/public")
public class PublicController {
    @Resource
    private RemoteUserService remoteUserService;

    @GetMapping("/getSecret")
    public Result<String> getSecret(@RequestParam String account) {
        account = account.trim();
        Asserts.assertTrue(RegUtils.accountMatch(account, ErrorCode.ACCOUNT_REPEAT_ERROR), ErrorCode.ACCOUNT_REPEAT_ERROR);
        return Result.success(remoteUserService.getSecret(account));
    }

    @PostMapping("/register")
    public Result<RegisterDTO> register(@RequestBody RegisterVO registerVO) {
        Asserts.assertTrue(RegUtils.accountMatch(registerVO.getAccount(), ErrorCode.ACCOUNT_FORMAT_ERROR), ErrorCode.ACCOUNT_FORMAT_ERROR);
        Asserts.assertTrue(RegUtils.passwordMatch(registerVO.getPassword(), ErrorCode.PASSWORD_FORMAT_ERROR), ErrorCode.PASSWORD_FORMAT_ERROR);
        return Result.success(remoteUserService.register(registerVO));
    }

    @PostMapping("/login")
    public Result<RegisterDTO> login(@RequestBody LoginVO loginVO) {
        // todo 参数校验，后续优化
        Asserts.assertNotEmpty(loginVO.getAccount(), ErrorCode.ACCOUNT_EMPTY_ERROR);
        Asserts.assertNotEmpty(loginVO.getPassword(), ErrorCode.PASSWORD_ERROR);
        Asserts.assertPositive(loginVO.getCode(), ErrorCode.DYNAMIC_PASSWORD_ERROR);
        return Result.success(remoteUserService.login(loginVO));
    }
}
