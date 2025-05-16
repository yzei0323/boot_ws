package com.acorn.Prac;

import lombok.Data;

/*
CREATE TABLE LibUser(
    ID VARCHAR2(10) NOT NULL primary key,
    PW VARCHAR2(10) NOT NULL,
    NAME VARCHAR2(20) NOT NULL
);
 */


@Data
public class LibUser {
    String id;
    String pw;
    String name;
}
