package com.acorn.day05PracRestAPI;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberViewController {

    @GetMapping("/memberList")
    public String memberList(){
       return "memberList";
    }

    //멤버등록 화면제공
    @GetMapping("/memberRegister")
    public  String memberRegister(){
        return "memberRegister";
    }

    //하나조회
    @GetMapping("/memberOne")
    public String memberOne(){
        return "memberOne";
    }

    //삭제
    @GetMapping("/memberDelete")
    public String memberDelete(){
        return "memberDelete";
    }

}
