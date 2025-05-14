package com.example.tranEx;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {

    @Autowired
    SqlSession session;


    public  int memberRegistry(Member member){
       return session.insert("a.insertMember" , member);
    }
}
