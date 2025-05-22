package com.acorn.day07PracSession;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

    @GetMapping("/board")
    public String getList(HttpServletRequest request){

        /*
            로그인 확인 => 세션저장소에 저장해놓은 정보 활용
        */

        HttpSession session = request.getSession(false);

        //request.getSession(false);
        //세션을 얻어올 때 false이면 => 기존에 세션이 없다면 null을 반환
        //                        => 기존에 세션이 있다면 기본 세션을 반환

        if(session==null || session.getAttribute("USERID")==null){
            //로그인이 안된 사용자 !!
            return "redirect:/loginForm";
        }
        return "boardList";
    }
}
