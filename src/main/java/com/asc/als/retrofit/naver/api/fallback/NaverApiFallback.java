package com.asc.als.retrofit.naver.api.fallback;


import com.asc.als.retrofit.naver.domain.search.News;
import com.asc.als.retrofit.naver.domain.search.Shop;
import com.asc.als.retrofit.naver.api.NaverApi;
import org.springframework.stereotype.Component;
import retrofit2.Response;
import retrofit2.http.Query;

@Component
public class NaverApiFallback implements NaverApi {

    @Override
    public Response<News> news(@Query("query") String query) { return null; }

    @Override
    public Response<Shop> shop(@Query("query") String query) { return null; }

    /*
    @Override
    public Call<ResponseBody> addUser(User user) {
        return null;
    }

    @Override
    public Call<ResponseBody> updateUser(User user) {
        return null;
    }

    @Override
    public Call<ResponseBody> deleteUser(Long id) {
        return null;
    }

    @Override
    public Call<ResponseBody> upload(MultipartBody.Part file) {
        return null;
    }

    @Override
    public Response<Map<String, Object>> dynamicUrl(String url, String name) {
        return null;
    }

    @Override
    public Response<ResponseBody> download() {
        return null;
    }
     */
}
