package com.acorn.day02Batis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OrderService {

    @Autowired
    OrderRepository repository;

    public List<Map<String, Object>> getOrderList(){
        return repository.selectAll();
    }

}
