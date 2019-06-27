package com.jokey.bigoo.admin.controller;

import com.github.pagehelper.PageInfo;
import com.jokey.bigoo.admin.entity.User;
import com.jokey.bigoo.admin.service.UserService;
import com.jokey.bigoo.admin.vo.RegisterVo;
import com.jokey.bigoo.mvc.BaseController;
import com.jokey.bigoo.mvc.Page;
import com.jokey.bigoo.mvc.RestResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author jokey
 * Date 2019年6月21日
 * Version 1.0
 */
@RestController
@Api(tags = "用户表")
@RequestMapping(value = "/v1/user", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @GetMapping("/id")
    @ApiOperation("根据ID查询")
    @ApiImplicitParam(name = "id", value = "主键ID", paramType = "query", dataType = "String")
    public RestResponse<User> find(@RequestParam String id) {
        return RestResponse.success(userService.selectByKey(id));
    }

    @GetMapping("/list")
    @ApiOperation("分页查询")
    @PreAuthorize("hasAuthority('user:list')")
    public RestResponse<PageInfo<User>> page(Page page) {
        return RestResponse.success(userService.selectByPage(page));
    }

    @PostMapping("/add")
    @ApiOperation("新增")
    @PreAuthorize("hasAuthority('user:add')")
    @ApiImplicitParam(name = "user", value = "用户表", paramType = "body", dataType = "User")
    public RestResponse insert(@RequestBody User user) {
        return RestResponse.success(userService.save(user));
    }

    @PostMapping("/register")
    @ApiOperation("注册账号")
    @ApiImplicitParam(name = "register", value = "账号注册", paramType = "body", dataType = "RegisterVo")
    public RestResponse register(@Validated @RequestBody RegisterVo register) {
        return RestResponse.success(userService.register(register));
    }

    @DeleteMapping("/ids")
    @ApiOperation("根据主键ID批量删除")
    @ApiImplicitParam(name = "ids", value = "主键ID集合", paramType = "query", dataType = "String", allowMultiple = true)
    public RestResponse delete(@RequestParam List<String> ids) {
        return RestResponse.success(userService.batchDelete(ids, "id", User.class));
    }

    @PutMapping("/put")
    @ApiOperation("修改")
    @PreAuthorize("hasAuthority('user:put')")
    @ApiImplicitParam(name = "user", value = "用户表", paramType = "body", dataType = "User")
    public RestResponse update(@RequestBody User user) {
        return RestResponse.success(userService.updateNotNull(user));
    }
}