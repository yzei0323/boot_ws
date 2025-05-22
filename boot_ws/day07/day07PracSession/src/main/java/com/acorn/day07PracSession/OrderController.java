package com.acorn.day07PracSession;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderController {

    @GetMapping("/order")
    public String getOrderList(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if( session==null || session.getAttribute("USERID")==null ){
            return "redirect:/loginForm";
        }
        return "orderList";
    }
    //로그인 해야만 /order 페이지 갈 수 있음
    //로그인 안한 상태에서 /order가면 /loginForm으로 이등

}
