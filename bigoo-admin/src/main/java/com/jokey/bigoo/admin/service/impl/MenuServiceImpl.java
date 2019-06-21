package com.jokey.bigoo.admin.service.impl;

import com.jokey.bigoo.admin.entity.Menu;
import com.jokey.bigoo.admin.mapper.MenuMapper;
import com.jokey.bigoo.admin.service.MenuService;
import com.jokey.bigoo.mvc.BaseServiceImpl;
import com.jokey.bigoo.mvc.MyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author jokey
 * Date 2019年6月21日
 * Version 1.0
 */
@Service
public class MenuServiceImpl extends BaseServiceImpl<Menu> implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    protected MyMapper<Menu> getMapper() {
        return menuMapper;
    }

    @Override
    public String findUserPermissions(String userName) {
        List<Menu> list = menuMapper.findUserPermissions(userName);
        return list.stream().map(Menu::getPermission).collect(Collectors.joining(","));
    }
}