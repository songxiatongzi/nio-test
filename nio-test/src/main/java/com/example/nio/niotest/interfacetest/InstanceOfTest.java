package com.example.nio.niotest.interfacetest;

import com.example.nio.niotest.vo.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @author songxia tongzi
 * @date 2020/11/21 11:03
 */
public class InstanceOfTest {

    public static void main(String[] args) {
        List<User> lists = new ArrayList<User>();
        displayObjectClass(lists);
    }

    private static void displayObjectClass(List<User> lists) {

        //它的作用是测试它左边的对象是否是它右边的类 的实例，返回 boolean 的数据类型。
        if(lists instanceof  ArrayList){
            System.out.println("true");
        }
    }

}
