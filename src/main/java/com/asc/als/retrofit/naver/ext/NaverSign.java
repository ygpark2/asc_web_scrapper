package com.asc.als.retrofit.naver.ext;


import com.github.lianjiatech.retrofit.spring.boot.annotation.InterceptMark;
import com.github.lianjiatech.retrofit.spring.boot.interceptor.BasePathMatchInterceptor;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@InterceptMark
public @interface NaverSign {

    String accessKeyId();

    String accessKeySecret();

    String[] include() default {"/**"};

    String[] exclude() default {};

    Class<? extends BasePathMatchInterceptor> handler() default NaverSignInterceptor.class;
}
