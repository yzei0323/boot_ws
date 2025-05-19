package com.acorn.day04Prac;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor  //기본생성자
@AllArgsConstructor //이건뭔데게터세터인가
@Data
public class Item {
    String title;
    String lat;
    String lng;
}
