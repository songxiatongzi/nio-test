package com.example.nio.niotest.date;

import java.time.LocalDate;
import java.time.Month;

/**
 * 日期
 * @author songxia tongzi
 * @date 2020/10/21 17:34
 */
public class DateUtils {

    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        int year = now.getYear();
        int monthValue = now.getMonthValue();
        Month month = now.getMonth();
        int value = month.getValue();
        System.out.println(
                value
        );
        System.out.println(monthValue);
        System.out.println(year);
        System.out.println(now.toString());

        String localDateStr = LocalDate.of(2020, 10, 19).toString();
        System.out.println(localDateStr);

    }
}
