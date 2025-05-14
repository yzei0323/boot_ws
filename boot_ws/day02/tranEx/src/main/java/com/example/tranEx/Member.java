package com.example.tranEx;

import lombok.Data;


@Data
public class Member {

    String id;
    String name;
}


/*


CREATE TABLE membert (
    id   VARCHAR2(50) PRIMARY KEY,
    name VARCHAR2(100) NOT NULL
);

 */