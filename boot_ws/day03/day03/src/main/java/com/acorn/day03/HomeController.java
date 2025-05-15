package com.acorn.day03;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    /*
        home -> main화면 보여주기
        main화면에서 정보를 조회할 고객 선택하기
        선택한 고객의 정보 조회하기

        1) 사용자가 선택한 정보 여러 개 얻어오기
        2) 얻어온 여러 고객 아이디로 고객정보 조회하기
          - mapper 작성 시
          - in 절 뒤의 쿼리내용을 동적으로 생성하기
          - foreach 사용하기
          - select * from membertbl where id in ('acorn')
          - select * from membertbl where id in ('acorn', 'acorn3')
          - select * from membertbl where id in ('acorn', 'acorn3', 'acorn4')
    */


    @GetMapping("/home")
    public String home(){
        return "main";
    }

}
