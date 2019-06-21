package com.jokey.bigoo.admin.service;

import com.jokey.bigoo.admin.entity.Menu;
import com.jokey.bigoo.mvc.BaseService;

/**
 * @author jokey
 * Date 2019年6月21日
 * Version 1.0
 */
public interface MenuService extends BaseService<Menu> {
    /**
     * 根据账号查询对应的权限
     *
     * @param userName
     * @return
     */
    String findUserPermissions(String userName);
}