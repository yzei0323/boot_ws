package com.acorn.Prac;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    UserService service;


    //회원가입 화면
    @GetMapping("/signup")
    public String signup(){
        return "signup";
    }

    @PostMapping("/signupResult")
    public String signupResult(@ModelAttribute LibUser user){
        System.out.println(user);
        service.register(user);

        return "main";
    }

    //로그인 화면
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/loginResult")
    public String loginResult(@ModelAttribute LibUser user, HttpSession session) {
        System.out.println(user);
        LibUser loginUser = service.login(user);
        if (loginUser != null) {
            session.setAttribute("loginUser", loginUser);
            return "redirect:/book"; //검색페이지
        } else {
            return "/main"; //메인view
        }
    }
}
