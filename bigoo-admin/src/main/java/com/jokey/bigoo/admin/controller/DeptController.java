package com.jokey.bigoo.admin.controller;

import com.github.pagehelper.PageInfo;
import com.jokey.bigoo.admin.entity.Dept;
import com.jokey.bigoo.admin.service.DeptService;
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
@Api(tags = "部门表")
@RequestMapping(value = "/v1/dept", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class DeptController extends BaseController {

    @Autowired
    private DeptService deptService;

    @GetMapping("/id")
    @ApiOperation("根据ID查询")
    @ApiImplicitParam(name = "id", value = "主键ID", paramType = "query", dataType = "String")
    public RestResponse<Dept> find(@RequestParam String id) {
        return RestResponse.success(deptService.selectByKey(id));
    }

    @GetMapping("/page")
    @ApiOperation("分页查询")
    public RestResponse<PageInfo<Dept>> page(Page page) {
        return RestResponse.success(deptService.selectByPage(page));
    }

    @PostMapping("/save")
    @ApiOperation("新增")
    @ApiImplicitParam(name = "dept", value = "部门表", paramType = "body", dataType = "Dept")
    public RestResponse insert(@RequestBody Dept dept) {
        return RestResponse.success(deptService.save(dept));
    }

    @DeleteMapping("/ids")
    @ApiOperation("根据主键ID批量删除")
    @ApiImplicitParam(name = "ids", value = "主键ID集合", paramType = "query", dataType = "String", allowMultiple = true)
    public RestResponse delete(@RequestParam List<String> ids) {
        return RestResponse.success(deptService.batchDelete(ids, "id", Dept.class));
    }

    @PutMapping("/put")
    @ApiOperation("修改")
    @ApiImplicitParam(name = "dept", value = "部门表", paramType = "body", dataType = "Dept")
    public RestResponse update(@RequestBody Dept dept) {
        return RestResponse.success(deptService.updateNotNull(dept));
    }
}