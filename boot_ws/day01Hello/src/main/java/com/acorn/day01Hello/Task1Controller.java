package com.acorn.day01Hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Task1Controller {

    @Autowired
    Task1Service service;

    @GetMapping("/calc2")
    public String task1(
            @RequestParam (name="su1", required = false, defaultValue = "1") int su1,
            @RequestParam (name="su2", required = false, defaultValue = "1") int su2, Model model){


        int result = service.add(su1, su2);
        model.addAttribute("result", result);

        return "task1";
    }

}
