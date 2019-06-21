package com.jokey.bigoo.admin.service.impl;

import com.jokey.bigoo.admin.entity.RoleMenu;
import com.jokey.bigoo.admin.mapper.RoleMenuMapper;
import com.jokey.bigoo.admin.service.RoleMenuService;
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
public class RoleMenuServiceImpl extends BaseServiceImpl<RoleMenu> implements RoleMenuService {

    @Autowired
    private RoleMenuMapper roleMenuMapper;

    @Override
    protected MyMapper<RoleMenu> getMapper() {
        return roleMenuMapper;
    }
}