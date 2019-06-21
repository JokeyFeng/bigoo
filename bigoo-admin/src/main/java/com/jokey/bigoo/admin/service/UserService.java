package com.jokey.bigoo.admin.service;

import com.jokey.bigoo.admin.entity.User;
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
}