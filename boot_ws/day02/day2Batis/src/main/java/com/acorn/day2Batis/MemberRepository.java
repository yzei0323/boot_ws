package com.acorn.day2Batis;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberRepository {


    @Autowired
   private SqlSession  session;



    //전체조회하기
    public List<Member> selectAll(){
      List<Member>  list  = session.selectList("a.SelectAll");
      return list;
    }



    public int  insert(Member member){
       return   session.insert( "a.insert" , member);    //

    }

}
