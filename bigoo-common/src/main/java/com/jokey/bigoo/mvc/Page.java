package com.jokey.bigoo.mvc;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Zhengjingfeng
 * created 2019/6/19 11:25
 * comment
 */
@Data
public class Page implements Serializable {

    private static final long serialVersionUID = -3394407338775623408L;

    /**
     * 页码，从1开始
     */
    private Integer pageNum = 1;
    /**
     * 每页的数量,默认10
     */
    private Integer pageSize = 10;
    /**
     * 查询条件的参数
     */
    /*
    private Map<String, Object> params = new HashMap<>();
    */

    /**
     * 排序
     */
    /*
    private Map<String, Integer> sort = new LinkedHashMap<>();
    */

    /**
     * 排序
     */
    private String orderBy;
}
