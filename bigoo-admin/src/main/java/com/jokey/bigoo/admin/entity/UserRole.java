package com.jokey.bigoo.admin.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * @author :jokey
 * Date:2019年6月21日
 * Description:用户角色关系表
 */
@Data
public class UserRole implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @ApiModelProperty("用户ID")
    private Long userId;

    /**
     * 角色ID
     */
    @ApiModelProperty("角色ID")
    private Long roleId;

}