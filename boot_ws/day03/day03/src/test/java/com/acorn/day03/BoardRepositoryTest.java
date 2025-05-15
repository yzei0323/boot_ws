package com.acorn.day03;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.MergedAnnotations;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardRepositoryTest {

    @Autowired
    BoardRepository repository;

    @Test
    public void test(){
        SearchCondition condition = new SearchCondition();
        condition.setCondition("writer");
        condition.setKeyword("브래드피트");
        int size = repository.selectBoardSearch(condition).size();
        assertTrue(size==1);

        //select * from board where content like % 한효주 %
    }
}