package com.acorn.day01Hello;

import ch.qos.logback.core.CoreConstants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TaskController {

    // 두 수 더한 값을 반환하는 문제
    // TaskService

    @GetMapping("/calc")
    public String task1(
            @RequestParam (name="su1", required = false, defaultValue = "1") int su1,
            @RequestParam (name="su2", required = false, defaultValue = "1") int su2, Model model){

        int result = su1+su2;
        System.out.println(result);
        model.addAttribute("result", result);

        return "task1";
    }

}
