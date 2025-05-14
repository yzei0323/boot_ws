package com.acorn.day2Batis;


import lombok.Data;

@Data
public class Member {

    String id;
    String name;
    String email;

}


/*


CREATE TABLE membertbl (
    id VARCHAR2(50) PRIMARY KEY,
    name VARCHAR2(100) NOT NULL,
    email VARCHAR2(100) UNIQUE NOT NULL
);

 */