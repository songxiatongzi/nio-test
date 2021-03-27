package com.example.nio.niotest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @EnableScheduling --- 定时任务编辑
 *
 * NIO-test
 * @author songxiatongzi
 */
@SpringBootApplication
@EnableScheduling
public class NioTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(NioTestApplication.class, args);
	}

}
