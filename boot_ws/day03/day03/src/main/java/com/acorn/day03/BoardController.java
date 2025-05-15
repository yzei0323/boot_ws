package com.acorn.day03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

/*
  게시판 조회하기
  - 전체조회하기
  - 작성자로 조회하기
  - 내용으로 조회하기
  - 제목으로 조회하기

   (게시판 화면  :
    1) 입력정보 확인
    검색조건: condition  ,  검색어: keyword )
    => 서버측으로 정보를 보내기
    => 서버가 이정보를 받기


    2) 입력정보를 기반으로하는 데이터베이스 repository 만들기
     - mapper 만들기
     - repository 만들기
     - repository 테스트하기
*/

@Controller
public class BoardController {

    @Autowired
    BoardService service;

    //게시글 조회하기
    @GetMapping("/board")
    public String board( @ModelAttribute SearchCondition search, Model model){

        System.out.println(search);
        List<BoardDTO> list = service.getSearchBoard(search);
        model.addAttribute("list", list);
        return "boardList";
    }

}
