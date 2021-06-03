package com.yuier.gamemall.redis.service;


import com.yuier.gamemall.pojo.CommonResult;

/**
 * @program: phkj-redis
 * @description: 用户登录，注销，验证码等服务
 * @author: 罗顺锋
 * @create: 2018-04-19 16:50
 **/
public interface SsoService {
    /**
     * 系统登录
     * @param userId
     * @return
     * @throws Exception
     */
    public CommonResult login(String userId, Integer time) throws Exception;

    /**
     * 根据token获取用户信息
     * @param token
     * @return
     * @throws Exception
     */
    public CommonResult getUserByToken(String token) throws Exception;

    /**
     * 注销用户信息
     * @param token
     * @return
     * @throws Exception
     */
    public CommonResult clearUserByToken(String token) throws Exception ;

    /**
     * 设置缓存
     * @param key
     * @param value
     * @param time 过期时间-1永久
     * @return
     * @throws Exception
     */
    public CommonResult setStringKey(String key, String value, Integer time) throws Exception ;

    /**
     * 获取缓存值
     * @param keye
     * @return
     * @throws Exception
     */
    public CommonResult getStringKey(String keye) throws Exception ;

    /**
     * 延长key周期
     * @param key
     * @param time
     * @return
     */
    public CommonResult setKeyTime(String key, Integer time)throws Exception;

    /**
     * 设置验证码
     * @param phone
     * @param code
     * @return
     * @throws Exception
     */
    public CommonResult setValidCode(String phone, String code) throws Exception;

    /**
     * 获取验证码
     * @param phone
     * @return
     * @throws Exception
     */
    public CommonResult getValidCode(String phone) throws Exception;

}
