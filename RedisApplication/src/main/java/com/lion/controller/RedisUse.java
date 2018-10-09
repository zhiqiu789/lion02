package com.lion.controller;

import redis.clients.jedis.Jedis;

/**
 * @Author Jipengchao
 * @CreatedTime: 2018/10/8 11:08
 */

public class RedisUse {
    public static void main(String[] args) {
        Jedis jedis=new Jedis("10.9.251.200",8100);
        jedis.auth("redis001");
        jedis.set("heheh","哈哈哈");
        String heheh = jedis.get("heheh");
        System.out.println(heheh);
    }
}
