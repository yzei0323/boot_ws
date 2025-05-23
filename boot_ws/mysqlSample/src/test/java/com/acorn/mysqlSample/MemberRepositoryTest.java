package com.acorn.mysqlSample;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberRepositoryTest {


    @Autowired
    MemberRepository repository;



    @Test
    public  void test1(){

        int size  = repository.selectAll().size();

        assertTrue(size >=1);


    }
}