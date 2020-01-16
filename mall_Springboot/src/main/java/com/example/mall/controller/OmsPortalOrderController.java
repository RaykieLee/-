package com.example.mall.controller;
import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSONObject;
import com.example.mall.Service.OmsPortalOrderService;
import com.example.mall.entity.OmsOrder;

import com.example.mall.mapper.GoodsMapper;
import com.example.mall.mapper.OmsOrderItemMapper;
import com.example.mall.mapper.OmsOrderMapper;
import com.example.mall.utils.CommonResult;
import com.github.pagehelper.PageHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 订单管理Controller
 * Created by lizixi on 2018/8/30.
 */
@Controller
@Api(tags = "OmsPortalOrderController", description = "订单管理")
@RequestMapping("/order")
public class OmsPortalOrderController {
    private static final  int pagesize = 10;
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
    public CommonResult generateOrder(@RequestBody OmsOrder omsOrder) {
        omsOrder.setCreateTime(DateUtil.date());
        omsOrder.setOrderSn( DateUtil.now().replace(":","").replace("-","")+omsOrder.getMemberId());
        return portalOrderService.generateOrder(omsOrder);
    }
    //    @ApiOperation("生成订单子购物车表")
//    @RequestMapping(value = "/inomsOrderItem", method = RequestMethod.POST)
//    @ResponseBody
//    public Object generateOrder(@RequestBody OmsOrderItem omsOrderItem) {
//        omsOrderItemMapper.insert(omsOrderItem);
//        goodsMapper.addsalesvolume(omsOrderItem.getProductId(),omsOrderItem.getProductQuantity());
//        return null;
//    }
    @ApiOperation("根据购物车信息生成订单")
    @RequestMapping(value = "/test", method = RequestMethod.POST)
    @ResponseBody
    public Object test() {
        return new JSONObject().toJSONString(omsOrderMapper.selectByPrimaryKey(new Long(1)))+new JSONObject().toJSONString(omsOrderItemMapper.selectByPrimaryKey(new Long(1)));
    }
    @ApiOperation("修改订单状态")
    @RequestMapping(value = "/setOrderstate", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult setOrderstate(@RequestParam(name = "state") int state,@RequestParam(name = "id") Long id) {
        portalOrderService.setstate(state,id);
//        if(!(goods==null)){
        return CommonResult.success( null, "修改成功");
//        }else{
//            return CommonResult.failed(  "(#`O′)不存在该商品");
//        }
    }
    @ApiOperation("根据订单状态获取")
    @RequestMapping(value = "/getbyState", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult getbyState(@RequestParam(name = "state") int state,@RequestParam(name = "id") Long id,@RequestParam(name = "pagenum") int pagenum) {
//        PageHelper.startPage(pagenum, pagesize);
        List<OmsOrder> omsOrders=portalOrderService.selectbystate(state,id);
        for (int i = 0; i <omsOrders.size() ; i++) {

        }
        if(!(omsOrders==null)){
            return CommonResult.success( omsOrders, "获取成功");
        }else{
            return CommonResult.failed(  "(#`O′)请买买买");
        }
    }
}
