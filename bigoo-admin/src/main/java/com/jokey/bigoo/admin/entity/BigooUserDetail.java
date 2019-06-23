package com.jokey.bigoo.admin.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jokey.bigoo.enu.LoginType;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 * @author Zhengjingfeng
 * created 2019/6/21 16:42
 * comment
 */
@Data
public class BigooUserDetail extends User implements Serializable {

    private static final long serialVersionUID = 2017845963758421135L;

    private LoginType loginType = LoginType.normal;

    private String remoteAddress;

    private String theme;

    private String avatar;

    private long userId;

    private String email;

    private String mobile;

    private byte sex;

    private String password;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date lastLoginTime;

    private long deptId;

    private String deptName;

    private transient String roleId;

    private transient String roleName;

    public BigooUserDetail(String username, String password,
                           Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public BigooUserDetail(String username, String password,
                           boolean enabled, boolean accountNonExpired,
                           boolean credentialsNonExpired, boolean accountNonLocked,
                           Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }
}
