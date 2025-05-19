package com.acorn.day04Prac;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;

@Controller
public class ApiController {

    @Autowired
    ApiExplorer4 api;

    //api요청 데이터를 그대로 json으로 응답하기
    @ResponseBody   //view가 아닌 데이터로 응답
    @GetMapping(value="/data",  produces = "application/json;charset=utf-8")
    public String data() throws IOException {
        return api.getData();
    }

    @ResponseBody
    @GetMapping("/dataList")
    public List<DataDTO> getData2() throws IOException {
        String data = api.getData();
        List<DataDTO> dataDTOList = api.fromJsonToDataDTO(data);
        return dataDTOList;
    }

    @GetMapping("/dataView")
    public String getDataList(Model model) throws IOException {
        String data = api.getData();
        List<DataDTO> list = api.fromJsonToDataDTO(data);

        //모델에 저장하기
        model.addAttribute("list", list);
        return "dataView";
    }


}
