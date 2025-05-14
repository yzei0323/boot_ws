package com.acorn.day02Prac;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class FriendController {

    @Autowired
    FriendService service;

    //조회
    @GetMapping("/friends")
    public String getFriends(Model model){
        List<Friend> list = service.getFriends();
        System.out.println(list);
        model.addAttribute("list", list);

        return "friends";
    }


    //등록화면
    @GetMapping("/add")
    public String form(){
        return "formView";
    }

    //등록
    @PostMapping("/formResult")
    public String addFriend(@ModelAttribute Friend friend){
        System.out.println(friend);

        //
        service.addFriend(friend);
        return "ok";
    }


    //변경화면
    @GetMapping("/update")
    public String form2() {
        return "formView2";
    }

    //변경하기
    @PostMapping("/updateResult")
    public String modeifyFriend(@ModelAttribute Friend friend){
        System.out.println(friend);

        service.modifyFriend(friend);
        return "ok";
    }



}
