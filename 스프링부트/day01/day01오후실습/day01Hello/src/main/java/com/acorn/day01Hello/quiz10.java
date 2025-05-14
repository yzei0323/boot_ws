package com.acorn.day01Hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class quiz10 {

    @GetMapping("/quiz10")
    public String quiz10(Model model) {
        String[] arr = {"monsratyou.jpg","kahasa.jpg","8lja.jpg"};
        int num= (int)Math.floor(Math.random()*3);
        model.addAttribute("text",arr[num]);
        return "quiz10";
    }
}
