package com.example.booklib;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookLibRepository {

    @Autowired
    private SqlSession session;
    private String namespace = "com.example.BookLibMapper";

    public List<BookLibDTO> getBookLibList(SearchCondition condition) throws Exception {
        return session.selectList(namespace + ".getBookLibList", condition);
    }
}
