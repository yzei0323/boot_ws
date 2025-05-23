package com.acorn.validTest;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class OrderValidator  implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Order.class.isAssignableFrom(clazz);   //Order클래스와 자식인지 true,false
    }

    @Override
    public void validate(Object target, Errors errors) {


        //target: 검증할 객체

        Order  order = (Order) target;

        if( order.getName()==null || order.getName().isEmpty()){
            // bindingResult.addError(new FieldError( "order","name", order.getName(), false, new String[]{"required"}, null, "상품이름 입력하세요"));
            errors.rejectValue("name", "required");
        }


        //금액검증
        if( order.getPrice() == null ||  order.getPrice()<100 || order.getPrice()> 10000){
            //  bindingResult.addError(new FieldError("order" , "price" , order.getPrice(), false, new String[] {"range.price"}, new Object[]{ "200" , "1000"}, "상품금액은 100 ~10000 이여야 합니다"));
            errors.rejectValue("price", "range" , new Object[] {"200","1000"} , null);
        }


        //수량검증

        if( order.getQty() ==null  ||  order.getQty() >999){
            //bindingResult.addError(new FieldError("order" , "qty" , order.getQty(), false, null, null,  "수량은 999초과할 수 없습니다"));
            errors.rejectValue("qty", "max" , new Object[]{"999"} , null);
        }

    }
}
