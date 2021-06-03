package com.yuier.gamemall.redis.service.impl;


import com.yuier.gamemall.constant.RedisConstant;
import com.yuier.gamemall.pojo.CommonResult;
import com.yuier.gamemall.redis.service.SsoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author NaiHeeee
 */
@Service("ssoService")
public class SsoServiceImpl implements SsoService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 单点登录
     */
    @Override
    public CommonResult login(String userId, Integer time) throws Exception {
        CommonResult CommonResult = new CommonResult();
        //生成token
        String token = String.valueOf(UUID.randomUUID());
        String key = RedisConstant.REDIS_USER_SESSION_KEY + ":" + token;
        //把用户信息写入redis
        stringRedisTemplate.opsForValue().set(key, userId, RedisConstant.SSO_SESSION_EXPIRE, TimeUnit.SECONDS);
        //设置session的过期时间
        if(time == -1){
            stringRedisTemplate.persist(key);
        }
        CommonResult.setObject(token);
        return CommonResult;
    }

    /**
     * 更具token获取用户信息
     */
    @Override
    public CommonResult getUserByToken(String token) throws Exception {
        CommonResult commonResult = new CommonResult();
        String json = stringRedisTemplate.opsForValue().get(RedisConstant.REDIS_USER_SESSION_KEY + ":" + token);
        if (StringUtils.isEmpty(json)) {
            return CommonResult.RESULT403;
        }
        //更新过期时间
        stringRedisTemplate.expire(RedisConstant.REDIS_USER_SESSION_KEY + ":" + token, RedisConstant.SSO_SESSION_EXPIRE, TimeUnit.SECONDS);
        commonResult.setObject(json);
        return commonResult;
    }

    /**
     * 更具token删除用户信息
     */
    @Override
    public CommonResult clearUserByToken(String token) throws Exception {
        CommonResult CommonResult = new CommonResult();
        String json = stringRedisTemplate.opsForValue().get(RedisConstant.REDIS_USER_SESSION_KEY + ":" + token);
        if (StringUtils.isEmpty(json)) {
            CommonResult.Result600("session已经过期");
            return CommonResult;
        }
        //更新过期时间
        stringRedisTemplate.delete(RedisConstant.REDIS_USER_SESSION_KEY + ":" + token);
        CommonResult.setMsg("session清空");
        return CommonResult;
    }

    @Override
    public CommonResult setStringKey(String key, String value, Integer time) throws Exception {
        CommonResult commonResult = new CommonResult();
        //把信息写入redis
        int i = time == -1 ? RedisConstant.SSO_SESSION_EXPIRE : time;
        stringRedisTemplate.opsForValue().set(key, value, Long.parseLong(String.valueOf(i)));
        //设置session的过期时间,如果未传入，按照用户session时间一样
        return commonResult;
    }

    @Override
    public CommonResult getStringKey(String key) throws Exception {
        CommonResult CommonResult = new CommonResult();
        String json = stringRedisTemplate.opsForValue().get(key);
        if (StringUtils.isEmpty(json)) {
            CommonResult.Result600("session已经过期");
            return CommonResult;
        }
        CommonResult.setObject(json);
        return CommonResult;
    }

    @Override
    public CommonResult setKeyTime(String key, Integer time) throws Exception {
        CommonResult CommonResult = new CommonResult();
        //设置session的过期时间,如果未传入，按照用户session时间一样
        stringRedisTemplate.expire(RedisConstant.REDIS_USER_SESSION_KEY + ":" + key, time == -1 ? RedisConstant.SSO_SESSION_EXPIRE : time,TimeUnit.SECONDS);
        return CommonResult;
    }

    /**
     * 会员登录入口
     *
     * @param phone
     * @param code
     * @return
     * @throws Exception
     */
    @Override
    public CommonResult setValidCode(String phone, String code) throws Exception {
        CommonResult CommonResult = new CommonResult();
        String token = String.valueOf(UUID.randomUUID());
        stringRedisTemplate.opsForValue().set(RedisConstant.REDIS_SMS_SESSION_KEY + ":" + phone, code, RedisConstant.SMS_SESSION_EXPIRE, TimeUnit.SECONDS);
        CommonResult.setObject(token);
        return CommonResult;
    }

    @Override
    public CommonResult getValidCode(String phone) throws Exception {
        CommonResult CommonResult = new CommonResult();
        String json = stringRedisTemplate.opsForValue().get(RedisConstant.REDIS_SMS_SESSION_KEY + ":" + phone);
        if (StringUtils.isEmpty(json)) {
            CommonResult.Result600("验证码已经过期，请重新发送");
        }
        CommonResult.setObject(json);
        return CommonResult;
    }

}
