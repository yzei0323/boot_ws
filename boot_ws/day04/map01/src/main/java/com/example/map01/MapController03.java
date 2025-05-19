package com.example.map01;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MapController03 {


    @GetMapping("/map03")
    public  String map03(){
        return "map03";
    }
}
