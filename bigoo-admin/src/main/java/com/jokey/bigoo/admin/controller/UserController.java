package com.jokey.bigoo.admin.controller;

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
    public Object get(){
        return "{\"username\":\"123456\"}";
    }
}
