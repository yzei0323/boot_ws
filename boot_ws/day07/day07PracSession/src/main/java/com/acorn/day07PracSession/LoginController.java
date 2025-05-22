package com.acorn.day07PracSession;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping("/loginForm")
    public String loginForm(){
        return "loginForm";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute User user, HttpServletRequest request){
        System.out.println(user);

        //user Check
        if(!check(user)){   //사용자 확인이 안 된 경우
            return "loginForm";
        }

        //인증완료 된 후 세션저장소에 로그인정보 저장하기
        HttpSession session = request.getSession();
        //request.getSession(true); => true는 생략할 수 있음

        //사용자 세션을 얻어옴
        //기존에 사용자 세션이 있으면 있는 세션이 반환
        //세션이 없다면 새로운 세션을 반환
        //다른 요청에서도 사용할 정보를 저장함 (세션에 저장하기)

        session.setAttribute("USERID", user.getId());
        return "redirect:/home";
    }

    //사용자 check
    boolean check(User user){   //아이디, 비번 같은 사용자 확인됨
        if(user.getId().equals(user.getPw())){
            return true;
        }else{
            return false;
        }
    }

    @GetMapping("/logout")
    String logOut( HttpServletRequest request){
        //세션정보 삭제하기
        HttpSession session  =request.getSession(false)    ;
        session.invalidate();
        //
        // session.removeAttribute("USERID");

        return "redirect:/home";
    }

}
