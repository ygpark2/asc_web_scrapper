package com.asc.als.retrofit.naver.ext;


import com.github.lianjiatech.retrofit.spring.boot.interceptor.BasePathMatchInterceptor;
import lombok.Data;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Data
public class NaverSignInterceptor extends BasePathMatchInterceptor {

    private String accessKeyId;

    private String accessKeySecret;

    /*
     "X-Naver-Client-Id: {애플리케이션 등록 시 발급받은 client id 값}"
     "X-Naver-Client-Secret: {애플리케이션 등록 시 발급받은 client secret 값}"
     */
    @Override
    public Response doIntercept(Interceptor.Chain chain) throws IOException {
        System.out.println("=========================================================");
        System.out.println("==================== doIntercept ===================");
        System.out.println("=========================================================");
        Request request = chain.request();
        Request newReq = request.newBuilder()
                .addHeader("X-Naver-Client-Id", accessKeyId)
                .addHeader("X-Naver-Client-Secret", accessKeySecret)
                .build();
        return chain.proceed(newReq);
    }
}
