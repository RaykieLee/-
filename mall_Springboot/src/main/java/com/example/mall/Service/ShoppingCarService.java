package com.example.mall.Service;


import com.example.mall.entity.OmsOrder;
import com.example.mall.entity.OmsOrderItem;
import com.example.mall.entity.Shoppingcar;
import com.example.mall.utils.CommonResult;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 购物车管理Service
 * Created by macro on 2018/8/30.
 */
public interface ShoppingCarService {

    /**
     * 根据提交信息生成订单
     */


    /**
     * 取消单个超时订单
     */

    List<Shoppingcar>  getCar(Integer orderId);

    void addGoods(Shoppingcar shoppingcar);
}
