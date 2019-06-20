package com.jokey.bigoo.admin.controller;

import com.jokey.bigoo.mvc.RestResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Zhengjingfeng
 * created 2019/6/17 17:44
 * comment
 */
@RestController
public class UserController {

    @GetMapping("/user")
    public RestResponse get() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication.getName());
        return RestResponse.success("{\"username\":\"hello\"}");
    }

    @GetMapping("/admin")
    public RestResponse admin() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication.getName());
        return RestResponse.success("{\"username\":\"admin\"}");
    }
}
