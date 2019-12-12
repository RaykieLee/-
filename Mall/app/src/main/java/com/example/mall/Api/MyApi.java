package com.example.mall.Api;



import com.example.mall.bean.CommonResult;
import com.example.mall.bean.User;

import okhttp3.ResponseBody;
import retrofit2.Call;
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
}
