package com.example.tranEx;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {

    @Autowired
    MemberService service;



    @GetMapping("/join")
    public String  join(){

        Member  member= new Member();
        member.setId("acorn");
        member.setName("홍길동");


        service.회원가입포인트적립(member);
        return "ok";
    }

}
