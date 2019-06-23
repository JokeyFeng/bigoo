package com.jokey.bigoo.admin.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * @author :jokey
 * Date:2019年6月21日
 * Description:角色资源(菜单)关系表
 */
@Data
public class RoleMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 角色ID
     */
    @ApiModelProperty("角色ID")
    private Long roleId;

    /**
     * 菜单/按钮ID
     */
    @ApiModelProperty("菜单/按钮ID")
    private Long menuId;

}