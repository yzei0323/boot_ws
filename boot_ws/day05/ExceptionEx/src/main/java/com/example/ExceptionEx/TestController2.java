package com.example.ExceptionEx;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.SQLException;

@Controller
public class TestController2 {




    @GetMapping("/method1")
    public   String   method1()   {

        String viewName= "method1";
        try {
            throw new SQLException("db 오류");
        }catch ( SQLException e){

            viewName="errSQL";
        }
        return  viewName;
    }


    @GetMapping("/method2")
    public   String   method2()   {

        String viewName= "method2";
        try {
            throw new SQLException("db 오류");
        }catch ( SQLException e){

            viewName="errSQL";
        }
        return  viewName;
    }


}
