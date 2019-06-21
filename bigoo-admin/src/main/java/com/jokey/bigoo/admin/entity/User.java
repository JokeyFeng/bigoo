package com.jokey.bigoo.admin.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Zhengjingfeng
 * created 2019/6/19 10:49
 * comment
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 9050365665911965114L;

    /**
     * 用户id
     */
    private long userId;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 性别 0男 1女
     */
    private byte sex;
    /**
     * 部门id
     */
    private long deptId;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 联系电话
     */
    private String mobile;
    /**
     * 状态 0锁定 1有效
     */
    private byte status;
    /**
     * 最近登录时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date lastLoginTime;
    /**
     * 主题
     */
    private String theme;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 描述
     */
    private String description;
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;
    /**
     * 修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date modifyTime;

    /**
     * 数据库字段
     */
    public static final String USERNAME = "username";

    /**
     * 账户状态
     */
    public static final String STATUS_VALID = "1";

    public static final String STATUS_LOCK = "0";

    /**
     * 性别
     */
    public static final String SEX_MALE = "0";

    public static final String SEX_FEMALE = "1";
}
