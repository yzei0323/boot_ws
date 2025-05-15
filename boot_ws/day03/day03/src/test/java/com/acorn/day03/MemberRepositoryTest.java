package com.acorn.day03;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository repository;

    @Test
    public void test(){
        List<String> userid = new ArrayList<>();
        userid.add("acorn");
        userid.add("acorn3");
        userid.add("acorn4");
        int size = repository.selectSearch(userid).size();

        assert(size >= 2);
    }

}