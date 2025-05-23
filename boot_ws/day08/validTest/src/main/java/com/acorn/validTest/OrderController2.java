package com.acorn.validTest;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class OrderController2 {

    //상품 등록 화면

    // Neither BindingResult nor plain target object for bean name 'order' available as request attribute

    //!! 주의
    //처음 화면이 보일 때  th:object 부분이 오류가 발생함
    //모델의 객체가 전달되지 않기 때문에 발생
    //빈 객체를 모델에 전달해야 한다
    //별도의 빈객체를 생성해서 모델에 전달해도 되지만 @ModelAttribute를 적용하면 빈 객체를 모델에 생성해줌


    //!!2단계의 문제점
    //type이 다른경우 오류가 터짐


    @GetMapping("/order2")
    public  String  itemForm( @ModelAttribute  Order order){
        return "order-form2";
    }


    //상품 등록
    @PostMapping("/order2")
    public  String  item( @ModelAttribute(name = "order") Order order  , Model model){

        //검증에 실패하면   Map에  오류메시지를 담아서 모델로 전달함
        Map<String,String > errors  = new HashMap<>();


        //상품이름 검즘
        // String str=null,  String str="";
        if( order.getName()==null || order.getName().isEmpty()){
            errors.put("name","상품이름을 입력하세요");
        }


        //금액검증
        if( order.getPrice() == null ||  order.getPrice()<100 || order.getPrice()> 10000){
            errors.put("price" , "상품금액은 100 ~10000 이여야 합니다");
        }

        //수량검증

        if( order.getQty() ==null  ||  order.getQty() >999){
            errors.put( "qty" ,  "수량은 999초과할 수 없습니다");
        }


        System.out.println( errors);
        if (!errors.isEmpty()) {
            System.out.println("error 발생");
            // 에러 정보를 로그로 출력 (선택 사항)
            errors.forEach((field, message) -> System.out.println(field + ": " + message));
            model.addAttribute("errors", errors); // 에러 정보를 뷰에 전달
            return "order-form2";
        }


        return "redirect:/home";
    }
}


/*
   수량, 금액 부분에 문자를 넣어보자 !!
   오류발생함
   Validation failed for object='order'. Error count: 1
   codes [typeMismatch.order.price,typeMismatch.price,typeMismatch.java.lang.Integer,typeMismatch];
   com.acorn.validTest.OrderController2.item(com.acorn.validTest.Order,org.springframework.ui.Model): [Field error in object 'order' on field 'price': rejected value [dfdfdfd]; codes [typeMismatch.order.price,typeMismatch.price,typeMismatch.java.lang.Integer,typeMismatch]; arguments [org.springframework.context.support.DefaultMessageSourceResolvable: codes [order.price,price]; arguments []; default message [price]]; default message [Failed to convert property value of type 'java.lang.String' to required type 'java.lang.Integer' for property 'price';
   For input string: "dfdfdfd"]]

 */