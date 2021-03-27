package com.example.nio.niotest.logaspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * AOP的默认配置属性中，
 * spring.aop.auto属性默认是开启的，
 * 也就是说只要引入了AOP依赖后，
 * 默认已经增加了@EnableAspectJAutoProxy，
 * 不需要在程序主类中增加@EnableAspectJAutoProxy来启用。
 * @Aspect --- 定义切面类
 * @Component ---- 把切面加入到 ioc 容器中
 * @author songxia tongzi
 * @date 2020/10/24 16:37
 */
@Component
@Aspect
public class LogAspect {

    /**
     * public ---- 作用域
     * * ---- 返回任意类型
     * com.example.demo.aop.AopController 切点方法所有的类
     * 定义切入点，切入点为com.example.demo.aop.AopController中的所有函数
     */
    @Pointcut("execution(public * com.example.nio.niotest.controller.*.*(..))")
    public void LogAspect(){

    }

    @Before("LogAspect()")
    public void doBefore(){
        System.out.println("在方法之前进行执行");
    }

//    @After("LogAspect()")
//    public void doAfter(){
//        System.out.println("在方法之后进行执行");
//    }
//
//    /**
//     * 异常通知
//     */
//    @AfterThrowing("LogAspect()")
//    public void doAfterThrowing(){
//        System.out.println("异常通知");
//    }
//
//    /**
//     * 返回通知
//     */
//    @AfterReturning("LogAspect()")
//    public void doAfterReturning(){
//        System.out.println("返回通知");
//    }
//
//    /**
//     * 环绕通知
//     * @param pjp
//     */
//    @Around("LogAspect()")
//    public void doAround(ProceedingJoinPoint pjp){
//
//        try {
//            System.out.println("环绕通知-前置通知");
//            pjp.proceed();
//            System.out.println("环绕通知-后置通知");
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//        }
//    }
}
