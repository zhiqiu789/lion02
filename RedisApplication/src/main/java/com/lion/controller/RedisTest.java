package com.lion.controller;

import com.lion.serviceInterface.RedisInterface;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.Jedis;

/**
 * @Author Jipengchao
 * @CreatedTime: 2018/10/8 9:17
 */

public class RedisTest {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext_redis.xml");
        RedisInterface redisInterface = context.getBean(RedisInterface.class);
        Jedis jedis=new Jedis();
        redisInterface.set("lion","秋高气爽",jedis);
        String result = redisInterface.get("lion");
        System.out.println(result);
    }

}
