package com.example.ExceptionEx;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping("/test")
    public void  method() throws Exception {
          throw new Exception("오류");
    }
}
