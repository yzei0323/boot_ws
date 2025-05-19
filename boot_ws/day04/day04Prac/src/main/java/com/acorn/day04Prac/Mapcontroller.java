package com.acorn.day04Prac;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.thymeleaf.model.IModel;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@Controller
public class Mapcontroller {

    @GetMapping("/map1")
    public String map1(){
        return "map1View";
    }

    @GetMapping("/map2")
    public String map2(){
        return "map2View";
    }

    @GetMapping("/map3")
    public String map3(Model model){

        /*
        var positions = [
        {
            title: '카카오',
            latlng: new kakao.maps.LatLng(33.450705, 126.570677)
        },
        {
            title: '생태연못',
            latlng: new kakao.maps.LatLng(33.450936, 126.569477)
        },
        {
            title: '텃밭',
            latlng: new kakao.maps.LatLng(33.450879, 126.569940)
        },
        {
            title: '근린공원',
            latlng: new kakao.maps.LatLng(33.451393, 126.570738)
        }
    ];

        // 각각의 위치정보객체 생성
        title:
        lat:
        lng:

        */

        Item item1 = new Item();
        item1.setTitle("카카오💛");
        item1.setLat("33.450705");
        item1.setLng("126.570677");

        Item item2 = new Item();
        item2.setTitle("생태연못💧");
        item2.setLat("33.450936");
        item2.setLng("126.569477");

        Item item3 = new Item();
        item3.setTitle("텃밭🌿");
        item3.setLat("33.450879");
        item3.setLng("126.569940");

        Item item4 = new Item();
        item4.setTitle("근린공원🌳");
        item4.setLat("33.451393");
        item4.setLng("126.570738");

        List<Item> list = new ArrayList<>();
        list.add(item1);
        list.add(item2);
        list.add(item3);
        list.add(item4);

        //list => Gson라이브러리 이용해서 json 변환해서 모델로 저장
        // 타임리프를 사용하는 view에서는 json 변환하지 않고 그냥 자바객체로 전달가능
        // 타임리프에서 th:inline 속성을 사용하면 자바객체를 json으로 자동변환해줌

        System.out.println(list);
        model.addAttribute("list",list);

        return "map3View";
    }

}
