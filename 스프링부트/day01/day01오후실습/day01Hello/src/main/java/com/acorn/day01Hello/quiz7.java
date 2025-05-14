package com.acorn.day01Hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class quiz7 {

    @GetMapping("/quiz7")
    public String quiz7(Model model) {
        String text = "간바레";
        model.addAttribute("text",text);
        return "quiz7";
    }

}
