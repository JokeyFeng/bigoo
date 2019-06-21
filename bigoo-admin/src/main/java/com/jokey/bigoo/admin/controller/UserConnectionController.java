package com.jokey.bigoo.admin.controller;

import com.github.pagehelper.PageInfo;
import com.jokey.bigoo.admin.entity.UserConnection;
import com.jokey.bigoo.admin.service.UserConnectionService;
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
@Api(tags = "第三方社交账号登录表")
@RequestMapping(value = "/v1/userConnection", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserConnectionController extends BaseController {

    @Autowired
    private UserConnectionService userConnectionService;

    @GetMapping("/id")
    @ApiOperation("根据ID查询")
    @ApiImplicitParam(name = "id", value = "主键ID", paramType = "query", dataType = "String")
    public RestResponse<UserConnection> find(@RequestParam String id) {
        return RestResponse.success(userConnectionService.selectByKey(id));
    }

    @GetMapping("/page")
    @ApiOperation("分页查询")
    public RestResponse<PageInfo<UserConnection>> page(Page page) {
        return RestResponse.success(userConnectionService.selectByPage(page));
    }

    @PostMapping("/save")
    @ApiOperation("新增")
    @ApiImplicitParam(name = "userConnection", value = "第三方社交账号登录表", paramType = "body", dataType = "UserConnection")
    public RestResponse insert(@RequestBody UserConnection userConnection) {
        return RestResponse.success(userConnectionService.save(userConnection));
    }

    @DeleteMapping("/ids")
    @ApiOperation("根据主键ID批量删除")
    @ApiImplicitParam(name = "ids", value = "主键ID集合", paramType = "query", dataType = "String", allowMultiple = true)
    public RestResponse delete(@RequestParam List<String> ids) {
        return RestResponse.success(userConnectionService.batchDelete(ids, "id", UserConnection.class));
    }

    @PutMapping("/put")
    @ApiOperation("修改")
    @ApiImplicitParam(name = "userConnection", value = "第三方社交账号登录表", paramType = "body", dataType = "UserConnection")
    public RestResponse update(@RequestBody UserConnection userConnection) {
        return RestResponse.success(userConnectionService.updateNotNull(userConnection));
    }
}