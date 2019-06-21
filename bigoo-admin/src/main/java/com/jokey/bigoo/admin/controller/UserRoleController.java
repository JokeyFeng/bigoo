package com.jokey.bigoo.admin.controller;

import com.github.pagehelper.PageInfo;
import com.jokey.bigoo.admin.entity.UserRole;
import com.jokey.bigoo.admin.service.UserRoleService;
import com.jokey.bigoo.mvc.BaseController;
import com.jokey.bigoo.mvc.Page;
import com.jokey.bigoo.mvc.RestResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author jokey
 * Date 2019年6月21日
 * Version 1.0
 */
@RestController
@Api(tags = "用户角色关系表")
@RequestMapping(value = "/v1/userRole", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserRoleController extends BaseController {

    @Autowired
    private UserRoleService userRoleService;

    @GetMapping("/id")
    @ApiOperation("根据ID查询")
    @ApiImplicitParam(name = "id", value = "主键ID", paramType = "query", dataType = "String")
    public RestResponse<UserRole> find(@RequestParam String id) {
        return RestResponse.success(userRoleService.selectByKey(id));
    }

    @GetMapping("/page")
    @ApiOperation("分页查询")
    public RestResponse<PageInfo<UserRole>> page(Page page) {
        return RestResponse.success(userRoleService.selectByPage(page));
    }

    @PostMapping("/save")
    @ApiOperation("新增")
    @ApiImplicitParam(name = "userRole", value = "用户角色关系表", paramType = "body", dataType = "UserRole")
    public RestResponse insert(@RequestBody UserRole userRole) {
        return RestResponse.success(userRoleService.save(userRole));
    }

    @DeleteMapping("/ids")
    @ApiOperation("根据主键ID批量删除")
    @ApiImplicitParam(name = "ids", value = "主键ID集合", paramType = "query", dataType = "String", allowMultiple = true)
    public RestResponse delete(@RequestParam List<String> ids) {
        return RestResponse.success(userRoleService.batchDelete(ids, "id", UserRole.class));
    }

    @PutMapping("/put")
    @ApiOperation("修改")
    @ApiImplicitParam(name = "userRole", value = "用户角色关系表", paramType = "body", dataType = "UserRole")
    public RestResponse update(@RequestBody UserRole userRole) {
        return RestResponse.success(userRoleService.updateNotNull(userRole));
    }
}