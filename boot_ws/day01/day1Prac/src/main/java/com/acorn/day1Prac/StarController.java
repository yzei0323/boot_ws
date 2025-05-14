package com.acorn.day1Prac;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StarController {

    @Autowired
    StarService service;

    @RequestMapping("/star")
    public String star(@RequestParam (defaultValue = "1",required = false) int cnt, Model model){

        String result = service.cntStar(cnt);

        return "star";
    }

}


