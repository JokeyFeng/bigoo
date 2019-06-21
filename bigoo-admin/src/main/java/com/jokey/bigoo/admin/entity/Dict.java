package com.jokey.bigoo.admin.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * @author :jokey
 * Date:2019年6月21日
 * Description:字典表
 */
@Data
public class Dict implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 字典ID
     */
    @ApiModelProperty("字典ID")
    private BigInteger dictId;

    /**
     * 键
     */
    @ApiModelProperty("键")
    private BigInteger key;

    /**
     * 值
     */
    @ApiModelProperty("值")
    private String value;

    /**
     * 字段名称
     */
    @ApiModelProperty("字段名称")
    private String fieldName;

    /**
     * 表名
     */
    @ApiModelProperty("表名")
    private String tableName;

}