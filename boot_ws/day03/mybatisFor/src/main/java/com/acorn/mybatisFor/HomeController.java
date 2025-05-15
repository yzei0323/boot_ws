package com.acorn.mybatisFor;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {



    @GetMapping("/main")
    public String a(){

        return "main";
    }


}
