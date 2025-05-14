package com.acorn.day02Batis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberRepositoryTest {

    //레포지토리가 다 가져온거 맞아?? 조회된거 맞아??? 확인하려고 테스트 하는겅미

    @Autowired
    MemberRepository repository;

    //조회 테스트
    //@Test
    public void test(){
        int result = repository.selectAll().size();
        assertTrue( result >= 1 );  //사이즈가 1개 이상이면?? 통과
    }

    //등록테스트
    //@Test
    public void test2(){
        Member m = new Member();
        m.setId("a100");
        m.setPw("2222");
        m.setName("홍길동");
        repository.insert(m);
    }

   // @Test
    public void test3(){
        Member2 member2 = repository.selectAll2().get(0);

        System.out.println(member2);
        String id = member2.getM_id();

    }

    @Test
    public void test4(){
        Member2 member2 = repository.selectAll2().get(0);

        System.out.println(member2);
        String id = member2.getM_id();

    }



}