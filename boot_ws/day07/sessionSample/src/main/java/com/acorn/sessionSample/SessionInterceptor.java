package com.acorn.sessionSample;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;

public class SessionInterceptor  implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
      //  return HandlerInterceptor.super.preHandle(request, response, handler);

        HttpSession  session  = request.getSession(false);

        //

        if( session ==null  ||  session.getAttribute("userId")== null){

            response.sendRedirect("/login/login");
            return  false;

        }


        return  true;
    }
}
