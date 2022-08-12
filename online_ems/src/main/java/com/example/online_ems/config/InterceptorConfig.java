package com.example.online_ems.config;

//拦截器配置类，相当于.xml
import com.example.online_ems.Interceptor.JWTInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class InterceptorConfig implements WebMvcConfigurer {
    //覆盖方法

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JWTInterceptor())
                .addPathPatterns("/**")//拦截所有控制器请求
                .excludePathPatterns("/login/*");//排除指定请求
    }
}
