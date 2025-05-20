package com.acorn.day05PracException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.SQLException;

@Controller
public class TestController3 {

/*
    //클래스 내에서 발생하는 예외처리 방법
    @ExceptionHandler(SQLException.class)
    public String catcher(Model model, SQLException ex){
        //여러객체정보를 뷰에서 활용할 수 있다
        // model.addAttribute("ex", ex);
        return "errSQL";
    }
*/

    @GetMapping("/method4")
    public void method4() throws SQLException {
        throw new SQLException("db 오류");
    }

    @GetMapping("/method5")
    public void method5() throws SQLException {
        throw new SQLException("db 오류");
    }

    @GetMapping("/method6")
    public void method6() throws SQLException {
        throw new SQLException("오류발생");
    }

}
