package com.example.mall.Service;

import com.example.mall.entity.User;
import com.example.mall.utils.CommonResult;

/**
 * 会员管理Service
 * Created by macro on 2018/8/3.
 */
public interface UmsMemberService {

    /**
     * 生成验证码
     */
    CommonResult generateAuthCode(String telephone);

    /**
     * 判断验证码和手机号码是否匹配
     */
    CommonResult verifyAuthCode(String telephone, String authCode);
/*
         验证用户名密码
*/


    CommonResult login(String account, String password);



    CommonResult registered(String account, String password, String name, String sex, String tel, String address, String headsculpture);

    CommonResult userup(User user);
}
