package com.example.nio.niotest.vo;

import java.lang.reflect.Field;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 * @author songxia tongzi
 * @date 2020/11/14 14:06
 */
public class Test {

    public static void main(String[] args) {
//        String asd = "asd";
//        String asd1 = "asd";
//
//
//        System.out.println(asd == asd1);
//        System.out.println(asd.equals(asd1));
//        User user = new User();
//        user.setAge("12");
//        user.setName("hello Test");
//        test(user);
        List<User> listUser = new ArrayList<>(16);
        if(null != listUser && listUser.size() == 0){
            System.out.println("listuser为空");
        }
    }

    public static <T> void test(T t){
//        Class<?> aClass = t.getClass();
//        Field[] declaredFields = aClass.getDeclaredFields();
//        for (Field field : declaredFields){
//            field.setAccessible(true);
//        }

        List<User> listUser = new ArrayList<>(16);
        if(null == listUser){
            System.out.println("listuser为空");
        }
    }
}
