package com.jokey.bigoo.admin.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Id;
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
    @Id
    @ApiModelProperty("字典ID")
    private Long dictId;

    /**
     * 键
     */
    @ApiModelProperty("键")
    private Long key;

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