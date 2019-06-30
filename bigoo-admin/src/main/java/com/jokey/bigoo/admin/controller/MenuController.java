package com.jokey.bigoo.admin.controller;

import com.github.pagehelper.PageInfo;
import com.jokey.bigoo.admin.entity.Menu;
import com.jokey.bigoo.admin.service.MenuService;
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
@Api(tags = "资源菜单表")
@RequestMapping(value = "/v1/menu", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class MenuController extends BaseController {

    @Autowired
    private MenuService menuService;

    @GetMapping("/id")
    @ApiOperation("根据ID查询")
    @ApiImplicitParam(name = "id", value = "主键ID", paramType = "query", dataType = "String")
    public RestResponse<Menu> find(@RequestParam String id) {
        return RestResponse.success(menuService.selectByKey(id));
    }

    @GetMapping("/page")
    @ApiOperation("分页查询")
    public RestResponse<PageInfo<Menu>> page(Page page) {
        return RestResponse.success(menuService.selectByPage(page));
    }

    @PostMapping("/save")
    @ApiOperation("新增")
    @ApiImplicitParam(name = "menu", value = "资源菜单表", paramType = "body", dataType = "Menu")
    public RestResponse insert(@RequestBody Menu menu) {
        return RestResponse.success(menuService.save(menu));
    }

    @DeleteMapping("/ids")
    @ApiOperation("根据主键ID批量删除")
    @ApiImplicitParam(name = "ids", value = "主键ID集合", paramType = "query", dataType = "String", allowMultiple = true)
    public RestResponse delete(@RequestParam List<String> ids) {
        return RestResponse.success(menuService.batchDelete(ids, "id", Menu.class));
    }

    @PutMapping("/put")
    @ApiOperation("修改")
    @ApiImplicitParam(name = "menu", value = "资源菜单表", paramType = "body", dataType = "Menu")
    public RestResponse update(@RequestBody Menu menu) {
        return RestResponse.success(menuService.updateNotNull(menu));
    }
}