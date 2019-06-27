package com.jokey.bigoo.mvc;

/**
 * @author Zhengjingfeng
 * created 2019/6/27 14:51
 * comment
 */
public enum ResponseEnum {
    /**
     * -1：失败
     */
    FAIL(-1, "失败"),
    /**
     * 0：成功
     */
    SUCCESS(0, "成功"),
    /**
     * 1000：请登录再访问
     */
    NEED_LOGIN(1000, "请登录再访问"),
    /**
     * 1001：用户名或密码不正确
     */
    BAD_CREDENTIAL(1001, "用户名或密码不正确"),
    /**
     * 1002：账号已存在
     */
    ACCOUNT_EXIST(1002, "账号已存在"),
    /**
     * 1003：登录凭证已过期
     */
    CREDENTIAL_EXPIRED(1003, "登录凭证已过期"),
    /**
     * 1004：账号已过期
     */
    ACCOUNT_EXPIRED(1004, "账号已过期"),
    /**
     * 1005：账号已被冻结
     */
    ACCOUNT_LOCKED(1005, "账号已被冻结"),
    /**
     * 1005：非法的登录凭证
     */
    ILLEGAL_CREDENTIAL(1006, "非法的登录凭证"),
    /**
     * 4000：很抱歉，您无权限访问该资源
     */
    FORBIDDEN(4000, "很抱歉，您无权限访问该资源");

    private Integer code;

    private String message;

    ResponseEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }}
