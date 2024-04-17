package com.ohgiraffers.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Autowired
    private StopWatchInterceptor stopWatchInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(stopWatchInterceptor)
                // 어떤 url 요청에 따른 수행을 할건지
                .addPathPatterns("/*")
                /* 어떤 url 요청은 제외를 할건지
                    static 하위의 정적 리소스는 인터셉터가 적용되지 않도록 한다.
                 */
                .excludePathPatterns("/css/**")
                .excludePathPatterns("/images/**")
                .excludePathPatterns("/js/**")
                // error 로 포워딩 되는 경로도 제외해주어야 한다.
                .excludePathPatterns("/error");
    }

}
