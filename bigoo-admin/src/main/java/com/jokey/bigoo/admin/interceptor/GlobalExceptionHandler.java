package com.jokey.bigoo.admin.interceptor;

import com.jokey.bigoo.exception.MyException;
import com.jokey.bigoo.mvc.ResponseEnum;
import com.jokey.bigoo.mvc.RestResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Zhengjingfeng
 * created 2019/6/21 18:15
 * comment
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public RestResponse handle(Exception e) {
        e.printStackTrace();
        return RestResponse.createResp(ResponseEnum.FAIL.getCode(), e.getMessage());
    }

    @ExceptionHandler(MyException.class)
    public RestResponse handle(MyException e) {
        e.printStackTrace();
        return RestResponse.createResp(e.getErrorCode(), e.getErrorMessage());
    }

    @ExceptionHandler(AccessDeniedException.class)
    public RestResponse handle(AccessDeniedException e) {
        e.printStackTrace();
        return RestResponse.fail(ResponseEnum.FORBIDDEN);
    }
}
