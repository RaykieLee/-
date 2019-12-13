package com.example.mall.Api;



import com.example.mall.bean.CommonResult;
import com.example.mall.bean.Goods;
import com.example.mall.bean.OmsOrder;
import com.example.mall.bean.ShoppingCarDataBean;
import com.example.mall.bean.User;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

public interface MyApi {
    @FormUrlEncoded
    @POST("/user/registered")
    Observable<CommonResult> registered(@Field("account") String  account,
                                        @Field("password") String  password,
                                        @Field("name") String  name,
                                        @Field("sex") String sex, @Field("tel") String tel, @Field("address") String address, @Field("headsculpture") String headsculpture);
    @FormUrlEncoded
    @POST("/user/login")
    Observable<CommonResult<User>> login(@Field("account") String  account,
                                         @Field("password") String  password);
    @FormUrlEncoded
    @POST("/selectGoodsbyname")
    Observable<CommonResult<List<Goods>>> selectGoodsbyname(@Field("name") String  name);
    @FormUrlEncoded
    @POST("/shopping_Car/getCar")
    Observable<ShoppingCarDataBean> getCar(@Field("id") Integer  id);
    @FormUrlEncoded
    @POST("/order/inomsOrder")
    Observable<CommonResult> inomsOrder(@Body OmsOrder omsOrder);

}
