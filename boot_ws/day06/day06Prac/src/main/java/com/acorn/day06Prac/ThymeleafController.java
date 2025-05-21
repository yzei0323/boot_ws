package com.acorn.day06Prac;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ThymeleafController {


    //each, stat 사용하기
    @GetMapping("/test1")
    public String test1(Model model){
        List<Acorn> list = new ArrayList<>();
        list.add(new Acorn("acorn1", "1234", "윤현기"));
        list.add(new Acorn("acorn2", "0000", "최하은"));
        list.add(new Acorn("acorn3", "5678", "황예지"));
        model.addAttribute("list", list);
        return "thymeView1";
    }

    //th:if로  데이터가 없으면 데이타없다 표시하기
    @GetMapping("/test")
    public  String test2(Model model){
        List<Acorn> list = new ArrayList<>();
        model.addAttribute("list", list);
        return "thymeView2";
    }

    //조건에 맞을 때 클래스 추가
    @GetMapping("/test3")
    public String test3(Model model){
        model.addAttribute("num", 10);
        model.addAttribute("num2", 5);
        return "thymeView3";
    }

    //조건에 맞을 때 클래스 추가
    @GetMapping("/test4")
    public String test4(Model model){
        model.addAttribute("start", 11);
        model.addAttribute("end", 20);
        return "thymeView4";
    }

    @GetMapping("/test5")
    public String test5(Model model){
        model.addAttribute("data", "hello data");
        model.addAttribute("data2", null);
        return "thymeView5";
    }

}
