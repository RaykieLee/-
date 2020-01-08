package com.example.mall.controller;


import com.alibaba.fastjson.JSONObject;
import com.example.mall.Service.Impl.GoodsServiceImpl;
import com.example.mall.entity.Goods;
import com.example.mall.entity.GoodsExample;
import com.example.mall.mapper.GoodsMapper;
import com.example.mall.utils.CommonResult;

import com.github.pagehelper.PageHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;
import java.util.List;
/**
 *商品管理Service
 * */
@Api(tags = "PmsBrandController", description = "商品管理")
@Controller
    public class GoodsController {
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private GoodsServiceImpl goodsService;
    @ApiOperation("根据商品名获取商品列表")
    @ResponseBody
    @PostMapping("/selectGoodsbyname")
    public CommonResult SelectGoodsbyname(@RequestParam(name = "name") String name) {
        PageHelper.startPage(1, 5);
        List<Goods> goodsList=goodsService.Selectbyname(name);
        if(!(goodsList.size()==0)){
            return CommonResult.success( goodsList, "查询成功");
        }else{
            return CommonResult.failed(  "(#`O′)未搜索到该商品 请换关键词");
        }
    }
    @ApiOperation("根据商品id获取商品详细信息")
    @ResponseBody
    @PostMapping("/getGoodsbyid")
    public CommonResult GetGoodsbyid(@RequestParam(name = "id") Integer id) {
        Goods goods=goodsService.select(id);
        if(!(goods==null)){
            return CommonResult.success( new JSONObject().toJSONString(goods), "查询成功");
        }else{
            return CommonResult.failed(  "(#`O′)不存在该商品");
        }
    }
//    @ApiOperation("获取商品销量")
//    @ResponseBody
//    @PostMapping("/getGoodsbydesc")
//    public CommonResult GetGoodsbydesc(@RequestParam(name = "num") Integer num) {
//        GoodsExample goodsExample = new GoodsExample();
//        goodsExample.setOrderByClause("salesvolume DESC" );
//        PageHelper.startPage(0, num);
//        List<Goods> goodsList =goodsMapper.selectByExample(goodsExample);
//        if(!(goodsList==null)){
//            return CommonResult.success( new JSONObject().toJSONString(goodsList), "查询成功");
//        }else{
//            return CommonResult.failed(  "(#`O′)不存在该商品");
//        }
//    }
}
