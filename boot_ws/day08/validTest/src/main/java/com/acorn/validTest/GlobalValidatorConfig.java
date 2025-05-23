package com.acorn.validTest;


import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Validator;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class GlobalValidatorConfig implements WebMvcConfigurer {

    @Override
    public Validator getValidator() {
        return new OrderValidator(); //  global    Validator 등록
    }
}