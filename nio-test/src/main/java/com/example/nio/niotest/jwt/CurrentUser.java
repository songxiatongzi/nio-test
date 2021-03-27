package com.example.nio.niotest.jwt;

import lombok.Data;

/**
 * @author songxia tongzi
 * @date 2020/10/26 15:41
 */
@Data
public class CurrentUser {
    private String uid;
    private String userName;
    private String realName;
    private String deviceId;
}
