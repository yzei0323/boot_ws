package com.acorn.mybatisFor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public class MemberRepository {

    private final SqlSession sqlSession;


    @Autowired
    public MemberRepository(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }




    public void insertMember(  Member  member ) {
        sqlSession.insert("a.insertMember", member );
    }




    /* 전체 조회 */
    public List<Member> selectAll() throws  Exception{
        return   sqlSession.selectList( "a.SelectAll");
    }



   /*   in ( )
   
     in에 들어갈 내용을 동적으로 생성하기
     forEach 사용하기 
    
   * */
    public List<Member> selectAll2(    List<String> userid) throws  Exception{
        return   sqlSession.selectList( "a.selectMembers" ,userid);
    }

}
