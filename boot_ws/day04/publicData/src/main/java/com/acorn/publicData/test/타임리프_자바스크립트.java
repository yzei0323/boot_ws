package com.acorn.publicData.test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class 타임리프_자바스크립트 {



    @GetMapping("/aa")
    public  String a( Model model){

        List<ItemDTO>  list= new ArrayList<>();
        list.add( new ItemDTO("test","test","test"));

        model.addAttribute("list" ,list);



        return "aa";
     }
}
