package com.jokey.bigoo.admin.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * @author Zhengjingfeng
 * created 2019/6/19 10:49
 * comment
 */
@Data
public class User implements UserDetails {
    /**
     * 用户id
     */
    private long userId;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    @JsonIgnore
    private String password;
    /**
     * 性别 0男 1女
     */
    private byte sex;
    /**
     * 部门id
     */
    private long deptId;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 联系电话
     */
    private String mobile;
    /**
     * 状态 0锁定 1有效
     */
    private byte status;
    /**
     * 最近登录时间
     */
    private Date lastLoginTime;
    /**
     * 主题
     */
    private String theme;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 描述
     */
    private String description;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date modifyTime;
    /**
     * 具备的权限
     */
    private List<GrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
