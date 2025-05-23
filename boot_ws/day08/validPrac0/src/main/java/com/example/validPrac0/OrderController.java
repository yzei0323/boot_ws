package com.example.validPrac0;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
public class OrderController {



    @GetMapping("/orderForm")
    public  String  orderForm(@ModelAttribute  Order order){
        return  "orderForm";
    }



    @PostMapping("/order")
    public  String  order(@ModelAttribute    Order order  , Model model){


        Map<String, String> errors = new HashMap<>();

        //이름검증
        // String str=null ,  String str=""
        if( order.getName() ==null  || order.getName().isEmpty()){
            errors.put("name" , "상품이름을 입력하세요");
        }

        //금액검증   100~10000
        if( order.getPrice() ==null  || order.getPrice() <100 || order.getPrice() >10000 ){
            errors.put("price" ,  "상품금액은  100~ 1000이어야 합니다");
        }

        //수량검증  999

        if( order.getQty() ==null  ||  order.getQty() >999){
            errors.put("qty" ,"수량은  999초과할 수 없습니다");
        }


        //오류가 있으면 다시 폼으로

        if( !errors.isEmpty()) {   //검증에 실패한 상황
            model.addAttribute("errors", errors);
            return "orderForm";

        }


        return  "redirect:/home";
    }



}
