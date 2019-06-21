package com.jokey.bigoo.admin.mapper;

import com.jokey.bigoo.admin.entity.User;
import com.jokey.bigoo.mvc.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * @author Zhengjingfeng
 * created 2019/6/21 9:39
 * comment
 */
@Mapper
@Component
public interface UserMapper extends MyMapper<User> {

    /**
     * 通过账号查询用户
     *
     * @param username
     * @return
     */
    User getUserByUsername(@Param("username") String username);

}
