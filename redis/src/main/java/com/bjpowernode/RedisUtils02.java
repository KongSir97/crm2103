package com.bjpowernode;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisUtils02 {

    //创建连接池对象
    private static JedisPool pool = null;


    public static JedisPool open(String host,Integer port) {
        if (pool == null) {
            JedisPoolConfig config = new JedisPoolConfig();
            //默认最大连接数
            config.setMaxTotal(10);
            //空闲连接数
            config.setMaxIdle(2);
            //密码
            config.setTestOnBorrow(true); //redis没有密码时用这种方式
            pool = new JedisPool(config,host, port);
        }
        return pool;
    }
}
