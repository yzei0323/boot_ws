package com.acorn.day08PracConvert;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AcornController {

    // 빈 객체를 생성해서 모델에 저장해 줌
    @GetMapping("/acornForm")
    public String acornForm(@ModelAttribute Acorn acorn){
        return "acornForm";
    }

    @PostMapping("/acorn")
    public String acorn(@ModelAttribute Acorn acorn){
        System.out.println(acorn);
        return "redirect:/home";
    }
}
