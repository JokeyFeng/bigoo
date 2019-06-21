package com.jokey.bigoo.admin.filter;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableMap;
import com.jokey.bigoo.admin.entity.User;
import com.jokey.bigoo.mvc.RestResponse;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.SneakyThrows;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Date;

/**
 * @author Zhengjingfeng
 * created 2019/6/19 11:33
 * comment 用户登录的过滤器
 * 在用户的登录的过滤器中校验用户是否登录成功，如果登录成功，则生成一个token返回给客户端，登录失败则给前端一个登录失败的提示。
 * <p>
 * <p>
 * <p>
 * 自定义 JwtLoginFilter 继承自 AbstractAuthenticationProcessingFilter，并实现其中的三个默认方法。
 * attemptAuthentication方法中，我们从登录参数中提取出用户名密码，然后调用AuthenticationManager.authenticate()方法去进行自动校验。
 * 第二步如果校验成功，就会来到successfulAuthentication回调中，在successfulAuthentication方法中，将用户角色遍历然后用一个 , 连接起来，然后再利用Jwts去生成token，按照代码的顺序，生成过程一共配置了四个参数，分别是用户角色、主题、过期时间以及加密算法和密钥，然后将生成的token写出到客户端。
 * 第二步如果校验失败就会来到unsuccessfulAuthentication方法中，在这个方法中返回一个错误提示给客户端即可。
 */
@WebFilter
public class JwtLoginFilter extends AbstractAuthenticationProcessingFilter {

    public JwtLoginFilter(String defaultFilterProcessesUrl, AuthenticationManager authenticationManager) {
        super(new AntPathRequestMatcher(defaultFilterProcessesUrl));
        setAuthenticationManager(authenticationManager);
    }

    @Override
    @SneakyThrows
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse response) {
        User user = new ObjectMapper().readValue(req.getInputStream(), User.class);
        return getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
    }

    @Override
    @SneakyThrows
    protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res,
                                            FilterChain chain, Authentication authResult) {
        Collection<? extends GrantedAuthority> authorities = authResult.getAuthorities();
        StringBuilder as = new StringBuilder();
        for (GrantedAuthority authority : authorities) {
            as.append(authority.getAuthority())
                    .append(",");
        }
        //配置用户角色
        String jwt = Jwts.builder()
                .claim("authorities", as)
                .setSubject(authResult.getName())
                .setExpiration(new Date(System.currentTimeMillis() + 10 * 60 * 1000))
                .signWith(SignatureAlgorithm.HS512, "jokey.bingo.com")
                .compact();
        res.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        PrintWriter out = res.getWriter();
        out.write(JSON.toJSONString(RestResponse.success(ImmutableMap.of("token", jwt))));
        out.flush();
        out.close();
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest req, HttpServletResponse res, AuthenticationException failed) throws IOException {
        res.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        PrintWriter out = res.getWriter();
        String notPassMsg = "登录失败";
        if (failed instanceof BadCredentialsException) {
            notPassMsg = "用户名或密码错误";
        }
        if (failed instanceof AccountExpiredException) {
            notPassMsg = "账号已过期";
        }

        if (failed instanceof CredentialsExpiredException) {
            notPassMsg = "登录令牌已过期";
        }
        if (failed instanceof LockedException) {
            notPassMsg = "账号已冻结";
        }
        out.write(JSON.toJSONString(RestResponse.fail(notPassMsg)));
        out.flush();
        out.close();
    }
}
