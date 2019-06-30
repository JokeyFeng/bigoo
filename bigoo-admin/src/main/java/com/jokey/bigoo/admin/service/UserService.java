package com.jokey.bigoo.admin.service;

import com.jokey.bigoo.admin.entity.User;
import com.jokey.bigoo.admin.vo.RegisterVo;
import com.jokey.bigoo.mvc.BaseService;

/**
 * @author jokey
 * Date 2019年6月21日
 * Version 1.0
 */
public interface UserService extends BaseService<User> {
    /**
     * 根据账号查询用户
     *
     * @param username
     * @return
     */
    User findUserByUsername(String username);

    /**
     * 注册账号
     *
     * @param register
     * @return
     */
    int register(RegisterVo register);

    /**
     * 用户是否存在
     *
     * @param username
     * @return true表示存在 false表示不存在
     */
    boolean isExistUser(String username);
}