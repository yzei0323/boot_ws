package com.acorn.mysqlSample;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberRepository {

    @Autowired
    private SqlSession sqlSession;

    public List<Member> selectAll() {
        return sqlSession.selectList("a.SelectAll");
    }




}
