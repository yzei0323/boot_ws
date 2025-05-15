package com.acorn.mybatisFor;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Member {

    String id;
    String name;
    String email;

}


/*


CREATE TABLE membertbl (
    id   varchar2(10) primary key  ,
    name VARCHAR2(50),
    email VARCHAR2(50)
);

insert into membertbl values('acorn','권지언','aaa@naver.com');
insert into membertbl values('acorn3','윤현기','bbb@goole.com');
insert into membertbl values('acorn4','박예린','ccc@naver.com');
commit;




 */