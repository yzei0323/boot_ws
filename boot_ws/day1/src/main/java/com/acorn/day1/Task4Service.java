package com.acorn.day1;


import org.springframework.stereotype.Service;

@Service
public class Task4Service {


    public Acorn  getMember(){
        //
        Acorn acorn = new Acorn();
        acorn.setId("acorn1");
        acorn.setPw("1234");
        acorn.setName("권지언");

      return  acorn;
    }
}
