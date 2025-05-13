package com.acorn.day1;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class A {


    public  String  a(@RequestParam( name = "a", required = false, defaultValue = "1") int a,
                      @RequestParam( name = "b", required = false, defaultValue = "1") int b){



        System.out.println( a+b);

        return "hiview";
    }
}
