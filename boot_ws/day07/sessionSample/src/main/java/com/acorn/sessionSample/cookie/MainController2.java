package com.acorn.sessionSample.cookie;



import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController2 {

    @GetMapping("/main")
    public String main(  @CookieValue(name = "age", required = false) String age,       HttpServletResponse response) {

        if (age == null) {
            // age 쿠키가 없을 경우
            age = "40"; // 예: 로그인한 사용자의 데이터를 DB에서 가져온 값
            Cookie ageCookie = new Cookie("age", age);
            ageCookie.setMaxAge(60 * 60 * 24 * 365); // 1년
            ageCookie.setPath("/"); // 모든 경로에서 접근 가능
            response.addCookie(ageCookie); // 응답에 쿠키 추가
            return "main"; // 기본 뷰 반환
        }

        // age 쿠키 값에 따라 다른 뷰 반환
        int ageInt = Integer.parseInt(age);
        if (ageInt >= 20 && ageInt < 30) {
            return "view20"; // 20대를 위한 뷰
        } else if (ageInt >= 40 && ageInt < 50) {
            return "view40"; // 40대를 위한 뷰
        } else {
            return "main"; // 기본 뷰
        }
    }
}
