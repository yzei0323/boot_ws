package com.acorn.day1;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Task4Controller {



    @Autowired
    Task4Service  service;


    //에이콘학생정보 서비스로 제공하기
    @GetMapping("/acorn")
    public String task4( Model model){


        //
       /* Acorn acorn = new Acorn();
        acorn.setId("acorn1");
        acorn.setPw("1234");
        acorn.setName("권지언");
        */

       Acorn acorn = service.getMember();
       model.addAttribute("acorn" , acorn);


        return  "task4view";
    }
}
