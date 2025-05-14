package com.acorn.day02Batis;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@org.springframework.stereotype.Controller
public class MemberController {

    @Autowired    //필드주입
    MemberService service;

//    @Autowired   생성자주입
//    public Controller(MemberService service) {
//        this.service = service;
//    }

    /*
        회원가입시 포인트 적립을 해 준다.

        회원가입
        - 회원테이블에 등록
        - 포인트테이블에 회원의 포인트 등록

        => 하나의 논리적 단위로 묶어서 모두 수행되거나 모두 수행되지 않게 하기 (트랜잭션)
    */



    //조회
    @GetMapping("/members")
    public String getMembers(Model model){  //model이라는 저장소
        List<Member> list = service.getMembers();
        System.out.println(list);
        model.addAttribute("list", list);

        return "memberList";
    }

    //등록화면
    @GetMapping("/form")
    public String form(){
        return "formView";
    }

    //등록하기
    @PostMapping("/formProc")
    public String formProc(@ModelAttribute Member member){  //생성자, 세터
        System.out.println(member);

        //
        service.registerMember(member);
        return "ok";
    }

}
