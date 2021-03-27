package com.example.nio.niotest.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author songxia tongzi
 * @date 2020/10/24 17:45
 */
@Component
public class ScheduledTask {

    /**
     * 1. 添加注解 @EnableScheduling
     * 可以用来定时发短信
     * 定时任务
     *
     * corn表达式在linux使用广泛，具体可以参考cron表达式详解以及在线Cron表达式生成器
     * initialDelay：启动后多久开始执行，单位时毫秒
     * fixedRate：下次执行时间，任务开始运行的时候就计时。
     * fixedDelay：下次执行时间，fixedDelay等任务进行完了才开始计时
     * 关于fixedRate和fixedDelay的运行效果接下来详述,下面时运行一段时间的效果：
     */
    @Scheduled(cron = "5 0 0 * * ?")
    public void scheduledTask01(){
        System.out.println("定时任务01");
    }

}
