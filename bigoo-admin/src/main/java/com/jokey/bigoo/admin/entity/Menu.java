package com.jokey.bigoo.admin.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @author :jokey
 * Date:2019年6月21日
 * Description:资源菜单表
 */
@Data
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 菜单/按钮ID
     */
    @Id
    @ApiModelProperty("菜单/按钮ID")
    private Long menuId;

    /**
     * 上级菜单ID
     */
    @ApiModelProperty("上级菜单ID")
    private Long parentId;

    /**
     * 菜单/按钮名称
     */
    @ApiModelProperty("菜单/按钮名称")
    private String menuName;

    /**
     * 菜单URL
     */
    @ApiModelProperty("菜单URL")
    private String url;

    /**
     * 权限标识
     */
    @ApiModelProperty("权限标识")
    private String permission;

    /**
     * 图标
     */
    @ApiModelProperty("图标")
    private String icon;

    /**
     * 类型 0菜单 1按钮
     */
    @ApiModelProperty("类型 0菜单 1按钮")
    private String type;

    /**
     * 排序
     */
    @ApiModelProperty("排序")
    private Long orderNum;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private Date createTime;

    /**
     * 修改时间
     */
    @ApiModelProperty("修改时间")
    private Date modifyTime;

}