package com.jokey.bigoo.admin.controller;

import com.github.pagehelper.PageInfo;
import com.jokey.bigoo.admin.entity.Dict;
import com.jokey.bigoo.admin.service.DictService;
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
@Api(tags = "字典表")
@RequestMapping(value = "/v1/dict", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class DictController extends BaseController {

    @Autowired
    private DictService dictService;

    @GetMapping("/id")
    @ApiOperation("根据ID查询")
    @ApiImplicitParam(name = "id", value = "主键ID", paramType = "query", dataType = "String")
    public RestResponse<Dict> find(@RequestParam String id) {
        return RestResponse.success(dictService.selectByKey(id));
    }

    @GetMapping("/page")
    @ApiOperation("分页查询")
    public RestResponse<PageInfo<Dict>> page(Page page) {
        return RestResponse.success(dictService.selectByPage(page));
    }

    @PostMapping("/save")
    @ApiOperation("新增")
    @ApiImplicitParam(name = "dict", value = "字典表", paramType = "body", dataType = "Dict")
    public RestResponse insert(@RequestBody Dict dict) {
        return RestResponse.success(dictService.save(dict));
    }

    @DeleteMapping("/ids")
    @ApiOperation("根据主键ID批量删除")
    @ApiImplicitParam(name = "ids", value = "主键ID集合", paramType = "query", dataType = "String", allowMultiple = true)
    public RestResponse delete(@RequestParam List<String> ids) {
        return RestResponse.success(dictService.batchDelete(ids, "id", Dict.class));
    }

    @PutMapping("/put")
    @ApiOperation("修改")
    @ApiImplicitParam(name = "dict", value = "字典表", paramType = "body", dataType = "Dict")
    public RestResponse update(@RequestBody Dict dict) {
        return RestResponse.success(dictService.updateNotNull(dict));
    }
}