package com.example.mall.Service.Impl;



import com.example.mall.Service.OmsPortalOrderService;
import com.example.mall.entity.OmsOrder;
import com.example.mall.entity.OmsOrderExample;
import com.example.mall.entity.OmsOrderItem;
import com.example.mall.entity.OmsOrderItemExample;
import com.example.mall.mapper.GoodsMapper;
import com.example.mall.mapper.OmsOrderItemMapper;
import com.example.mall.mapper.OmsOrderMapper;
import com.example.mall.utils.CancelOrderSender;
import com.example.mall.utils.CommonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 订单管理Service
 * Created by macro on 2018/8/30.
 */
@Service
public class OmsPortalOrderServiceImpl implements OmsPortalOrderService {
    private static Logger LOGGER = LoggerFactory.getLogger(OmsPortalOrderServiceImpl.class);
    @Autowired
    private CancelOrderSender cancelOrderSender;
    @Autowired
    private OmsOrderMapper omsOrderMapper;
    @Autowired
    private OmsOrderItemMapper omsOrderItemMapper;
    @Autowired
    private OmsOrderItemExample omsOrderItemExample;
    @Autowired
    private OmsOrderExample omsOrderExample;
    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public CommonResult generateOrder(OmsOrder omsOrder) {
        //todo 执行一系类下单操作，具体参考mall项目
        LOGGER.info("process generateOrder");
        //生成订单
        omsOrderMapper.insert(omsOrder);
//        下单完成后开启一个延迟消息，用于当用户没有付款时取消订单（orderId应该在下单后生成）
        for (OmsOrderItem omsOrderItem:omsOrder.getOmsOrderItems()
             ) {
            omsOrderItemMapper.insert(omsOrderItem);
            goodsMapper.addsalesvolume(omsOrderItem.getProductId(),omsOrderItem.getProductQuantity());
        }
        sendDelayMessageCancelOrder(11L);
        return CommonResult.success(null, "下单成功");
    }

    @Override
    public Object uporderstate(Long id, Integer state) {
        OmsOrder omsOrder = omsOrderMapper.selectByPrimaryKey(id);

        omsOrder.setStatus(state);
        omsOrderMapper.updateByPrimaryKey(omsOrder);

        return omsOrder;
    }

    @Override
    public void cancelOrder(Long orderId) {
        //todo 执行一系类取消订单操作，具体参考mall项目
        LOGGER.info("process cancelOrder orderId:{}",orderId);
    }

    private void sendDelayMessageCancelOrder(Long orderId) {
        //获取订单超时时间，假设为60分钟
        long delayTimes = 30 * 1000;
        omsOrderMapper.deleteByPrimaryKey(orderId);
        omsOrderItemExample.clear();
        omsOrderItemExample.createCriteria().andOrderIdEqualTo(orderId);
        omsOrderItemMapper.deleteByExample(omsOrderItemExample);
        //发送延迟消息
        cancelOrderSender.sendMessage(orderId, delayTimes);
    }

    @Override
    public List<OmsOrderItem> getOrderItem(Long id) {
        omsOrderItemExample.createCriteria().andOrderIdEqualTo(id);
        return  omsOrderItemMapper.selectByExample(omsOrderItemExample);
    }

    @Override
    public List<OmsOrder> getOrder(Long id) {
        omsOrderExample.clear();
        omsOrderExample.createCriteria().andMemberIdEqualTo(id);
        return omsOrderMapper.selectByExample(omsOrderExample);
    }
}
