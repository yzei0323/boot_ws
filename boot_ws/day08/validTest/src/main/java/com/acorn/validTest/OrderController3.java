package com.acorn.validTest;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.Map;


@Slf4j
@Controller
public class OrderController3 {



    @GetMapping("/order3")
    public  String  itemForm( @ModelAttribute  Order order){
        return "order-form3";
    }



    //BindingResult 사용하기
    //주의 검증하려는 객체뒤에 두어야 한다 (위치 중요)
    //상품 등록
    @PostMapping("/order3")
    public  String  item(@ModelAttribute(name = "order") Order order  ,BindingResult bindingResult, Model model){

        if( order.getName()==null || order.getName().isEmpty()){
             bindingResult.addError(new FieldError("order" , "name" , "상품이름 입력하세요"));
        }


        //금액검증
        if( order.getPrice() == null ||  order.getPrice()<100 || order.getPrice()> 10000){
            bindingResult.addError(new FieldError("order" , "price" , "상품금액은 100 ~10000 이여야 합니다"));
        }


        //수량검증

        if( order.getQty() ==null  ||  order.getQty() >999){
            bindingResult.addError(new FieldError("order" , "qty" , "수량은 999초과할 수 없습니다"));

        }


        if (bindingResult.hasErrors()) {
            // 유효성 검사 실패 시 폼 페이지로 다시 반환

            log.info( "err ={}" , bindingResult);
            return "order-form3";
        }



        //모델에 저장할 필요없음
        //bindingResult에 담긴 값은 뷰에서 사용 가능함

        return "redirect:/home";
    }
}


/*


   BindingResult 사용하기
   변환된 결과 활용하기
 */