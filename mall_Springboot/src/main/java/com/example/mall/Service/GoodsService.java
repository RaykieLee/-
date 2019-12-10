package com.example.mall.Service;


import com.example.mall.entity.Goods;

/**
 * redis操作Service,
 * 对象和数组都以json形式进行存储
 * Created by macro on 2018/8/7.
 */
public interface GoodsService {
    /**
     * 存储数据
     * @return
     */
    Goods select(Integer id);


}
