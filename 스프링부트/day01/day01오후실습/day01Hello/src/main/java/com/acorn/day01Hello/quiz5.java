package com.acorn.day01Hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class quiz5 {

    @GetMapping("/quiz5")
    public String quiz5(@RequestParam(name="amt",defaultValue = "10")int amt, Model model) {
        StringBuilder star = new StringBuilder("");
        for(int i=0;i <amt; i++) {
            star.append("*");
        }
        model.addAttribute("star",star);
        return "quiz5";
    }
}
