package com.jokey.bigoo.admin.mapper;

import com.jokey.bigoo.admin.entity.Role;
import com.jokey.bigoo.mvc.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
* @author jokey
* Date 2019年6月21日
*/
@Mapper
@Component
public interface RoleMapper extends MyMapper<Role> {
}