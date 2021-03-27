package com.example.nio.niotest.response;

import org.apache.catalina.User;
import org.aspectj.weaver.ast.Test;

/**
 * response 返回测试
 * @author songxia tongzi
 * @date 2020/10/26 10:46
 */
public class ResponseApiTest {

    public static void main(String[] args) {

        //test();
        System.out.println(test());
//        TestResonse testResonse = new TestResonse();

    }

    private static ApiResponse<TestResonse> test() {
        TestResonse testResonse = new TestResonse();
        testResonse.setTest("testResponse");
        return ApiResponse.ok(testResonse);
    }
}
