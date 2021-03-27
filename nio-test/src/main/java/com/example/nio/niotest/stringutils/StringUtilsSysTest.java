package com.example.nio.niotest.stringutils;

import com.example.nio.niotest.vo.User;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author songxia tongzi
 * @date 2020/10/31 9:39
 */
public class StringUtilsSysTest {

    public static void main(String[] args) {
        File javaHome = SystemUtils.getJavaHome();
        String path = javaHome.getPath();
        String name = javaHome.getName();
        System.out.println("name = " + name + ", path = " + path);

        Map<String,Object> hashMap = new HashMap<>();
        Map<String,String> hashMap01 = new HashMap<>();
        hashMap.put("1",hashMap);
        // java version
        String[][] strings = new String[][]{
                {"0","显示标签","0","全选",""},
                {"0","显示标签","1","最新","#FF3333"},
                {"0","显示标签","2","热门","#FE8A00"},
                //子公司为财险时显示
                {"1","产品线","0","车险","#EB6B93"},
                {"1","产品线","1","意外险","#EB6B93"},
                {"1","产品线","2","健康险","#EB6B93"},
                {"1","产品线","3","责任险","#EB6B93"},
                {"1","产品线","4","家财险","#EB6B93"},
                {"1","产品线","5","货运险","#EB6B93"},
                {"1","产品线","6","组合产品","#EB6B93"},
                {"1","产品线","7","保证险","#EB6B93"},
                {"1","产品线","8","企财险","#EB6B93"},
                {"1","产品线","9","航空险","#EB6B93"},
                {"1","产品线","10","工程险","#EB6B93"},
                //子公司为财险时显示
                {"2","场景","0","爱车","#3ACA96"},
                {"2","场景","1","家庭","#3ACA96"},
                {"2","场景","2","健康","#3ACA96"},
                {"2","场景","3","意外","#3ACA96"},
                {"2","场景","4","旅行","#3ACA96"},
                {"2","场景","5","企业","#3ACA96"},
                {"2","场景","6","特定人群","#3ACA96"},
                // 子公司为寿险时显示
                {"3","产品类型","0","普通型","#43C4FD"},
                {"3","产品类型","1","分红型","#43C4FD"},
                {"3","产品类型","2","万能型","#43C4FD"},
                //子公司为寿险时显示
                {"4","客户群","0","少儿专属",""},
                {"4","客户群","1","老年专属",""},
                {"4","客户群","2","女性专属",""},
                {"4","客户群","3","男性专属",""},
                //子公司为寿险和健康险时显示
                {"5","期限","0","长险","#78A7FF"},
                {"5","期限","1","短险","#78A7FF"},
                //子公司为健康险时显示
                {"6","险种类型","0","重疾险","#43C4FD"},
                {"6","险种类型","1","医疗险","#43C4FD"},
                {"6","险种类型","2","护理险","#43C4FD"},
                {"6","险种类型","3","意外险","#43C4FD"},
                {"6","险种类型","4","税优","#43C4FD"}



        };
        String str01 = "1";
        String string = "3";
        for (int i= 0;i< strings.length;i++){
            if(str01.equals(strings[i][0].trim())){
               if(string.equals(strings[i][2].trim())){
                   String trim2 = strings[i][1].trim();
                   System.out.println(trim2);
                   String trim = strings[i][3].trim();
                   System.out.println(trim);
                   String trim1 = strings[i][4].trim();
                   System.out.println(trim1);
               }
            }
        }
        Map<String, List<String>> stringListHashMap = new HashMap<>();

        User user = new User("1","12");
        User user1 = new User("1", "12");
        User user2 = new User("2", "12");

//        Set<User> userSet = new TreeSet<User>();
//        userSet.add(new User("1","12"));
//        userSet.add(new User("1","12"));
//        userSet.add(new User("2", "12"));

       // System.out.println(userSet);
        Set<User> users = new HashSet<User>();
        users.add(new User("1","12"));
        users.add(new User("1","12")); users.add(new User("1","13"));users.add(new User("1","14"));
        users.add(new User("2", "12"));users.add(new User("2", "13"));
        users.add(new User(null, null));
        System.out.println(users);
        Set<User> collect = users.stream().filter(u -> !StringUtils.equals(null, u.getName())).collect(Collectors.toSet());

        System.out.println(collect);

        /*
        // Accumulate names into a List
     List<String> list = people.stream().map(Person::getName).collect(Collectors.toList());

     // Accumulate names into a TreeSet
     Set<String> set = people.stream().map(Person::getName).collect(Collectors.toCollection(TreeSet::new));

     // Convert elements to strings and concatenate them, separated by commas
     String joined = things.stream()
                           .map(Object::toString)
                           .collect(Collectors.joining(", "));

     // Compute sum of salaries of employee
     int total = employees.stream()
                          .collect(Collectors.summingInt(Employee::getSalary)));

     // Group employees by department
     Map<Department, List<Employee>> byDept
         = employees.stream()
                    .collect(Collectors.groupingBy(Employee::getDepartment));

         */
        Map<String, List<User>> collect1 = collect.stream()
                .collect(Collectors.groupingBy(coll -> coll.getName()));

        System.out.println(collect1);
       
    }
}
