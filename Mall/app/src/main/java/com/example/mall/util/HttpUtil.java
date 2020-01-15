package com.example.mall.util;

import com.example.mall.Api.MyApi;
import com.example.mall.R;
import com.xuexiang.xui.widget.edittext.ClearEditText;

import butterknife.BindString;
import butterknife.BindView;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.xuexiang.xui.utils.ResUtils.getResources;

public class HttpUtil {
    public static String  url=getResources().getString(R.string.api_url);
    public  static MyApi apiStores;
    public  static  Retrofit retrofit= new Retrofit.Builder()
            //这里建议：- Base URL: 总是以/结尾；- @Url: 不要以/开头
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//新的配置
            .baseUrl(url).build();


    public static MyApi getInstence(){

        if (apiStores == null)
            apiStores  = retrofit.create(MyApi.class);



        return apiStores;
    }


}
