package com.acorn.day01Hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class quiz9 {

    @GetMapping("/quiz9")
    public String quiz9() {
        return "quiz9";
    }
}

