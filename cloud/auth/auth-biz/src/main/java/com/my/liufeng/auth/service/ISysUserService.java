package com.my.liufeng.auth.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.my.liufeng.auth.po.SysUser;
import com.my.liufeng.common.user.dto.RegisterDTO;
import com.my.liufeng.common.user.vo.LoginVO;
import com.my.liufeng.common.user.vo.RegisterVO;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author liufeng
 * @since 2023-03-02
 */
public interface ISysUserService extends IService<SysUser> {

    /**
     * 校验账户是否存在
     *
     * @param account 账号
     * @return true-已存在 false-不存在
     */
    boolean checkIfExist(String account);

    /**
     * 注册
     */
    RegisterDTO register(RegisterVO registerVO);

    /**
     * 登录
     */
    RegisterDTO login(LoginVO loginVO);
}
