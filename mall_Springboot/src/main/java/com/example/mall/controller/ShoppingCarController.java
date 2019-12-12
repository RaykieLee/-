package com.example.mall.controller;


import com.example.mall.Service.ShoppingCarService;
import com.example.mall.Service.UmsMemberService;
import com.example.mall.entity.ShoppingCarDataBean;
import com.example.mall.entity.ShoppingCarDataBean.*;
import com.example.mall.entity.Shoppingcar;
import com.example.mall.entity.User;
import com.example.mall.utils.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 购物车信息管理Controller
 * Created by macro on 2018/8/3.
 */
@Controller
@Api(tags = "ShoppingCarController", description = "购物车信息管理")
@RequestMapping("/shopping_Car")
public class ShoppingCarController {
    @Autowired
    private ShoppingCarService shoppingCarService;
    @Autowired
    private ShoppingCarDataBean shoppingCarDataBean;

    @ApiOperation("获取购物车信息")
    @RequestMapping(value = "/getCar", method = RequestMethod.GET)
    @ResponseBody
    public ShoppingCarDataBean getCar(@RequestParam Integer id) {
          List<DatasBean> datas=new ArrayList<>();

        List<Shoppingcar> shoppingcars = shoppingCarService.getCar(id);


        for (Shoppingcar shoppingcar:shoppingcars
             ) {
            if(datas.size()==0){
                DatasBean.GoodsBean goodsBean = new DatasBean.GoodsBean();
                goodsBean.setGoods_id(String.valueOf(shoppingcar.getGoodsid()));
                goodsBean.setGoods_image(String.valueOf(shoppingcar.getImage()));
                goodsBean.setGoods_name(String.valueOf(shoppingcar.getName()));
                goodsBean.setGoods_price(String.valueOf(shoppingcar.getPrice()));
                goodsBean.setIsSelect(false);
                DatasBean datasBean = new DatasBean();
                ArrayList<DatasBean.GoodsBean> goodslist = new ArrayList<DatasBean.GoodsBean>();
                goodslist.add(goodsBean);
                datasBean.setGoods(goodslist);
                datasBean.setIsSelect_shop(false);
                datasBean.setStore_id(String.valueOf(shoppingcar.getStroeid()));
                datasBean.setStore_name(shoppingcar.getStroename());
                datas.add(datasBean);
            }else {
                if ( datas.get(datas.size()-1).getStore_id().equals(String.valueOf(shoppingcar.getGoodsid()))){
                    DatasBean.GoodsBean goodsBean = new DatasBean.GoodsBean();
                    goodsBean.setGoods_id(String.valueOf(shoppingcar.getGoodsid()));
                    goodsBean.setGoods_image(String.valueOf(shoppingcar.getImage()));
                    goodsBean.setGoods_name(String.valueOf(shoppingcar.getName()));
                    goodsBean.setGoods_price(String.valueOf(shoppingcar.getPrice()));
                    goodsBean.setIsSelect(false);
                    datas.get(datas.size()-1).getGoods().add(goodsBean);
                }else {
                    DatasBean.GoodsBean goodsBean = new DatasBean.GoodsBean();
                    goodsBean.setGoods_id(String.valueOf(shoppingcar.getGoodsid()));
                    goodsBean.setGoods_image(String.valueOf(shoppingcar.getImage()));
                    goodsBean.setGoods_name(String.valueOf(shoppingcar.getName()));
                    goodsBean.setGoods_price(String.valueOf(shoppingcar.getPrice()));
                    goodsBean.setIsSelect(false);
                    DatasBean datasBean = new DatasBean();
                    ArrayList<DatasBean.GoodsBean> goodslist = new ArrayList<>();
                    goodslist.add(goodsBean);
                    datasBean.setGoods(goodslist);
                    datasBean.setIsSelect_shop(false);
                    datasBean.setStore_id(String.valueOf(shoppingcar.getStroeid()));
                    datasBean.setStore_name(shoppingcar.getStroename());
                    datas.add(datasBean);
                }
            }
        }
        shoppingCarDataBean.setCode(200);
        shoppingCarDataBean.setDatas(datas);
        return shoppingCarDataBean;
    }

    @ApiOperation("添加购物车物品")
    @RequestMapping(value = "/addGoods", method = RequestMethod.POST)
    @ResponseBody
    public void addGoods(@RequestBody Shoppingcar shoppingCar) {
        //return shoppingCarService.addGoods(shoppingCar);
    }

}
