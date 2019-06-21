package com.jokey.bigoo.mvc;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Zhengjingfeng
 * created 2019/6/20 17:46
 * comment
 */
@Data
@NoArgsConstructor
public class RestResponse<T> {

    private Integer code;

    private String message;

    private T data;

    public static <T> RestResponse<T> success(T data) {
        RestResponse<T> response = new RestResponse<>();
        response.setCode(200);
        response.setMessage("成功");
        response.setData(data);
        return response;
    }

    public static <T> RestResponse<T> fail(String message) {
        RestResponse<T> response = new RestResponse<>();
        response.setCode(-1);
        response.setMessage(message);
        return response;
    }

    public static <T> RestResponse<T> forbbiden() {
        RestResponse<T> response = new RestResponse<>();
        response.setCode(4000);
        response.setMessage("没有权限");
        return response;
    }
}
