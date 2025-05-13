package com.acorn.day1;


import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class Task12Service {


    public ArrayList<Food> getFoodList(){

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


        return  foodList;
    }
}
