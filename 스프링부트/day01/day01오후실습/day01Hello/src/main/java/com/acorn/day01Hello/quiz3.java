package com.acorn.day01Hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class quiz3 {

    @GetMapping("/quiz3")
    public String quiz3(@RequestParam(name="num",defaultValue = "2")int num, Model model) {
        List<String> list = new ArrayList<>();
        for (int i=1; i<=9; i++) {
            list.add(num + " * " +i+ " = "+ (num*i));
        }
        model.addAttribute("list",list);
        return "quiz3";
    }
}
