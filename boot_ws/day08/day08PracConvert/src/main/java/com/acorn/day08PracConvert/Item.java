package com.acorn.day08PracConvert;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

//대표적인 convert 오류
// null일 때 발생 -> int 기본자료형 데이터를 담으려고 할 때
// "문자열" -> int, Integer 오류 발생
// "2025/05/22" -> Data ( 문자열을 날짜타입으로 변환할 때 )
//=> 400 오류 (request bad , )

// 변환오류 발생하면 오류화면 응답
// 변환오류 발생했을 때 처리 ()한 후 사용자친화적인 오류메시지를, 원래 폼에서 확인하게 해줘야 함

@Data
public class Item {
    Long money;
    String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date inDate;
}
