package com.example.mall.Service.Impl;

import com.example.mall.Service.GoodsService;
import com.example.mall.entity.Goods;
import com.example.mall.entity.GoodsExample;
import com.example.mall.mapper.GoodsMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    Goods goods;
    @Autowired
    GoodsMapper goodsMapper;
    @Override
    public Goods select(Integer id) {
        return goodsMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Goods> Selectbyname(String name) {
        GoodsExample goodsExample=new GoodsExample();
        goodsExample.setOrderByClause("salesvolume DESC" );
        List<Goods> goodsList =goodsMapper.selectByExample(goodsExample);
        goodsExample.createCriteria().andNameLike('%'+ name +'%');
        // goodsExample.setOrderByClause("salesvolume");
        return goodsMapper.selectByExample( goodsExample );
    }
}
