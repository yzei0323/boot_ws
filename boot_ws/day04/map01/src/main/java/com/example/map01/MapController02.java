package com.example.map01;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
/*


 클리한 위치에 마커 출력하기  (위도, 경도)


 */
@Controller
public class MapController02 {
    @GetMapping("/map02")
    public  String   map02(){
        return "map02";
    }
}
