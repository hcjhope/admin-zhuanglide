package com.zhuanglide.admin.cache.service;

import java.io.Serializable;

public interface ICacheService {
	


    /**
     * 删除key所对应的key value对
     * 返回ApiResCode.SUCC成功，其他失败
     * @param key key
     */
    public int del(String key);

    /**
     * 检查key，value对是否存在
     * 
     * @param key key
     * @return 是否存在标志位，存在为true，不存在为false
     */
    public boolean exists(String key);

    /**
     * 设定过期时间，单位为秒，非重新set指令(push, add)不能改变过期时间
     * 返回ApiResCode.SUCC成功，其他失败
     * @param key key
     * @param seconds 过期秒数
     */
    public int expire(String key, int seconds);

    /**
     * 查询剩余过期时间，单位为秒，-1为存在或者不过期
     * @param key key
     * @return 剩余过期时间(time to live) 时间为秒
     */
    public long ttl(String key);


    /**
     * 缓存对象,默认永远不过期
     * 返回ApiResCode.SUCC成功，其他失败
     * @param key key
     * @param object 所要缓存对象
     * @param clazz 对象的类别信息; 木有办法,泛型类别在运行时被擦除了,还得多传一下类信息用于序列，反序列化,麻烦一下吧
     * @param <T> 对象泛型类别
     */
    public <T extends Serializable> int set(String key, T object, Class<T> clazz);
    
    /**
     * 缓存对象和过期时间
     * 返回ApiResCode.SUCC成功，其他失败
     * @param key key
     * @param object 所要缓存对象
     * @param clazz 对象的类别信息; 木有办法,泛型类别在运行时被擦除了,还得多传一下类信息用于序列，反序列化,麻烦一下吧
     * @param seconds 过期时间
     * @param <T> 对象泛型类别
     */
    public <T extends Serializable> int set(String key, T object, Class<T> clazz, int seconds);

    
    /**
     * 获取已经缓存对象
     * 
     * @param key key
     * @param clazz 对象类别信息，理由见上
     * @param <T> 对象泛型类别
     * @return 缓存的对象
     */
    public <T extends Serializable> T get(String key, Class<T> clazz);
    
    

    /**
     * 获取字符串
     * 
     * @param key key
     * @return 字符串
     */
    public String getString(String key);
    
 
}
