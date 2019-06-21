package com.jokey.bigoo.admin.entity;

import com.jokey.bigoo.enu.LoginType;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.io.Serializable;
import java.util.Collection;

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

    private Long userId;

    private String email;

    private String mobile;

    private byte sex;

    private String password;

    private String loginTime;

    public BigooUserDetail(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public BigooUserDetail(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }
}
