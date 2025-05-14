package com.acorn.day01Hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("data","spring boot start!!!!");
        return "hello";
    }

    @ResponseBody
    @GetMapping("/hello2")
    public String hello2() {
        return "hello2";
    }

    @GetMapping("/hello3")
    public String hello3(Model model) {
        model.addAttribute("text","오늘 두 악인이 죽어 세상에 득이 되게 하소서");
        return "hello";
    }
}