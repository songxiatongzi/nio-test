package com.example.nio.niotest.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author songxia tongzi
 * @date 2020/12/30 17:55
 */
public class Test02 {

    public static void main(String[] args) {

        String specialdiscount = "0";
        Config config = new Config();
        config.setParavalue("0");
//        config.setPlancode("1,2,3,4,5");
        config.setParacode("specialdiscount");
        List<String> customerclassifierfloat = new ArrayList<>();
        if("specialdiscount".equals(config.getParacode())) {
//            String plancode = "";
//            if (config.getPlancode() != null && config.getPlancode() != "") {
//                System.out.println(config.getPlancode());
//                plancode = config.getPlancode().replaceAll(",", "、");
//            }
//            String cardimension = "";
//            String carfloat = "";
//            if(config.getParavalue() != null && config.getParavalue() != "") {
//                cardimension = config.getParavalue().substring(0, 1);
//                if(config.getParavalue().length() == 3){
//                    carfloat = config.getParavalue().substring(1, 3);
//                }
//            }
//            String customerclassifier =  plancode + ";" + cardimension + ";" + carfloat ;
//            customerclassifierfloat.add(customerclassifier);
            specialdiscount = config.getParavalue();
        }
        System.out.println(specialdiscount);
        System.out.println(customerclassifierfloat);
        // {
        //
        // }
    }
}
