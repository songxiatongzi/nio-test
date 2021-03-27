package com.example.nio.niotest.controller;

import com.example.nio.niotest.response.ApiResponse;
import com.example.nio.niotest.response.TestResonse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author songxia tongzi
 * @date 2020/10/24 17:09
 */
@RestController
@RequestMapping("/aop")
public class AopTestController {

    @RequestMapping(value = "/curry",method = RequestMethod.GET)
    public void curry(){
        System.out.println("curry");
    }

    /**
     * 测试成功
     * {"status":0,"statusText":"Success","data":{"test":"test"}}
     * @return
     */
    @RequestMapping(value = "/responsetest",method = RequestMethod.GET)
    public ApiResponse<TestResonse> testResponse(){
        TestResonse testResonse = new TestResonse();
        testResonse.setTest("test");
        return ApiResponse.ok(testResonse);
    }
}
