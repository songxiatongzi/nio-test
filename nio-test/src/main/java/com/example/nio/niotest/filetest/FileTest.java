package com.example.nio.niotest.filetest;


import com.example.nio.niotest.response.ApiResponse;
import com.example.nio.niotest.vo.User;
import com.sun.deploy.net.HttpUtils;
import org.aspectj.util.FileUtil;

import javax.xml.ws.Response;
import java.io.File;

/**
 * @author songxia tongzi
 * @date 2020/12/2 18:07
 */
public class FileTest {

//    public static void main(String[] args) {
//
//        File file = new File("G:/新建文本文档.txt");
//        checkFile(file,0);
//    }
//
//    private static void checkFile(File file, int leave) {
//        for(int i = 0;i <=leave;i++){
//            System.out.println("-");
//        }
//        String name = file.getName();
//
//    }
    public static void main(String[] args) {
        User user = new User();
        user.setAge("12");
        user.setName("---");
        ApiResponse<User> apiResponse = ApiResponse.ok(null);

        // 失败
        if(!"0".equals(apiResponse.getStatus())){
            System.out.println("----------");
            if(apiResponse.getData()!=null){
                System.out.println("data不为null");
            }
        }
    }
}
