package com.jokey.bigoo.admin.controller;

import com.github.pagehelper.PageInfo;
import com.jokey.bigoo.admin.entity.Role;
import com.jokey.bigoo.admin.service.RoleService;
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
@CrossOrigin("*")
@RestController
@Api(tags = "角色表")
@RequestMapping(value = "/v1/role", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class RoleController extends BaseController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/id")
    @ApiOperation("根据ID查询")
    @ApiImplicitParam(name = "id", value = "主键ID", paramType = "query", dataType = "String")
    public RestResponse<Role> find(@RequestParam String id) {
        return RestResponse.success(roleService.selectByKey(id));
    }

    @GetMapping("/page")
    @ApiOperation("分页查询")
    public RestResponse<PageInfo<Role>> page(Page page) {
        return RestResponse.success(roleService.selectByPage(page));
    }

    @PostMapping("/save")
    @ApiOperation("新增")
    @ApiImplicitParam(name = "role", value = "角色表", paramType = "body", dataType = "Role")
    public RestResponse insert(@RequestBody Role role) {
        return RestResponse.success(roleService.save(role));
    }

    @DeleteMapping("/ids")
    @ApiOperation("根据主键ID批量删除")
    @ApiImplicitParam(name = "ids", value = "主键ID集合", paramType = "query", dataType = "String", allowMultiple = true)
    public RestResponse delete(@RequestParam List<String> ids) {
        return RestResponse.success(roleService.batchDelete(ids, "id", Role.class));
    }

    @PutMapping("/put")
    @ApiOperation("修改")
    @ApiImplicitParam(name = "role", value = "角色表", paramType = "body", dataType = "Role")
    public RestResponse update(@RequestBody Role role) {
        return RestResponse.success(roleService.updateNotNull(role));
    }
}