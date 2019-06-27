package com.jokey.bigoo.exception;

import com.jokey.bigoo.mvc.ResponseEnum;
import lombok.Data;

/**
 * @author Zhengjingfeng
 * created 2019/6/19 11:10
 * comment
 */
@Data
public class MyException extends RuntimeException {

    private static final long serialVersionUID = 3745209773495636297L;

    /**
     * 错误编码
     */
    private Integer errorCode;
    /**
     * 错误信息
     */
    private String errorMessage;

    public MyException(ResponseEnum resq) {
        super();
        this.errorCode = resq.getCode();
        this.errorMessage = resq.getMessage();
    }

}
