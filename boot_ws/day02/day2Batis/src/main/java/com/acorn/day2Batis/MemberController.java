package com.acorn.day2Batis;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MemberController {


    @Autowired
    MemberRepository repository;


    @ResponseBody
    @GetMapping("/members")
    public List<Member> getMembers(){
        return  repository.selectAll();

    }



    @ResponseBody
    @GetMapping("/register")
    public  int register( ){

        Member m= new Member();
        m.setId("acorn3");
        m.setName("hong");
        m.setEmail("hong@google.com");

        return  repository.insert( m);

    }

}
