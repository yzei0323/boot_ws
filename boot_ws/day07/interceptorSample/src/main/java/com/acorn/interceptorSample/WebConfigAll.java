package com.acorn.interceptorSample;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


// @Configuration   설정등록 의미
//@Configuration
public class WebConfigAll implements WebMvcConfigurer {


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SessionInterceptor())
                .addPathPatterns("/*.do", "/*.acorn")   //적용할 대상
                .order(3);


        registry.addInterceptor(new LoggingInterceptor())
                .addPathPatterns("/**")  //적용할 대상
                .excludePathPatterns("/css/**", "/js/**", "/images/**")  //제외대상  "/login.do" ,
                .order(2);//


        registry.addInterceptor( new TestInterceptor())
                .addPathPatterns("/**").order(1);


    }
}
