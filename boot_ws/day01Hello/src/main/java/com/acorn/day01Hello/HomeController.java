package com.acorn.day01Hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.model.IAttribute;

@Controller
public class HomeController {

    //mvc
    @GetMapping("/hello")
    public String hello(Model model){

        model.addAttribute("data","spring boot start ^---^");
        return "hello";
    }

    //데이터 응답하기
    //
    @ResponseBody
    @GetMapping("/hello2")
    public String hello2(){
        return "hello2";
    }
}
