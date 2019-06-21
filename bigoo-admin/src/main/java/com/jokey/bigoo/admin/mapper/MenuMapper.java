package com.jokey.bigoo.admin.mapper;

import com.jokey.bigoo.admin.entity.Menu;
import com.jokey.bigoo.mvc.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author jokey
 * Date 2019年6月21日
 */
@Mapper
@Component
public interface MenuMapper extends MyMapper<Menu> {
    /**
     * 根据账号查询拥有的权限
     *
     * @param userName
     * @return
     */
    List<Menu> findUserPermissions(String userName);
}