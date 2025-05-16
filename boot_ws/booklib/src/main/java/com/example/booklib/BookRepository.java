package com.example.booklib;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepository {

    @Autowired
    private SqlSession session;
    private String namespace = "com.example.BookMapper";

    public List<BookLibDTO> getBookList(SearchCondition condition) throws Exception {
        return session.selectList(namespace + ".getBookList", condition);
    }
}
