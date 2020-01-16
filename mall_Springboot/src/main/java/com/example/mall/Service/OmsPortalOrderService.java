package com.example.mall.Service;


import com.example.mall.entity.OmsOrder;

import com.example.mall.entity.OmsOrderItem;
import com.example.mall.utils.CommonResult;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 前台订单管理Service
 * Created by macro on 2018/8/30.
 */
public interface OmsPortalOrderService {

    /**
     * 根据提交信息生成订单
     */
    @Transactional
    CommonResult generateOrder(OmsOrder omsOrder);

    /**
     * 取消单个超时订单
     */
    @Transactional
    void cancelOrder(Long orderId);

    OmsOrder getOrder(Long id);

    List<OmsOrderItem> getOrderItem(Long id);

    Object uporderstate(Long id, Integer state);

    void setstate(int state, Long id);

    List<OmsOrder> selectbystate(int state, Long id);

}
