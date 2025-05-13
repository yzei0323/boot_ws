package com.acorn.day1;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Hi {


    @ResponseBody
    @GetMapping("/hi")
    public  String  hi(){

        return  "hi^___^^!!!!!!!";
    }




    @GetMapping("/hi2")
    public  String hi2( ){
        //모델
        return "hiview";

    }

}
