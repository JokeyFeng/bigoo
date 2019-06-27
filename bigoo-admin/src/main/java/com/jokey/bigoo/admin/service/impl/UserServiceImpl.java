package com.jokey.bigoo.admin.service.impl;

import com.jokey.bigoo.admin.entity.User;
import com.jokey.bigoo.admin.mapper.UserMapper;
import com.jokey.bigoo.admin.service.UserService;
import com.jokey.bigoo.admin.vo.RegisterVo;
import com.jokey.bigoo.exception.MyException;
import com.jokey.bigoo.mvc.BaseServiceImpl;
import com.jokey.bigoo.mvc.MyMapper;
import com.jokey.bigoo.mvc.ResponseEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;

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

    @Override
    public int register(RegisterVo register) {
        //先查询账号是否存在
        User account = this.findUserByUsername(register.getUsername());
        if (account != null) {
            throw new MyException(ResponseEnum.ACCOUNT_EXIST);
        }
        //密码加密
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodePassword = encoder.encode(register.getPassword());
        User user = new User();
        user.setUsername(register.getUsername());
        user.setPassword(encodePassword);
        user.setStatus((byte) 1);
        user.setCreateTime(new Date());
        return super.save(user);
    }
}