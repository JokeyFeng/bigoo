package com.jokey.bigoo.admin.interceptor;

import com.jokey.bigoo.mvc.RestResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Zhengjingfeng
 * created 2019/6/21 18:15
 * comment
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public RestResponse handle(Exception e) {
        return RestResponse.fail(e.getMessage());
    }

    @ExceptionHandler(AccessDeniedException.class)
    public RestResponse handle(AccessDeniedException e) {
        return RestResponse.forbbiden();
    }
}
