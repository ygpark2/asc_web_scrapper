package com.asc.als.retrofit.naver.api;


import com.asc.als.retrofit.naver.api.fallback.HttpDegradeFallbackFactory;
import com.asc.als.retrofit.naver.api.fallback.NaverApiFallback;
import com.asc.als.retrofit.naver.domain.search.News;
import com.asc.als.retrofit.naver.domain.search.Shop;
import com.asc.als.retrofit.naver.ext.NaverSign;
import com.github.lianjiatech.retrofit.spring.boot.annotation.OkHttpClientBuilder;
import com.github.lianjiatech.retrofit.spring.boot.annotation.RetrofitClient;
import com.github.lianjiatech.retrofit.spring.boot.degrade.Degrade;
import com.github.lianjiatech.retrofit.spring.boot.interceptor.LogStrategy;
import com.github.lianjiatech.retrofit.spring.boot.retry.Retry;
import okhttp3.OkHttpClient;
import retrofit2.Response;
import retrofit2.http.*;

import java.util.concurrent.TimeUnit;


//@Sign
//@Intercept(handler = TimeStampInterceptor.class, include = {"/api/**"})
//@Intercept(handler = AnotherTimeStampInterceptor.class, include = {"/api/**"})

@Retry
@RetrofitClient(baseUrl = "${api.naver.search.baseUrl}",
        fallback = NaverApiFallback.class,
        fallbackFactory = HttpDegradeFallbackFactory.class,
        logStrategy = LogStrategy.BODY
)
@NaverSign(accessKeyId = "${api.naver.accessKeyId}", accessKeySecret = "${api.naver.accessKeySecret}")
@Degrade(count = 500)
public interface NaverApi {

    @OkHttpClientBuilder
    static OkHttpClient.Builder okhttpClientBuilder() {
        return new OkHttpClient.Builder()
                .connectTimeout(1, TimeUnit.SECONDS)
                .readTimeout(1, TimeUnit.SECONDS)
                .writeTimeout(1, TimeUnit.SECONDS);

    }

    @GET("news.json")
    Response<News> news(@Query("query") String query);

    @GET("shop.json")
    Response<Shop> shop(@Query("query") String query);

    // @GET("blog.json")
    // Response<Shop> blog(@Query("query") String query);


    /*
    @POST("user")
    Call<ResponseBody> addUser(@Body User user);

    @PUT("user")
    Call<ResponseBody> updateUser(@Body User user);

    @DELETE("user/{id}")
    Call<ResponseBody> deleteUser(@Path("id") Long id);

    @POST("upload")
    @Multipart
    Call<ResponseBody> upload(@Part MultipartBody.Part file);

    @GET
    Response<Map<String, Object>> dynamicUrl(@Url String url, @Query("name") String name);

    @GET("download")
    Response<ResponseBody> download();
     */
}
