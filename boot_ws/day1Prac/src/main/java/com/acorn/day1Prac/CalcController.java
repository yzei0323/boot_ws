package com.acorn.day1Prac;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

// 1. 두 수를 사용자로부터 입력받아 사칙연산해서 제공하기
@Controller
public class CalcController {


    @Autowired
    CalcService service;

    @GetMapping("/calc")
    public String calc(
        @RequestParam(name="su1", required = false, defaultValue = "1")int su1,
        @RequestParam(name="su2", required = false, defaultValue = "1")int su2, Model model){

        int plus = service.plus(su1,su2);
        int minus = service.minus(su1,su2);
        int multi = service.multi(su1,su2);
        double divide = service.divide(su1,su2);

        //헤헤 모델에 안넣어서 안나오는거였군
        model.addAttribute("su1", su1);
        model.addAttribute("su2", su2);

        model.addAttribute("result1", plus);
        model.addAttribute("result2", minus);
        model.addAttribute("result3", multi);
        model.addAttribute("result4", divide);

        return "calc";

    }


}
