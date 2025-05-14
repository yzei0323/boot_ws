package com.example.mybatisSqlsession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class MemberController {


    @Autowired
    MemberService service;


    @GetMapping("/members")
    public  @ResponseBody List<Member> getUser(){
        return   service.getMembers();
  }



    @GetMapping("/insert")
    public  @ResponseBody int insert1(){
        Member member = new Member();
        member.setId("user03");
        member.setName("hong");
        member.setEmail("hong@naver.com");
        return   service.registerMember1( member);
    }


    @GetMapping("/insertAll")
    public  @ResponseBody int insert(){

        Member member = new Member();
        member.setId("user01");
        member.setName("hong");
        member.setEmail("hong@naver.com");
        return   service.registerMember( member);
    }
}
