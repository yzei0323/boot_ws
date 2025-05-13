package com.acorn.hello;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CController {


    //웹프로젝트  정적리소스 접근

    @GetMapping("/cute")
    public String  cute( Model model){


        model.addAttribute("imgName" ,"a.png");
        return "cuteview";
    }
}
