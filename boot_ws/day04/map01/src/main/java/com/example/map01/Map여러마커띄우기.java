package com.example.map01;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Map여러마커띄우기 {


    @GetMapping("/map05")
    public  String map05(){
        return "map05";
    }


    @GetMapping("/map06")
    public  String map06(){
        return "map06";
    }

    @GetMapping("/map07")
    public  String map07(){
        return "map07";
    }


    @GetMapping("/map077")
    public  String map077(){
        return "map077";
    }
}
