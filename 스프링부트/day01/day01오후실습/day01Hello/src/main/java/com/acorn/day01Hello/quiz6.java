package com.acorn.day01Hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class quiz6 {
    @GetMapping("/quiz6")
    public String quiz6(@RequestParam(name = "num") int num, Model model) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                list.add(i);
            }
        }
        model.addAttribute("list", list);
        return "quiz6";
    }
}
