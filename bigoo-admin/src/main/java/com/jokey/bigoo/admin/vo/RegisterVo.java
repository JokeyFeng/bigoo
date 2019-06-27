package com.jokey.bigoo.admin.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author Zhengjingfeng
 * created 2019/6/27 11:35
 * comment
 */
@Data
public class RegisterVo implements Serializable {

    private static final long serialVersionUID = -69547371499629997L;

    @NotBlank(message = "账号必填")
    private String username;

    @NotBlank(message = "密码必填")
    private String password;
}
