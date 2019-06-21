package com.jokey.bigoo.admin.service.impl;

import com.jokey.bigoo.admin.entity.UserConnection;
import com.jokey.bigoo.admin.mapper.UserConnectionMapper;
import com.jokey.bigoo.admin.service.UserConnectionService;
import com.jokey.bigoo.mvc.BaseServiceImpl;
import com.jokey.bigoo.mvc.MyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author jokey
 * Date 2019年6月21日
 * Version 1.0
 */
@Service
public class UserConnectionServiceImpl extends BaseServiceImpl<UserConnection> implements UserConnectionService {

    @Autowired
    private UserConnectionMapper userConnectionMapper;

    @Override
    protected MyMapper<UserConnection> getMapper() {
        return userConnectionMapper;
    }
}