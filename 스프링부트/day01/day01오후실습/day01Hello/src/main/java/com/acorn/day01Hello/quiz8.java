package com.acorn.day01Hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class quiz8 {

    @GetMapping("/quiz8")
    public String quiz8(Model model) {
        String[] arr = {"화이팅","힘내","간바레"};
        int num= (int)Math.floor(Math.random()*3);
        model.addAttribute("text",arr[num]);
        return "quiz8";
    }
}
