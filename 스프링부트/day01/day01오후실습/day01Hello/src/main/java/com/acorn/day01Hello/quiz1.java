package com.acorn.day01Hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class quiz1 {

    @GetMapping("/quiz1")
    public String quiz1(@RequestParam(name = "num1", required = false, defaultValue = "1") int num1,
                        @RequestParam(name = "num2", required = false, defaultValue = "1") int num2,
                        Model model) {
        int result = num1 + num2;
        model.addAttribute("result",result);
        return "quiz1";
    }

}
