package com.example.nio.niotest.interfacetest;

/**
 * @author songxia tongzi
 * @date 2020/11/20 17:56
 */
public class StudyImpl extends Test implements Study ,Eat{

    private String hhl;


    @Override
    public void test() {
        System.out.println("test");
    }

    @Override
    public void study() {
        System.out.println(Study.STU);
        System.out.println("StudyImpl 01");
    }

    public static void main(String[] args) {
        StudyImpl study = new StudyImpl();
        study.test();

    }

    @Override
    public void eat() {
        System.out.println("eat 01");
    }
}
