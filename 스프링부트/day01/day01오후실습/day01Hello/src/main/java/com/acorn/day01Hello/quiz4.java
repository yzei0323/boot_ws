package com.acorn.day01Hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class quiz4 {

    @GetMapping("/quiz4")
    public String quiz4(Model model) {
        Book a = new Book("코스모스","칼 세이건",18000);
        Book b = new Book("동물농장","조지 오웰",15000);

        model.addAttribute("a",a);
        model.addAttribute("b",b);

        return "quiz4";
    }

}
