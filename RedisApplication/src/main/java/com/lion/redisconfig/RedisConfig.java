package com.lion.redisconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 用于配置jedispool的jedisPoolConfig
 */
@Configuration

public class RedisConfig {

    @Value("${jedis.host}")//从配置文件application.yml中注入进去;
    private String host;//主机名
    @Value("${jedis.port}")
    private int port;//端口号
    @Value("${jedis.maxTotal}")
    private int maxTotal;//最大连接数
    @Value("${jedis.minIdle}")
    private int minIdle;//最小空闲连接数
    @Value("${jedis.maxIdle}")
    private int maxIdle;//最大空闲连接数
    @Value("${jedis.maxWaitMillis}")
    private long maxWaitMillis;//最大等待时间,即为超时时间; 毫秒

    @Autowired
    private JedisPoolConfig jedisPoolConfig;

    @Bean//创建对象
    public JedisPool jedisPool(){
        JedisPool jedisPool = new JedisPool(jedisPoolConfig,host,port);
        return jedisPool;
    }

    @Bean
    public JedisPoolConfig jedisPoolConfig(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(maxTotal);
        jedisPoolConfig.setMinIdle(minIdle);
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
        return jedisPoolConfig;
    }

}
