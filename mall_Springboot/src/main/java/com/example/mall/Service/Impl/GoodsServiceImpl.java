package com.example.mall.Service.Impl;

import com.example.mall.Service.GoodsService;
import com.example.mall.entity.Goods;
import com.example.mall.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class GoodsServiceImpl implements GoodsService {
    @Autowired
    Goods goods;
    @Autowired
    GoodsMapper goodsMapper;
    @Override
    public Goods select(Integer id) {
        return goodsMapper.selectByPrimaryKey(id);
    }
}
