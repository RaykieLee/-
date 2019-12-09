package com.example.mall.controller;


import com.alibaba.fastjson.JSONObject;
import com.example.mall.entity.Goods;
import com.example.mall.entity.GoodsExample;
import com.example.mall.entity.User;
import com.example.mall.mapper.GoodsMapper;
import com.example.mall.mapper.GoodsSqlProvider;
import com.example.mall.mapper.UserMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;
import java.util.List;

@Api(tags = "PmsBrandController", description = "商品品牌管理")
@Controller
public class GoodsController {
    @Autowired
    private GoodsMapper goodsMapper;


    @ApiOperation("根据商品名获取商品列表")
    @ResponseBody
    @PostMapping("/selectGoodsbyid")
    public String Callback(@RequestParam(name = "name") String name) {
        GoodsExample goodsExample=new GoodsExample();
        goodsExample.createCriteria().andNameLike('%'+ name +'%');
       // goodsExample.setOrderByClause("salesvolume");
        List<Goods> goodsList=goodsMapper.selectByExample( goodsExample );
        return  new JSONObject().toJSONString(goodsList);
    }
}
