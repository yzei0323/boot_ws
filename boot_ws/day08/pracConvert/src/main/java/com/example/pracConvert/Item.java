package com.example.pracConvert;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class Item {

    Long money;
    String name;
    //initBinder로 등록하는 대신 간단하게 처리할 수 있다
    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    Date inDate;


}
