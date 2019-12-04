package com.example.mall.controller;


import com.alibaba.fastjson.JSONObject;
import com.example.mall.entity.User;
import com.example.mall.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;
@Controller
public class AuthorizeController {

    @Autowired
    private UserMapper userMapper;
    @ResponseBody
    @GetMapping("/callback")
    public String Callback(@RequestParam(name = "name") String id) {
        List<User> userList = userMapper.findUserByName(id);
        return  new JSONObject().toJSONString(userList);
    }
}
