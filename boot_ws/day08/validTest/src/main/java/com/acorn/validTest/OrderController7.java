package com.acorn.validTest;


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

@Slf4j
@Controller
public class OrderController7 {



    //global validator 사용하여 검증하기

    @GetMapping("/order7")
    public  String  itemForm( @ModelAttribute  Order order){
        return "order-form7";
    }



   //Validator 만들고 분리하기




    //사용자가 오류입력값 유지하기 !!!
    @PostMapping("/order7")
    public  String  item(@ModelAttribute(name = "order") @Validated  Order order  , BindingResult bindingResult, Model model){
/*
        if( order.getName()==null || order.getName().isEmpty()){
            // bindingResult.addError(new FieldError( "order","name", order.getName(), false, new String[]{"required"}, null, "상품이름 입력하세요"));
            bindingResult.rejectValue("name", "required");
        }


        //금액검증
        if( order.getPrice() == null ||  order.getPrice()<100 || order.getPrice()> 10000){
          //  bindingResult.addError(new FieldError("order" , "price" , order.getPrice(), false, new String[] {"range.price"}, new Object[]{ "200" , "1000"}, "상품금액은 100 ~10000 이여야 합니다"));
            bindingResult.rejectValue("price", "range" , new Object[] {"200","1000"} , null);
        }


        //수량검증

        if( order.getQty() ==null  ||  order.getQty() >999){
            //bindingResult.addError(new FieldError("order" , "qty" , order.getQty(), false, null, null,  "수량은 999초과할 수 없습니다"));
           bindingResult.rejectValue("qty", "max" , new Object[]{"999"} , null);
        }

*/

        //모델에 저장할 필요없음
        //bindingResult에 담긴 값은 뷰에서 사용 가능함

        if (bindingResult.hasErrors()) {
            // 유효성 검사 실패 시 폼 페이지로 다시 반환

            log.info( "erros={}" , bindingResult);

            return "order-form7";
        }

        return "redirect:/home";
    }
}


/*
   BindingResult 사용하기
   변환된 결과 활용하기
 */