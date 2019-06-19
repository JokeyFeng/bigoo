package com.jokey.bigoo.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Zhengjingfeng
 * created 2019/6/19 11:10
 * comment
 */
@Data
@AllArgsConstructor
public class MyException extends RuntimeException {
    /**
     * 错误编码
     */
    private Integer errorCode;
    /**
     * 错误信息
     */
    private String errorMessage;

}
