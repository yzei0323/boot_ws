package com.example.day04Prac;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;

@Controller
public class ApiController {

    @Autowired
    // ApiExplorer2  api;
    ApiExplorer4 api;

    //api요청 데이터를  그대로  json 으로 응답하기

    @ResponseBody
    @GetMapping(value="/data" ,  produces = "application/json;charset=utf-8" )
    public  String  data() throws IOException {
        return  api.getData();
    }



    @ResponseBody
    @GetMapping("/dataList")
    public List<DataDTO> getData2() throws IOException {
        String data= api.getData();
        List<DataDTO>  dataDTOList= api.fromJsonToDataDTO(data);
        return   dataDTOList;

    }



}
