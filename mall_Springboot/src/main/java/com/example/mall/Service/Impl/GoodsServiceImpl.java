package com.example.mall.Service.Impl;

import com.example.mall.Service.GoodsService;
import com.example.mall.entity.Goods;
import com.example.mall.entity.GoodsExample;
import com.example.mall.entity.GoodsSkuExample;
import com.example.mall.entity.GoodsSpecExample;
import com.example.mall.mapper.GoodsMapper;
import com.example.mall.mapper.GoodsSkuMapper;
import com.example.mall.mapper.GoodsSpecMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    GoodsMapper goodsMapper;
    @Autowired
    GoodsSpecMapper goodsSpecMapper;
    @Autowired
    GoodsSkuMapper goodsSkuMapper;
    @Override
    public Goods select(Integer id) {
        Goods goods = goodsMapper.selectByPrimaryKey(id);
        GoodsSpecExample goodsSpecExample=new GoodsSpecExample();
        GoodsSkuExample goodsSkuExample = new GoodsSkuExample();
        goodsSkuExample.createCriteria().andGoodsidEqualTo(goods.getId());
        goodsSpecExample.createCriteria().andGoodsidEqualTo(goods.getId());
        goods.setGoodsSkuList(goodsSkuMapper.selectByExample(goodsSkuExample));
        goods.setGoodsSpecList(goodsSpecMapper.selectByExample(goodsSpecExample));
        return goods;
    }

    @Override
    public List<Goods> Selectbyname(String name) {
        GoodsExample goodsExample=new GoodsExample();
        goodsExample.setOrderByClause("salesvolume DESC" );
        goodsExample.createCriteria().andNameLike('%'+ name +'%');
        // goodsExample.setOrderByClause("salesvolume");
        return goodsMapper.selectByExample( goodsExample );
    }
}
