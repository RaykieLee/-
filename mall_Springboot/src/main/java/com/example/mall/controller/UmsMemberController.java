package com.example.mall.controller;


import com.example.mall.entity.User;
import  com.example.mall.utils.CommonResult;
import com.example.mall.Service.UmsMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 会员登录注册管理Controller
 * Created by macro on 2018/8/3.
 */
@Controller
@Api(tags = "UmsMemberController", description = "会员信息管理")
@RequestMapping("/sso")
public class UmsMemberController {
    @Autowired
    private UmsMemberService memberService;

    @ApiOperation("获取验证码")
    @RequestMapping(value = "/getAuthCode", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getAuthCode(@RequestParam String telephone) {
        return memberService.generateAuthCode(telephone);
    }

    @ApiOperation("判断验证码是否正确")
    @RequestMapping(value = "/verifyAuthCode", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult verifyAuthCode(@RequestParam String telephone,
                                       @RequestParam String authCode) {
        return memberService.verifyAuthCode(telephone,authCode);
    }
    @ApiOperation("登陆账号")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult login(@RequestParam String account,
                                       @RequestParam String password) {
        return memberService.login(account,password);
    }
    @ApiOperation("修改收货地址")
    @RequestMapping(value = "/userup", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult userup(@RequestBody User user) {
        return memberService.userup(user);
    }

    @ApiOperation("注册账号")
    @RequestMapping(value = "/registered", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult registered(@RequestParam String account,
                              @RequestParam String password,
                                   @RequestParam String name,
                                   @RequestParam String sex, @RequestParam String tel, @RequestParam String address, @RequestParam String headsculpture) {
        return memberService.registered(account,password,name,sex,tel,address,headsculpture);
    }
}
