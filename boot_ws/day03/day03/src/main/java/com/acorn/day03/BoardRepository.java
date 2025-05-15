package com.acorn.day03;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardRepository {

    @Autowired
    SqlSession session;

    //SearchCondition 객체 안에 condition, keyword
    public List<BoardDTO> selectBoardSearch(SearchCondition condition){
        return session.selectList("b3.selectBoard", condition);
    }

}
