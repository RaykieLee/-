package com.example.mall.Service.Impl;


import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSONObject;
import com.example.mall.entity.Goods;
import com.example.mall.entity.GoodsExample;
import com.example.mall.entity.User;
import com.example.mall.entity.UserExample;
import com.example.mall.mapper.UserMapper;
import com.example.mall.mapper.UserSqlProvider;
import  com.example.mall.utils.CommonResult;
import com.example.mall.Service.RedisService;
import com.example.mall.Service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * 会员管理Service实现类
 * Created by macro on 2018/8/3.
 */
@Service
public class UmsMemberServiceImpl implements UmsMemberService {
    @Autowired
    private RedisService redisService;
    @Autowired
    private UserExample userExample;
    @Autowired
    private  User user;
    @Autowired
    private UserMapper userMapper;
    @Value("${redis.key.prefix.authCode}")
    private String REDIS_KEY_PREFIX_AUTH_CODE;
    @Value("${redis.key.expire.authCode}")
    private Long AUTH_CODE_EXPIRE_SECONDS;
    Logger logger =LoggerFactory.getLogger(UmsMemberServiceImpl.class);
    @Override
    public CommonResult generateAuthCode(String telephone) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            sb.append(random.nextInt(10));
        }
        //验证码绑定手机号并存储到redis
        redisService.set(REDIS_KEY_PREFIX_AUTH_CODE + telephone, sb.toString());
        redisService.expire(REDIS_KEY_PREFIX_AUTH_CODE + telephone, AUTH_CODE_EXPIRE_SECONDS);
        return CommonResult.success(sb.toString(), "获取验证码成功");
    }
    //对输入的验证码进行校验
    @Override
    public CommonResult verifyAuthCode(String telephone, String authCode) {
        if (StringUtils.isEmpty(authCode)) {
            return CommonResult.failed("请输入验证码");
        }
        String realAuthCode = redisService.get(REDIS_KEY_PREFIX_AUTH_CODE + telephone);
        boolean result = authCode.equals(realAuthCode);
        if (result) {
            return CommonResult.success(null, "验证码校验成功");
        } else {
            return CommonResult.failed("验证码不正确");
        }
    }
    @Override
    public CommonResult login(String account, String password) {
        userExample.clear();
        userExample.createCriteria().andAccountEqualTo(account).andPasswordEqualTo(password);;
        List<User> userList= userMapper.selectByExample( userExample );
      //  logger.info(String.valueOf(userList.size())+account);
        if(!(userList.size()==0)){
            return CommonResult.success( new JSONObject().toJSONString(userList), "登陆成功");
        }else{
            return CommonResult.failed(  "账号或密码错误");
        }
    }

    @Override
    public CommonResult registered(String account, String password, String name, String sex, String tel, String address, String headsculpture) {
        userExample.createCriteria().andTelEqualTo(tel);
        List<User> userList= userMapper.selectByExample( userExample );
        if(!(userList.size()==0)){
            user.setAccount(account);
            user.setPassword(password);
            user.setName(name);
            user.setSex(sex);
            user.setTel(tel);
            user.setRegistrationDate(DateUtil.date());
            user.setAddress(address);
            user.setState("0");
            user.setHeadsculpture(headsculpture);
            userMapper.insert(user);
            return CommonResult.success( new JSONObject().toJSONString(user), "注册成功");
        }else{
            return CommonResult.failed(  "已存在同信息用户,请勿重复注册");
        }
    }
}