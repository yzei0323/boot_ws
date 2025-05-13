package com.acorn.day1;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class Task12Controller {


    //음식정보 3개 제공하기

    @Autowired
    Task12Service service;


    @GetMapping("/foodlist")
    public  String  task12(  Model model){


        //모델
/*
        ArrayList<Food> foodList  = new ArrayList<>();


        Food f = new Food();
        f.setCode("f01");
        f.setName("오므라이스");
        f.setPrice(9000);


        Food f2 = new Food();
        f2.setCode("f02");
        f2.setName("돈까스");
        f2.setPrice(10000);


        Food f3 = new Food();
        f3.setCode("f03");
        f3.setName("국밥");
        f3.setPrice(11000);



        foodList.add(f);
        foodList.add(f2);
        foodList.add(f3);

        */

       ArrayList<Food> foodList=  service.getFoodList();

        //모델 심기
        model.addAttribute("foodList", foodList);


        return "task12view";
    }

}
