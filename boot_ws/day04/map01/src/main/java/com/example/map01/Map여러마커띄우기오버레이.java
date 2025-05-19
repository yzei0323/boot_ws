package com.example.map01;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Map여러마커띄우기오버레이 {


    @GetMapping("/map04")
    public  String map04(){
        return  "map04";
    }
}
