package com.jokey.bigoo.mvc;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

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
        response.setCode(ResponseEnum.SUCCESS.getCode());
        response.setMessage(ResponseEnum.SUCCESS.getMessage());
        response.setData(data);
        return response;
    }

    public static RestResponse success() {
        RestResponse response = new RestResponse<>();
        response.setCode(ResponseEnum.SUCCESS.getCode());
        response.setMessage(ResponseEnum.SUCCESS.getMessage());
        return response;
    }

    public static RestResponse fail(ResponseEnum resp) {
        RestResponse response = new RestResponse<>();
        response.setCode(resp.getCode());
        response.setMessage(resp.getMessage());
        return response;
    }

    public static RestResponse createResp(@NonNull Integer code, @NonNull String message) {
        RestResponse response = new RestResponse<>();
        response.setCode(code);
        response.setMessage(message);
        return response;
    }
}
