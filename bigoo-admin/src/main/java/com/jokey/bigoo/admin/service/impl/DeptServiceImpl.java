package com.jokey.bigoo.admin.service.impl;

import com.jokey.bigoo.admin.entity.Dept;
import com.jokey.bigoo.admin.mapper.DeptMapper;
import com.jokey.bigoo.admin.service.DeptService;
import com.jokey.bigoo.mvc.BaseServiceImpl;
import com.jokey.bigoo.mvc.MyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author jokey
 * Date 2019年6月21日
 * Version 1.0
 */
@Service
public class DeptServiceImpl extends BaseServiceImpl<Dept> implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    protected MyMapper<Dept> getMapper() {
        return deptMapper;
    }
}