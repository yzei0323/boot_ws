package com.acorn.day07PracCookie;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    // 사용자의 나이대에 따른 뷰를 응답하려고 할 때
    // 사용자 나이 정보를 쿠키를 이용해서 사용자 pc에 저장하고 사용하는 방법
    @GetMapping("/home")
    public String home(@CookieValue(name="age", required=false) String age,
                       HttpServletResponse response){

        //쿠키정보 가져오기
        //쿠키 없는 경우
        if( age == null ){
            age="25";       //세션의 로그인 정보, 디비에서 조회
            Cookie cookie = new Cookie("age", age);
            cookie.setMaxAge(60*60*24*365);    //초*분*시간*day
            cookie.setPath("/");        //모든경로 접근시 쿠키전달
            response.addCookie(cookie);
            return "home";
        }

        //쿠키 있는 경우
        int ageInt = Integer.parseInt(age); //"25" -> 25
        String viewName="";
        if(ageInt>=20 && ageInt<=29){
            viewName="view20";
        }else if(ageInt>=40 && ageInt<=59){
            viewName="view4050";
        }else{
            viewName="home";
        }
        return viewName;
    }

}
