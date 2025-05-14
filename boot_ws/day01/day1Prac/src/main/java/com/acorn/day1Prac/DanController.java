package com.acorn.day1Prac;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

//3단 제공하기
@Controller
public class DanController {

    @Autowired
    DanService service;

    @RequestMapping("/dan3")
    public String dan3(Model model){

        ArrayList<String> dan3List = service.showdan3();
        model.addAttribute("dan3", dan3List);

        return "dan3";
    }


    @RequestMapping("/dan")
    public String dan(@RequestParam (required = false, defaultValue = "1")int num, Model model){

        ArrayList<String> gugudanList = service.gugudan(num);
        model.addAttribute("num", num);
        model.addAttribute("gugudan", gugudanList);

        return "dan";
    }

}
