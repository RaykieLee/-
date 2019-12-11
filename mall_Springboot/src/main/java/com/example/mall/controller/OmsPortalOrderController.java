package com.example.mall.controller;
import com.alibaba.fastjson.JSONObject;
import com.example.mall.Service.OmsPortalOrderService;
import com.example.mall.entity.OmsOrder;
import com.example.mall.entity.OmsOrderItem;
import com.example.mall.mapper.GoodsMapper;
import com.example.mall.mapper.OmsOrderItemMapper;
import com.example.mall.mapper.OmsOrderMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 订单管理Controller
 * Created by macro on 2018/8/30.
 */
@Controller
@Api(tags = "OmsPortalOrderController", description = "订单管理")
@RequestMapping("/order")
public class OmsPortalOrderController {
    @Autowired
    private OmsPortalOrderService portalOrderService;
    @Autowired
    private OmsOrderMapper omsOrderMapper;
    @Autowired
    private OmsOrderItemMapper omsOrderItemMapper;
    @Autowired
    private GoodsMapper goodsMapper;
    @ApiOperation("生成订单表")
    @RequestMapping(value = "/inomsOrder", method = RequestMethod.POST)
    @ResponseBody
    public Object generateOrder(@RequestBody OmsOrder omsOrder) {
        return portalOrderService.generateOrder(omsOrder);
    }
    @ApiOperation("生成订单子购物车表")
    @RequestMapping(value = "/inomsOrderItem", method = RequestMethod.POST)
    @ResponseBody
    public Object generateOrder(@RequestBody OmsOrderItem omsOrderItem) {
        omsOrderItemMapper.insert(omsOrderItem);
        goodsMapper.addsalesvolume(omsOrderItem.getProductId(),omsOrderItem.getProductQuantity());
        return null;
    }
    @ApiOperation("根据购物车信息生成订单")
    @RequestMapping(value = "/test", method = RequestMethod.POST)
    @ResponseBody
    public Object test() {
        return new JSONObject().toJSONString(omsOrderMapper.selectByPrimaryKey(new Long(1)))+new JSONObject().toJSONString(omsOrderItemMapper.selectByPrimaryKey(new Long(1)));
    }
}
