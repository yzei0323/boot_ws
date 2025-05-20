package com.example.ExceptionEx;


import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.sql.SQLException;

@Controller
public class TestController3 {

/*
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    @ExceptionHandler(SQLException.class)
    public String catcher1( Model model, SQLException ex ) {
        model.addAttribute("ex", ex);
        return "errSQL";
    }

*/


    @GetMapping("/method3")
    public   void   method1() throws SQLException {
            throw new SQLException("db 오류");

    }


    @GetMapping("/method4")
    public   String   method2() throws SQLException {
            throw new SQLException("db 오류");

    }


}
