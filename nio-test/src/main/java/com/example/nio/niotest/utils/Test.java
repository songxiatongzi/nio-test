package com.example.nio.niotest.utils;

import com.example.nio.niotest.vo.User;

/**
 * @author songxia tongzi
 * @date 2020/11/14 23:22
 */
public class Test {

    public static void main(String[] args) {

        User user = new User();
        user.setName("libel");
        user.setAge("11");
        String s = XmlUtils.toXML(user,"user");
        System.out.println(s);

//        Object o = XmlUtils.toObject(s, user.getClass());
//        System.out.println(o);
        User user1 = XmlUtils.xmlToObject(s, User.class);
        System.out.println(user1);
    }
}
