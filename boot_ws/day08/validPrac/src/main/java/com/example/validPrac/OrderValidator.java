package com.example.validPrac;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class OrderValidator   implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
          return Order.class.isAssignableFrom(clazz);   // Order를 상속받은 객체인지 확인
    }


    @Override
    public void validate(Object target, Errors errors) {

        Order order  =  (Order)target;

        if( order.getName() ==null  || order.getName().isEmpty()){
            errors.rejectValue("name" ,"required");
        }


        //금액검증   100~10000
        if( order.getPrice() ==null  || order.getPrice() <100 || order.getPrice() >10000 ){
            errors.rejectValue("price" ,"range" , new Object[]{ "100" ,"10000"} , "금액범위 오류 입니다");
        }


        //수량검증  999
        if( order.getQty() ==null  ||  order.getQty() >999){
            errors.rejectValue("qty" , "max" , new Object[]{"999"} ,  "999보다 작아야 합니다");
        }

    }
}
