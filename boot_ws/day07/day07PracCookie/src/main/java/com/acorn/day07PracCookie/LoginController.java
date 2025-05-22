package com.acorn.day07PracCookie;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("/loginForm")
    String loginFrom(@CookieValue(name="id", required = false, defaultValue="")String id,
                     Model model){

        model.addAttribute("id", id);
        return "loginForm";
    }

    @PostMapping("/login")
    String login(@RequestParam(name="id", required = false) String id,
                 @RequestParam(name="pw", required = false) String pw,
                 @RequestParam(name="rmid", required = false) boolean rmid,
                 HttpServletResponse response){

        System.out.println(id);
        System.out.println(pw);
        System.out.println(rmid);

        //실패하면 return "loginForm";


        //
        if(rmid){  //아이디 기억하기

            //쿠키생성
            //쿠키응답
            Cookie cookie = new Cookie("id", id);
            cookie.setMaxAge(60*60*24);
            //쿠키응답 (응답하려면 response필요함 HttpServletResponse)
            response.addCookie(cookie);

        }else{  // 아이디 기억 안하기
                // (쿠키를 삭제할 때는 동일한 이름으로 쿠키를 생성한 다음,
                // 만료시간을 0으로 설정하고 다시 쿠키를 응답하는 방법을 사용)
            //쿠키 생성, 이전에 생성한 쿠키와 동일한 이름으로 생성
            //쿠키 응답
            System.out.println("아이디 안 기억하기");

            Cookie cookie = new Cookie("id", id);
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }
        return "redirect:/home";
    }

}
