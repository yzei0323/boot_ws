package com.acorn.Prac;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepository {

    @Autowired
    SqlSession session;

    /*
    public List<Book> selectSearch(List<String> bookId){
        return session.selectList("a.selectSearch", bookId);
    }
    */


    public List<Book> selectBookSearch(SearchCondition condition){
        return session.selectList("a.selectBook", condition);
    }
}
