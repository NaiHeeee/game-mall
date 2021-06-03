package com.yuier.gamemall.constant;

/**
 * @Author: lianweiyue
 * Redis 缓存各模块前缀
 */
public class RedisConstant {

    public static final String REDIS_USER_SESSION_KEY = "redis_user_session_key";
    public static final Integer SSO_SESSION_EXPIRE = 86400 * 7;
    public static final String REDIS_SMS_SESSION_KEY = "redis_sms_session_key";
    public static final Integer SMS_SESSION_EXPIRE = 900;

    public static final String REDIS_CODE_SESSION_KEY = "redis_code_session_key";
    public static final Integer CODE_SESSION_EXPIRE = 900;



}
