package com.example.mall.controller;


import com.alibaba.fastjson.JSONObject;
import com.example.mall.entity.Discuss;
import com.example.mall.entity.DiscussExample;
import com.example.mall.mapper.DiscussMapper;
import com.example.mall.utils.CommonResult;
import com.github.pagehelper.PageHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Api(tags = "DiscussController", description = "评论管理")
@Controller
public class DiscussController {
    @Autowired
    private DiscussMapper discussMapper;


    @ApiOperation("根据商品id获取评论列表")
    @ResponseBody
    @PostMapping("/getGoodDiscuss")
    public CommonResult getGoodDiscuss(@RequestParam(name = "id") Integer id) {

        PageHelper.startPage(0, 10);
        DiscussExample discussExample = new DiscussExample();
        discussExample.createCriteria().andGoodsidEqualTo(id);
        List<Discuss> discussList=discussMapper.selectByExample( discussExample );
        if(!(discussList.size()==0)){
            return CommonResult.success( new JSONObject().toJSONString(discussList), "查询成功");
        }else{
            return CommonResult.failed(  "(#`O′)未搜索到该商品评论 欢迎尝鲜试毒");
        }
    }
    @ApiOperation("根据用户id获取评论列表")
    @ResponseBody
    @PostMapping("/getUserbyname")
    public CommonResult SelectGoodsbyname(@RequestParam(name = "id") Integer id) {
        PageHelper.startPage(0, 10);
        DiscussExample discussExample = new DiscussExample();
        discussExample.createCriteria().andUseridEqualTo(id);
        List<Discuss> discussList=discussMapper.selectByExample( discussExample );
        if(!(discussList.size()==0)){
            return CommonResult.success( new JSONObject().toJSONString(discussList), "查询成功");
        }else{
            return CommonResult.failed(  "(#`O′)您还没有写过评论哟亲 快去剁手吧");
        }
    }
    @ApiOperation("添加评论")
    @ResponseBody
    @PostMapping("/addDiscuss")
    public CommonResult addDiscuss(@RequestBody Discuss discuss) {
        discussMapper.insert(discuss);
        return CommonResult.success(null, "成功发表评论");
    }
}
