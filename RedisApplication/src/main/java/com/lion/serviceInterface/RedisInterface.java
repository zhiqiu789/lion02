package com.lion.serviceInterface;

import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author Jipengchao
 * @CreatedTime: 2018/9/28 16:51
 */

public interface RedisInterface {
    /**
     * 获取连接
      * @return
     */
    Jedis getJedis();

    /**
     * 向redis 数据库中添加一个对象 jedis, 内容是字符串
     * @param key
     * @param value
     * @param jedis
     * @return
     */

    String set(String key,String value,Jedis jedis);

    /**
     * 根据key 获取内容
     * @param key
     * @return
     */
    String get(String key);

    /**
     * 获取对象Jedis中键是key 的内容
     * @param key
     * @param jedis
     * @return
     */
    String get(String key,Jedis jedis);

    /**
     * 判断是否存在
     * @param key
     * @return
     */
    Boolean exists(String key);

    /**
     * 添加一个对象
     * @param key
     * @param value
     * @param jedis
     * @return
     */
    Long hset(String key,Object value,Jedis jedis);

    /**
     * 添加属性
     * @param key
     * @param field
     * @param value
     * @param jedis
     * @return
     */
    Long hset(String key,String field,String value,Jedis jedis);

    <T> T hget(String key, Class<T> clazz, Jedis jedis);

    /**
     * 设置有效期
     * @param key
     * @param time 时间 单位秒
     */
    Long expire(String key, int time, Jedis jedis);

    /**
     * 删除指定的key
     * @param key
     * @return
     */
    Long del(Jedis jedis, String... key);

    Boolean exist(String key, Jedis jedis);

    Long ttl(String key, Jedis jedis);

    Long incr(String key, Jedis jedis);

    Long incr(String key, Jedis jedis, String... field);

    Long hdel(String key, Jedis jedis, String... field);

    String setex(String key, int seconds, String value, Jedis jedis);

    String hmset(String key, Map<String, String> hash, Jedis jedis);

    //存储链表结构的;
    //队列  先进先出
    Long rpush(String key, Jedis jedis, String... strings);

    //栈  先进后出
    Long lpush(String key, Jedis jedis, String... strings);

    //获取指定索引内的所有元素
    List<String> lrange(String key, long start, long end, Jedis jedis);

    //找到匹配pattern的所有的key集合
    Set<String> keys(String pattern, Jedis jedis);
}
