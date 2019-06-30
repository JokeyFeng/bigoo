package com.jokey.bigoo.admin.controller;

import com.github.pagehelper.PageInfo;
import com.jokey.bigoo.admin.entity.RoleMenu;
import com.jokey.bigoo.admin.service.RoleMenuService;
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
@Api(tags = "角色资源(菜单)关系表")
@RequestMapping(value = "/v1/roleMenu", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class RoleMenuController extends BaseController {

    @Autowired
    private RoleMenuService roleMenuService;

    @GetMapping("/id")
    @ApiOperation("根据ID查询")
    @ApiImplicitParam(name = "id", value = "主键ID", paramType = "query", dataType = "String")
    public RestResponse<RoleMenu> find(@RequestParam String id) {
        return RestResponse.success(roleMenuService.selectByKey(id));
    }

    @GetMapping("/page")
    @ApiOperation("分页查询")
    public RestResponse<PageInfo<RoleMenu>> page(Page page) {
        return RestResponse.success(roleMenuService.selectByPage(page));
    }

    @PostMapping("/save")
    @ApiOperation("新增")
    @ApiImplicitParam(name = "roleMenu", value = "角色资源(菜单)关系表", paramType = "body", dataType = "RoleMenu")
    public RestResponse insert(@RequestBody RoleMenu roleMenu) {
        return RestResponse.success(roleMenuService.save(roleMenu));
    }

    @DeleteMapping("/ids")
    @ApiOperation("根据主键ID批量删除")
    @ApiImplicitParam(name = "ids", value = "主键ID集合", paramType = "query", dataType = "String", allowMultiple = true)
    public RestResponse delete(@RequestParam List<String> ids) {
        return RestResponse.success(roleMenuService.batchDelete(ids, "id", RoleMenu.class));
    }

    @PutMapping("/put")
    @ApiOperation("修改")
    @ApiImplicitParam(name = "roleMenu", value = "角色资源(菜单)关系表", paramType = "body", dataType = "RoleMenu")
    public RestResponse update(@RequestBody RoleMenu roleMenu) {
        return RestResponse.success(roleMenuService.updateNotNull(roleMenu));
    }
}