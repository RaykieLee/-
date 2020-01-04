package com.example.mall.Service.Impl;


import com.example.mall.Service.ShoppingCarService;
import com.example.mall.entity.Shoppingcar;
import com.example.mall.entity.ShoppingcarExample;
import com.example.mall.mapper.ShoppingcarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * shoppingcar操作Service的实现类
 *
 */
@Service
public class ShoppingCarServiceImpl implements ShoppingCarService {
    @Autowired
    ShoppingcarMapper shoppingcarMapper;
    @Autowired
    ShoppingcarExample shoppingcarExample;

    @Override
    public List<Shoppingcar>  getCar(Integer userid) {
        shoppingcarExample.createCriteria().andUseridEqualTo(userid);
        String orderByshroeid = "stroeid DESC";
        shoppingcarExample.setOrderByClause( orderByshroeid );  // 设置通过某个字段排序的条件
        return  shoppingcarMapper.selectByExample(shoppingcarExample);
    }

    @Override
    public void addGoods(Shoppingcar shoppingcar) {
        shoppingcarMapper.insert(shoppingcar);

    }
}
