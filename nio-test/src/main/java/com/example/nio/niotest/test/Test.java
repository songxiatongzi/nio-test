package com.example.nio.niotest.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.http.client.utils.DateUtils;
import org.springframework.util.FileCopyUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

/**
 * @author songxia tongzi
 * @date 2020/12/10 22:45
 */
public class Test {
    public static void main(String[] args) throws ParseException {
//        ArrayList<User> users = new ArrayList<>();
//
//        users.add(new User("zhangsan","12"));
//        users.add(new User("lisi","12"));
//        users.add(new User("li","12"));
//        ArrayList<User1> users1 = new ArrayList<>();
//
//        users1.add(new User1("zhangsan","12"));
//        users1.add(new User1("lisi","12"));
//        users1.add(new User1("li","12"));
//        users1.forEach(user1 -> {
//            User user = new User();
//            user.setName(user1.getName());
//
//        });
//        if(users.containsAll(users1)){
//            System.out.println("---------------");
//        }
//        if(users1.containsAll(users)){
//            System.out.println(":::::::::::::::");
//        }
//        if(users.containsAll(users1) && users1.containsAll(users)){
//            System.out.println("true");
//        }

       // FileCopyUtils.copy("",);

        String date = getDate("2021-12-17T08:00:00.000+0800");

        System.out.println(date);

        int i = 300;
        int y = 1000;
        int sum = i / y;
        System.out.println(sum);

        int i1 = 300;
        int y1 = 1000;
        int sum1 = i1 % y1;
        System.out.println(sum1);
    }

    public static String getDate(String oldDateStr) throws ParseException {

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date date = df.parse(oldDateStr);
        SimpleDateFormat df1 = new SimpleDateFormat ("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK);
        Date date1 =  df1.parse(date.toString());
        DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df2.format(date1);
    }
}















@Data
@NoArgsConstructor
@AllArgsConstructor
class User{
    String name;
    String age;
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class User1{
    String Name;
    String Age;
}