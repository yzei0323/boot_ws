package com.example.restAPI;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class RestMemberController {


    //명사형태의  url 설계
    //동작은   method로 구분


    // 데이터 응답하기
    @ResponseBody
    @GetMapping("/members/{id}")
    public Member   method1( @PathVariable(name="id") String id){

        System.out.println( id);
        Member  member  = new Member();
        member.setId("acorn1");
        member.setName("브래드피트");
        member.setEmail("brand@naver.com");
        return  member;

    }


    @ResponseBody
    @GetMapping("/members")
    public ArrayList<Member> method2(){

        ArrayList<Member> list = new ArrayList<>();

        Member  member  = new Member();
        member.setId("acorn1");
        member.setName("브래드피트");
        member.setEmail("브래드@naver.com");

        Member  member2  = new Member();
        member2.setId("acorn2");
        member2.setName("키아누");
        member2.setEmail("키아누@google.com");

        list.add( member);
        list.add( member2);

        return list;

    }


    //등록     
    @ResponseBody
    @PostMapping("/members")   // josn문자열 --> 자바객체로로 바인딩
    public String method3(  @RequestBody  Member member){

        System.out.println( member);
        
        // 등록합니다
        return"등록 성공";
    }
    
    
    //변경

    @ResponseBody
    @PutMapping("/members/{id}")
    public String  member4 (@PathVariable("id") String id , @RequestBody  Member member){

        System.out.println( id);
        System.out.println( member);

        return "수정성공";
    }

}
