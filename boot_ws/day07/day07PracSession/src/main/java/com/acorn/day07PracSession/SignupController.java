package com.acorn.day07PracSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SignupController {

    //로그인처리
    @GetMapping("/signup")
    public String signup(){
        return "redirect:/home";
    }
}
