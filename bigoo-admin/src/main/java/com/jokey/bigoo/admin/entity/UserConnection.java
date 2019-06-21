package com.jokey.bigoo.admin.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * @author :jokey
 * Date:2019年6月21日
 * Description:第三方社交账号登录表
 */
@Data
public class UserConnection implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @ApiModelProperty("")
    private String userId;

    /**
     *
     */
    @ApiModelProperty("")
    private String providerId;

    /**
     *
     */
    @ApiModelProperty("")
    private String providerUserId;

    /**
     *
     */
    @ApiModelProperty("")
    private Integer rank;

    /**
     *
     */
    @ApiModelProperty("")
    private String displayName;

    /**
     *
     */
    @ApiModelProperty("")
    private String profileUrl;

    /**
     *
     */
    @ApiModelProperty("")
    private String imageUrl;

    /**
     *
     */
    @ApiModelProperty("")
    private String accessToken;

    /**
     *
     */
    @ApiModelProperty("")
    private String secret;

    /**
     *
     */
    @ApiModelProperty("")
    private String refreshToken;

    /**
     *
     */
    @ApiModelProperty("")
    private BigInteger expireTime;

}