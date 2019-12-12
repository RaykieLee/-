package com.example.mall.Api;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import rx.Observable;

public interface ImagrApi {
    @Headers("user-agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.169 Safari/537.36")
//提交方式 和请求的参数
    @Multipart
    @POST("https://sm.ms/api/upload")
    Observable<ResponseBody> getLoad(@Part MultipartBody.Part smfile);
}
