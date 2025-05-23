package com.acorn.validTest;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OrderController {

    //상품 등록 화면



    // Neither BindingResult nor plain target object for bean name 'order' available as request attribute

    //!! 주의
    //처음 화면이 보일 때  th:object 부분이 오류가 발생함
    //모델의 객체가 전달되지 않기 때문에 발생
    //빈 객체를 모델에 전달해야 한다
    //별도의 빈객체를 생성해서 모델에 전달해도 되지만 @ModelAttribute를 적용하면 빈 객체를 모델에 생성해줌
    @GetMapping("/order")
    public  String  itemForm( @ModelAttribute  Order order){
        return "order-form";
    }


    //상품 등록
    @PostMapping("/order")
    public  String  item( @ModelAttribute(name = "order") Order order){

        //검증에 실패하면
        return "order-form";
    }
}
