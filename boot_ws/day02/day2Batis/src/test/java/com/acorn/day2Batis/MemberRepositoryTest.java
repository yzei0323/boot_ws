package com.acorn.day2Batis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Transactional    //테스트하고 자동으로 롤백처리함 !!!
//@Rollback (value=false)   // 롤백처리하고 싶지 않을 때  사용함
class MemberRepositoryTest {


    @Autowired
    MemberRepository repository;


    @Test
    public  void test1(){

        Member m= new Member();
        m.setId("acorn5");
        m.setName("홍길동");
        m.setEmail("hong@google.com");

       int result  = repository.insert( m );
       assertEquals( 1 , result);


    }

}