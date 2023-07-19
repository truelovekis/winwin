package com.example.winwin.config;

import com.example.winwin.interceptor.LoginInterceptor;
import com.example.winwin.interceptor.MyPageInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class InterceptorConfig implements WebMvcConfigurer {
    private final LoginInterceptor loginInterceptor;
    private final MyPageInterceptor myPageInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/myPage/*")
                .order(1);

        registry.addInterceptor(myPageInterceptor)
                .addPathPatterns("/myPage/*")
                .order(2);
    }
}
