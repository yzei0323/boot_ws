package com.acorn.day2Batis;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class OrderController {


//생성자 주입
    final OrderRpository orderRpository;

    @Autowired
    public OrderController(OrderRpository orderRpository) {
        this.orderRpository = orderRpository;
    }




    @ResponseBody
    @GetMapping("/orders")
    public List<Map<String, Object>> getOrders(){
        return orderRpository.selectAll();
    }


}
