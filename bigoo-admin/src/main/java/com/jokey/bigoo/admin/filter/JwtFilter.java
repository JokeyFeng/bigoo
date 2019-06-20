package com.jokey.bigoo.admin.filter;

import com.alibaba.fastjson.JSON;
import com.jokey.bigoo.mvc.RestResponse;
import io.jsonwebtoken.*;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author Zhengjingfeng
 * created 2019/6/20 17:25
 * comment
 * 首先从请求头中提取出 authorization 字段，这个字段对应的value就是用户的token。
 * 将提取出来的token字符串转换为一个Claims对象，再从Claims对象中提取出当前用户名和用户角色，
 * 创建一个UsernamePasswordAuthenticationToken放到当前的Context中，然后执行过滤链使请求继续执行下去。
 */
public class JwtFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String jwtToken = req.getHeader("authorization");
        if (StringUtils.isEmpty(jwtToken)) {
            this.response(response, RestResponse.fail("请登录再访问"));
        }
        System.out.println(jwtToken);
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey("jokey.bingo.com")
                    .parseClaimsJws(jwtToken.replace("Bearer", ""))
                    .getBody();
            //获取当前登录用户名
            String username = claims.getSubject();
            List<GrantedAuthority> authorities = AuthorityUtils.commaSeparatedStringToAuthorityList((String) claims.get("authorities"));
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, null, authorities);
            SecurityContextHolder.getContext().setAuthentication(token);
            chain.doFilter(req, response);
        } catch (ExpiredJwtException e) {
            this.response(response, RestResponse.fail("登录凭证已过期，请重新登录"));
        } catch (UnsupportedJwtException e) {
            e.printStackTrace();
        } catch (SignatureException e) {
            this.response(response, RestResponse.fail("不合法的登录凭证，请重新登录"));
        }
    }

    /**
     * @param response
     * @param restResponse
     * @throws IOException
     */
    private void response(ServletResponse response, RestResponse restResponse) throws IOException {
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        PrintWriter out = response.getWriter();
        out.write(JSON.toJSONString(restResponse));
        out.flush();
        out.close();
    }
}
