package com.jokey.bigoo.admin.service.impl;

import com.jokey.bigoo.admin.entity.Role;
import com.jokey.bigoo.admin.mapper.RoleMapper;
import com.jokey.bigoo.admin.service.RoleService;
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
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    protected MyMapper<Role> getMapper() {
        return roleMapper;
    }
}