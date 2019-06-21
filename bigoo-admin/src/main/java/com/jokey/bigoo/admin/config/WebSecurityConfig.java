package com.jokey.bigoo.admin.config;

import com.jokey.bigoo.admin.filter.JwtFilter;
import com.jokey.bigoo.admin.filter.JwtLoginFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author Zhengjingfeng
 * created 2019/6/20 17:27
 * comment  当@EnableGlobalMethodSecurity(prePostEnabled=true)的时候，@PreAuthorize可以使用
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

  /* 使用内存方式
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("bingo")
                .password("123").roles("admin")
                .and()
                .withUser("jokey")
                .password("123")
                .roles("user");
    }*/

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //    .antMatchers("/user").hasRole("user")
                //    .antMatchers("/admin").hasRole("admin")
                .antMatchers(HttpMethod.POST, "/login")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .addFilterBefore(
                        new JwtLoginFilter("/login", super.authenticationManager()),
                        UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(
                        new JwtFilter(),
                        UsernamePasswordAuthenticationFilter.class)
                .csrf().disable();
    }
}
