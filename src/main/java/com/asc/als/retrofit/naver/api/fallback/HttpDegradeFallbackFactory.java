package com.asc.als.retrofit.naver.api.fallback;


import com.asc.als.retrofit.naver.domain.search.News;
import com.asc.als.retrofit.naver.domain.search.Shop;
import com.asc.als.retrofit.naver.api.NaverApi;
import com.github.lianjiatech.retrofit.spring.boot.degrade.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import retrofit2.Response;

@Component
@Slf4j
public class HttpDegradeFallbackFactory  implements FallbackFactory<NaverApi> {
    @Override
    public NaverApi create(Throwable cause) {
        log.error("델리게이션 생성 ! ", cause.getMessage(), cause);
        return new NaverApi() {
            @Override
            public Response<Shop> shop(String query) {
                return null;
            }

            @Override
            public Response<News> news(String query) {
                return null;
            }

        };
    }
}
