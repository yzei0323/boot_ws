package com.acorn.day02Prac;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FriendRepositoryTest {

    @Autowired
    FriendRepository repository;

    //조회 테스트
    //@Test
    public void test(){
        int result = repository.selectAll().size();
        assertTrue(result >= 1);
    }

    //등록 테스트
    //@Test
    public void test2(){
        Friend f = new Friend();
        f.setName("황예지");
        f.setPwd("2002");
        f.setBirth("0106");
        repository.insert(f);
    }

    //변경 테스트
    @Test
    public void test3(){
        Friend f = new Friend();
        f.setPwd("2002");
        f.setBirth("0106");
        f.setName("황예지");
        repository.update(f);
    }

}