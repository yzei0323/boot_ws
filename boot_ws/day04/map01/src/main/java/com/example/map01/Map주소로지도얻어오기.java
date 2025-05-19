package com.example.map01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Map주소로지도얻어오기 {

    @GetMapping("/map08")
    public String map(){
        return "map08";
    }
}
