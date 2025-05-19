package com.acorn.mapPrj;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
public class 타임리프_자바스크립인라인 {


    @GetMapping("/test")
    public  String  test(  Model model){


        Map<String, String> position1 = new HashMap<String, String>();
        position1.put("title", "카카오2");
        position1.put("la", "33.450705");
        position1.put("lg", "126.570677");



        Map<String, String> position2 = new HashMap<String, String>();
        position2.put("title", "생태연못2");
        position2.put("la", "33.450879");
        position2.put("lg", "126.569940");

        ArrayList< Map<String, String>> list = new ArrayList< Map<String, String>> ();
        list.add(position1);
        list.add(position2);


        System.out.println( list);
        model.addAttribute("positions", list);   // 자바객체로 모델로 넘김


        return  "javascriptInline";
    }
}
