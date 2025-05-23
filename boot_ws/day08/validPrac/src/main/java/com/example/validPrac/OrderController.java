package com.example.validPrac;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class OrderController {


    @InitBinder
    public void init(WebDataBinder dataBinder){

        //validator등록하기
         dataBinder.addValidators( new OrderValidator()   );
    }



    @GetMapping("/orderForm")
    public  String  orderForm(@ModelAttribute  Order order){
        return  "orderForm";
    }


    @PostMapping("/order")
    // 검증이 필요한 객체앞에 @Validated  ,  BindingResult 객체에 오류가 있으면 저장됨
    //
    public  String  order(@ModelAttribute  @Validated Order order , BindingResult bindingResult){

        log.info( "order ={}" , order);
        if(bindingResult.hasErrors()){
            log.info( "bindingresult ={}" , bindingResult);
            return "orderForm";
        }
        return  "redirect:/home";
    }



}
