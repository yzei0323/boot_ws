package com.acorn.day08PracConvert;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j //신기하도다 이게뭐야 로그 남길 수 있는 거래용용
@Controller
public class ItemController {


//    @GetMapping("/itemForm")
//    public String itemForm(){
//        return "itemForm";
//    }
//
//    @PostMapping("/item")
//    public String item(@ModelAttribute Item item) {
//
//        //로그에 출력?됨
//        log.info( "item ={}" , item);
//
//        //무조건 성공
//        return "redirect:/home";
//    }

    //날짜를  2025-05-23 으로 다시 입력해 보자 !! 오류가 발생되는것을 확인하자

    //날짜를 2025-05-23 형식으로 받고 싶다면
    //InitBinder 사용해서
    //initBinder에 등록해야 한다
    //initBinder의 위치는 controller안에 위치한다

    //컨버터 등록하기
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        //날짜
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }


    //모델키의 이름은 Type의 첫글자 소문자 규칙을 가진다
    @GetMapping("/itemForm")
    public String itemForm(@ModelAttribute Item item){
        return "itemForm";
    }

    @PostMapping("/item")
    //검증하고 싶은 객체 뒤에 BindingResult추가
    public String item(@ModelAttribute Item item , BindingResult bindingResult) {

        //로그에 출력?됨
        log.info( "bindingResult ={}", bindingResult);
        log.info( "item ={}" , item);

        //무조건 성공
        // return "redirect:/home";
        return "itemForm";
    }



}
