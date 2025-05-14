package com.acorn.day02Batis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class OrderController {

    @Autowired
    OrderService service;

    public List<Map<String, Object>> getOrders(){

        List<Map<String, Object>> list = service.getOrderList();
        return list;
    }
}
