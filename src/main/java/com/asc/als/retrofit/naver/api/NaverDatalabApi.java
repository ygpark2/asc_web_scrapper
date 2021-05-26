package com.asc.als.retrofit.naver.api;


import com.asc.als.retrofit.naver.api.fallback.HttpDegradeFallbackFactory;
import com.asc.als.retrofit.naver.api.fallback.NaverApiFallback;
import com.asc.als.retrofit.naver.domain.User;
import com.asc.als.retrofit.naver.ext.NaverSign;
import com.github.lianjiatech.retrofit.spring.boot.annotation.OkHttpClientBuilder;
import com.github.lianjiatech.retrofit.spring.boot.annotation.RetrofitClient;
import com.github.lianjiatech.retrofit.spring.boot.degrade.Degrade;
import com.github.lianjiatech.retrofit.spring.boot.interceptor.LogStrategy;
import com.github.lianjiatech.retrofit.spring.boot.retry.Retry;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 *
 * 2.2.0
 *  https://github.com/LianjiaTech/retrofit-spring-boot-starter#%E7%86%94%E6%96%AD%E9%99%8D%E7%BA%A7
 *
 * @author 박 영규
 * @date 2020/05/24
 **/

//@Sign
//@Intercept(handler = TimeStampInterceptor.class, include = {"/api/**"})
//@Intercept(handler = AnotherTimeStampInterceptor.class, include = {"/api/**"})

@Retry
@RetrofitClient(baseUrl = "${api.naver.datalab.baseUrl}",
        fallback = NaverApiFallback.class,
        fallbackFactory = HttpDegradeFallbackFactory.class,
        logStrategy = LogStrategy.BODY
)
@NaverSign(accessKeyId = "${api.naver.accessKeyId}", accessKeySecret = "${api.naver.accessKeySecret}")
@Degrade(count = 500)
public interface NaverDatalabApi {

    @OkHttpClientBuilder
    static OkHttpClient.Builder okhttpClientBuilder() {
        return new OkHttpClient.Builder()
                .connectTimeout(1, TimeUnit.SECONDS)
                .readTimeout(1, TimeUnit.SECONDS)
                .writeTimeout(1, TimeUnit.SECONDS);

    }

    @GET("user/{id}")
    Response<User> user(@Path("id") Long id);

    @GET("user")
    Call<List<User>> users();

}
