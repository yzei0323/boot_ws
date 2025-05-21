package com.acorn.day06Prac;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository repository;

    //@Test
    public void test(){
        List<Member> list = repository.selectAll();
        assertTrue(list.size()>=1);
    }

    //@Test
    public void test2(){
        List<Member> list = repository.selectPage(2, 3);
        assertTrue(list.size()>=1);
    }

    @Test
    public void test3(){
        int result =repository.countAll();
        assertTrue(result==12);
    }

}