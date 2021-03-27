package com.example.nio.niotest.vo;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

/**
 * @author songxia tongzi
 * @date 2020/11/8 19:46
 */
@Data
@XStreamAlias("user")
public class User {

    String name;
    String age;

    public User() {
    }

    public User(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }
}
