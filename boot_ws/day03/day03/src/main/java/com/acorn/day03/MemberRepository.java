package com.acorn.day03;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberRepository {

    @Autowired
    SqlSession session;

    public List<Member> selectSearch( List<String> userid ){
        return session.selectList("a.selectSearch", userid);
    }

}
