package com.acorn.day08PracValid;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
public class OrderController {

    @GetMapping("/orderForm")
    //비어있는 Order 객체를 모델에 저장해줌
    // orderForm form => th:object에서 폼과 order 객체바인딩이 오류없이 됨
    public String orderForm(@ModelAttribute Order order){   //주의!!!!!!! 꼭 넣어줘야함
        return "orderForm";
    }

    @PostMapping("/order")
    public String order(@ModelAttribute Order order, Model model){
        System.out.println(order);
        log.info( "item ={}" , order);

        //order 객체 검증하기
        //검증 후 에러정보를 담을 객체 생성하기
        Map<String, String> errors = new HashMap<>();

        // String str=null, String str=""
        if (order.getName()==null || order.getName().isEmpty()) { //오류나는 상황 설정
            errors.put("name", "상품이름을 입력하세요");
        }
        // 금액검증 100~10000
        if(order.getPrice()==null || order.getPrice()<100 || order.getPrice()>10000 ){ //오류나는 상황 설정
            errors.put("price", "상품금액은 100~10000 이어야 합니다");
        }
        // 수량검증 (999 넘어갈 수 없다)
        if(order.getQty()==null || order.getQty()>999){
            errors.put("qty", "상품수량을 999 초과할 수 없습니다");
        }

        //실패하면 -> 다시 폼으로, 오류 메시지 출력
        //성공하면 -> 서비스 실행, 홈화면
        if( !errors.isEmpty()){
            log.info( "item ={}" , order);
            model.addAttribute("errors", errors);
            return "orderForm";    //실패하면(오류나면) orderForm
        }
        return "redirect:/home";   //성공하면(에러없으면) home
    }


}
