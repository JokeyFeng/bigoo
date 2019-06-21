package com.jokey.bigoo.admin.service.impl;


import com.jokey.bigoo.admin.entity.Dict;
import com.jokey.bigoo.admin.mapper.DictMapper;
import com.jokey.bigoo.admin.service.DictService;
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
public class DictServiceImpl extends BaseServiceImpl<Dict> implements DictService {

    @Autowired
    private DictMapper dictMapper;

    @Override
    protected MyMapper<Dict> getMapper() {
        return dictMapper;
    }
}