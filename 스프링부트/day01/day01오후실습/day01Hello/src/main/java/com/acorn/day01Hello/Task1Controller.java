package com.acorn.day01Hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class Task1Controller {

    @Autowired
    Task1Service service;

    @GetMapping("/calc")
    public String task1(@RequestParam(name = "su1", required = false, defaultValue = "1") int su1,
                        @RequestParam(name = "su2", required = false, defaultValue = "1") int su2,
                        Model model) {
        int result = service.add(su1, su2);

        //int result = su1+su2;
        model.addAttribute("result",result);
        return "task1";
    }

    @GetMapping("/team")
    public String getMembers(Model model) {
        List<User> team1 = new ArrayList<>();
        team1.add(new User("acorn1","윤현기","010-9336-4282"));
        team1.add(new User("acorn1","권지언","010-4699-6749"));
        team1.add(new User("acorn1","임형택","010-9959-8251"));
        team1.add(new User("acorn1","김보성","010-7766-5927"));
        team1.add(new User("acorn1","이수민","010-8383-7869"));

        model.addAttribute("team1",team1);

        return "team1";
    }
    @GetMapping("/teamall")
    public String getProjectAll(Model model) {
        List<User> team1 = new ArrayList<>();
        team1.add(new User("acorn1","윤현기","010-9336-4282"));
        team1.add(new User("acorn1","권지언","010-4699-6749"));
        team1.add(new User("acorn1","임형택","010-9959-8251"));
        team1.add(new User("acorn1","김보성","010-7766-5927"));
        team1.add(new User("acorn1","이수민","010-8383-7869"));
        Map<String, List<User>> map = new HashMap<>();
        map.put("1",team1);
        model.addAttribute("team",map);
        return "teamAll";
    }
}
