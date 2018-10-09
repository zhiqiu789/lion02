package com.lion.serviceImpl;

import com.lion.annontation.SkipRedis;
import com.lion.serviceInterface.RedisInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author Jipengchao
 * @CreatedTime: 2018/9/28 20:28
 */
@Component
public class RedisClient implements RedisInterface {
    @Autowired
    private JedisPool jedisPool;//从配置文件中注入 可以用xml文件，也可以用注解配置类 RedisConfig
    @Value("${jedis.password}")
    private String password;//从需要redis缓存的模块 的 controller中的配置文件application.yml注入进去;

//redis 有密码保护，需要输入密码进行身份验证
    @Override
    public Jedis getJedis() {
        Jedis jedis = jedisPool.getResource();
        if (password != null) {
            jedis.auth(password);
        }
        return jedis;
    }

//参数中加入 Jedis jedis， 就不用 每次 Jedis jedis = jedisPool.getResource();

    @Override
    public String set(String key, String value, Jedis jedis) {
        return jedis.set(key,value);
    }

    @Override
    public String get(String key) {
        Jedis jedis = jedisPool.getResource();
        return jedis.get(key);
    }

    @Override
    public String get(String key, Jedis jedis) {
        return jedis.get(key);
    }

    @Override
    public Boolean exists(String key) {
        return null;
    }

    @Override
    public Long hset(String key, Object value, Jedis jedis) {
        //直接传递对象的目的是什么
        //期望将对象中的属性一一放到redis中
        Class<?> aClass = value.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field field : declaredFields) {
            //获取对象中的每一个属性 同时 过滤所有不需要添加到redis 的属性 即属性有@SkipRedis注解的
            String name = field.getName();//属性名称
            SkipRedis skipRedis = field.getAnnotation(SkipRedis.class);
            if (skipRedis != null) {
                //说明此属性上有SkipRedis这个注解，此属性不应该存储到redis中，忽略此属性；
                continue;
            }
            try {
                PropertyDescriptor propertyDescriptor=new PropertyDescriptor(name,aClass);
                if (propertyDescriptor != null) {
                    /*propertyDescriptior是对一个bean对象属性的描述类，其中有两个方法：
                    ①getReadMethod ②getWriteMethod
                    分别返回bean对象中这个属性的get和set方法*/
                    Method readMethod = propertyDescriptor.getReadMethod();
                    if (readMethod != null) {//表示存在get 方法 即pojo中的get方法
                        //调用get方法 获取当前属性的值
                        Object result = readMethod.invoke(value);
                        //如果 属性值不为空， 就存到redis中  存对象 其实是把对象的一个个属性存进去
                        Long hset = jedis.hset(key, name, result == null ? null : result.toString());
                        return hset;//返回存入的结果， 即对redis 数据库影响的条数
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
         return null;//没有向redis 中存数据
    }



    @Override
    public Long hset(String key, String field, String value, Jedis jedis) {
        return jedis.hset(key,field,value);
    }

    @Override
    public <T> T hget(String key, Class<T> clazz, Jedis jedis) {
        return null;
    }

    @Override
    public Long expire(String key, int time, Jedis jedis) {
        return null;
    }

    @Override
    public Long del(Jedis jedis, String... key) {
        return null;
    }

    @Override
    public Boolean exist(String key, Jedis jedis) {
        return null;
    }

    @Override
    public Long ttl(String key, Jedis jedis) {
        return null;
    }

    @Override
    public Long incr(String key, Jedis jedis) {
        return null;
    }

    @Override
    public Long incr(String key, Jedis jedis, String... field) {
        return null;
    }

    @Override
    public Long hdel(String key, Jedis jedis, String... field) {
        return null;
    }

    @Override
    public String setex(String key, int seconds, String value, Jedis jedis) {
        return null;
    }

    @Override
    public String hmset(String key, Map<String, String> hash, Jedis jedis) {
        return null;
    }

    @Override
    public Long rpush(String key, Jedis jedis, String... strings) {
        return null;
    }

    @Override
    public Long lpush(String key, Jedis jedis, String... strings) {
        return null;
    }

    @Override
    public List<String> lrange(String key, long start, long end, Jedis jedis) {
        return null;
    }

    @Override
    public Set<String> keys(String pattern, Jedis jedis) {
        return null;
    }
}
