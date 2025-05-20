package com.acorn.day05PracException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.SQLException;

@Controller
public class TestController2 {

    @GetMapping("/method1")
    public String method1() {
        String viewName = "method1View";
        try {
            throw new SQLException("db 오류");
        } catch (SQLException e) {
            //예외발생상황
            viewName = "errSQL";
        }
        return viewName;
    }


    @GetMapping("/method2")
    public String method2() {
        String viewName = "method1View";
        try {
            throw new SQLException("db 오류");
            //service.getMembers();
        } catch (SQLException e) {
            //예외발생상황
            viewName = "errSQL";
        }
        return viewName;
    }


    @GetMapping("/method3")
    public String method3() {
        String viewName = "method1View";
        try {
            throw new SQLException("db 오류");
        } catch (SQLException e) {
            //예외발생상황
            viewName = "errSQL";
        }
        return viewName;
    }



/*
    // 1이면 오류 안나게, 2면 오류가 나게
    @GetMapping("/method2")
    public String method2() {
        String viewName = "method2View";
        int result = 2;

        if (result == 1) {
            //오류발생
            viewName = "errSQL";
            try {
                throw new SQLException("데이터베이스 오류");
            } catch (SQLException e) {
                //throw new RuntimeException(e);
            }
        } else if (result == 2) {
            viewName = "method2View";
        }

        return viewName;
    }
*/

}
