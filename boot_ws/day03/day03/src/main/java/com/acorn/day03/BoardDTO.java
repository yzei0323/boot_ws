package com.acorn.day03;

import lombok.Data;

@Data
public class BoardDTO {
/*
    CREATE TABLE boardt (
            board_no NUMBER PRIMARY KEY,
            title    VARCHAR2(200),
            writer   VARCHAR2(100),
            content  VARCHAR2(100)
    );
*/

    int board_no;
    String title;
    String writer;
    String content;

}
