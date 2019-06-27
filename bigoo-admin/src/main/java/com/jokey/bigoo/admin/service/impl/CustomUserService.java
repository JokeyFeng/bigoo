package com.jokey.bigoo.admin.service.impl;

import com.jokey.bigoo.admin.entity.BigooUserDetail;
import com.jokey.bigoo.admin.entity.User;
import com.jokey.bigoo.admin.service.MenuService;
import com.jokey.bigoo.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author Zhengjingfeng
 * created 2019/6/21 9:37
 * comment 自定义拓展UserDetailsService的方法 通过数据库方式验证用户登录
 */
@Service
public class CustomUserService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Autowired
    private MenuService menuService;

    /**
     * 重写loadUserByUsername 方法获得 UserDetails  类型用户
     *
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("");
        }

        //查询用户权限
        String permissions = menuService.findUserPermissions(username);
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList(permissions);
        BigooUserDetail userDetail = new BigooUserDetail(user.getUsername(), user.getPassword(),
                true, true, true,
                User.STATUS_VALID == user.getStatus(), grantedAuthorities);
        userDetail.setUserId(user.getUserId());
        userDetail.setPassword(user.getPassword());
        userDetail.setSex(user.getSex());
        userDetail.setAvatar(user.getAvatar());
        userDetail.setEmail(user.getEmail());
        userDetail.setMobile(user.getMobile());
        userDetail.setTheme(user.getTheme());
        userDetail.setDeptId(user.getDeptId());
        userDetail.setDeptName(user.getDeptName());
        userDetail.setRoleId(user.getRoleId());
        userDetail.setRoleName(user.getRoleName());
        userDetail.setLastLoginTime(new Date());
        //更新last_login_time字段值
        user.setLastLoginTime(new Date());
        userService.updateNotNull(user);
        return userDetail;
    }
}
