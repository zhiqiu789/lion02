package com.lion.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author Jipengchao
 * @CreatedTime: 2018/9/29 17:10
 */
@SpringBootApplication(scanBasePackages = "com.lion")
public class ApplicationStarter {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationStarter.class,args);
    }
}
