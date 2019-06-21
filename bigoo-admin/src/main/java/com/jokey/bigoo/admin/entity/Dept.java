package com.jokey.bigoo.admin.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * @author :jokey
 * Date:2019年6月21日
 * Description:部门表
 */
@Data
public class Dept implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 部门ID
     */
    @ApiModelProperty("部门ID")
    private BigInteger deptId;

    /**
     * 上级部门ID
     */
    @ApiModelProperty("上级部门ID")
    private BigInteger parentId;

    /**
     * 部门名称
     */
    @ApiModelProperty("部门名称")
    private String deptName;

    /**
     * 排序
     */
    @ApiModelProperty("排序")
    private BigInteger orderNum;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private Timestamp createTime;

}