package com.jokey.bigoo.admin.service.impl;

import com.jokey.bigoo.admin.entity.UserRole;
import com.jokey.bigoo.admin.mapper.UserRoleMapper;
import com.jokey.bigoo.admin.service.UserRoleService;
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
public class UserRoleServiceImpl extends BaseServiceImpl<UserRole> implements UserRoleService {

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    protected MyMapper<UserRole> getMapper() {
        return userRoleMapper;
    }
}