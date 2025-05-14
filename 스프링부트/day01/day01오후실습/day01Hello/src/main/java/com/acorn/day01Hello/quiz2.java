package com.acorn.day01Hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class quiz2 {

    @GetMapping("/quiz2")
    public String quiz2(Model model) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            list.add("3 * " + i + " = " + (3 * i));
        }
        model.addAttribute("list", list);
        return "quiz2";
    }
}
