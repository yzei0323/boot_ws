package com.acorn.Prac;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    @Autowired
    SqlSession session;

    //회원가입
    public int insert(LibUser user){
        return session.insert("user.insert", user);
    }

    //로그인
    public LibUser login(LibUser user){
        return session.selectOne("user.login", user);
    }
}
