package com.example.map01;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MapController01 {


    @GetMapping("/map01")
    public  String map01(){
        return "map01";
    }
}
