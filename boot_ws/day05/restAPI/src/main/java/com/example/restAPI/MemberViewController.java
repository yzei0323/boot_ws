package com.example.restAPI;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberViewController {


    @GetMapping("/member-item")
    public String member1(){
        return  "member";
    }


    @GetMapping("/member-list")
    public String member2(){
        return  "memberlist";
    }


    @GetMapping("/member-register")
    public String member3(){
        return  "memberRegister0";
    }

    @GetMapping("/member-modify")
    public String member4(){
        return "memberUpdate";
    }

}
