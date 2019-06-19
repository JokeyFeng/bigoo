package com.jokey.bigoo.mvc;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author Zhengjingfeng
 * created 2019/6/19 11:31
 * comment
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
