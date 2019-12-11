package com.example.mall.controller;


import cn.hutool.db.Page;
import com.alibaba.fastjson.JSONObject;
import com.example.mall.entity.Goods;
import com.example.mall.entity.GoodsExample;
import com.example.mall.mapper.GoodsMapper;
import com.example.mall.mapper.GoodsSqlProvider;
import com.example.mall.utils.CommonResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;
import java.util.List;

@Api(tags = "PmsBrandController", description = "商品管理")
@Controller
public class GoodsController {
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private Goods goods;

    @ApiOperation("根据商品名获取商品列表")
    @ResponseBody
    @PostMapping("/selectGoodsbyname")
    public CommonResult SelectGoodsbyname(@RequestParam(name = "name") String name) {
        GoodsExample goodsExample=new GoodsExample();
        goodsExample.createCriteria().andNameLike('%'+ name +'%');
       // goodsExample.setOrderByClause("salesvolume");
        List<Goods> goodsList=goodsMapper.selectByExample( goodsExample );
        if(!(goodsList.size()==0)){
            return CommonResult.success( new JSONObject().toJSONString(goodsList), "查询成功");
        }else{
            return CommonResult.failed(  "(#`O′)未搜索到该商品 请换关键词");
        }

    }
    @ApiOperation("根据商品id获取商品详细信息")
    @ResponseBody
    @PostMapping("/getGoodsbyid")
    public CommonResult GetGoodsbyid(@RequestParam(name = "id") Integer id) {
        goods=goodsMapper.selectByPrimaryKey(id);
        if(!(goods==null)){
            return CommonResult.success( new JSONObject().toJSONString(goods), "查询成功");
        }else{
            return CommonResult.failed(  "(#`O′)不存在该商品");
        }
    }
    @ApiOperation("获取商品销量")
    @ResponseBody
    @PostMapping("/getGoodsbydesc")
    public CommonResult GetGoodsbydesc(@RequestParam(name = "num") Integer num) {
        GoodsExample goodsExample = new GoodsExample();
        goodsExample.setOrderByClause("salesvolume DESC" );
        GoodsSqlProvider goodsSqlProvider = new GoodsSqlProvider();

//        PageHelper.startPage(0, 2);
//
//        PageInfo<Goods> pageInfo = new PageInfo<>(goodsMapper.selectByExample(goodsExample));
//        if(!(pageInfo==null)){
//            return CommonResult.success( new JSONObject().toJSONString(pageInfo), "查询成功");
//        }else{
            return CommonResult.failed(  "(#`O′)不存在该商品");
//        }
    }
}
