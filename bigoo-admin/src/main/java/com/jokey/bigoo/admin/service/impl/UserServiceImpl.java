package com.jokey.bigoo.admin.service.impl;

import com.jokey.bigoo.admin.entity.User;
import com.jokey.bigoo.admin.mapper.UserMapper;
import com.jokey.bigoo.admin.service.UserService;
import com.jokey.bigoo.mvc.BaseServiceImpl;
import com.jokey.bigoo.mvc.MyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

/**
 * @author jokey
 * Date 2019年6月21日
 * Version 1.0
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    protected MyMapper<User> getMapper() {
        return userMapper;
    }

    @Override
    public User findUserByUsername(String username) {
        Example example = new Example(User.class);
        example.createCriteria().andEqualTo(User.USERNAME, username);
        return userMapper.selectOneByExample(example);
    }
}