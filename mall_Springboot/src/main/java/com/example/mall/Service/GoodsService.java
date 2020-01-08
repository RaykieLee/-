package com.example.mall.Service;


import com.example.mall.entity.Goods;
import com.example.mall.utils.CommonResult;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;


public interface GoodsService {
    /**
     * 存储数据
     * @return
     */
    Goods select(Integer id);

     List<Goods> Selectbyname(String name);
}
