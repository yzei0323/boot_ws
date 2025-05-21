package com.acorn.day06Prac;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MemberRepository {

    @Autowired
    SqlSession session;

    public List<Member> selectAll(){
        return session.selectList("a.selectAll");
    }

    public List<Member> selectPage(int currentPage, int pageSize){
        //현재페이지에 대한 시작, 끝 구하기 ( pageSize 정보가 필요함 )

        //currentPage=1
        //pageSize=5 라고 가정
        //start = 1
        //end   = 5

        //currentPage=2
        //pageSize=5 라고 가정
        //start = 6
        //end   = 10

        //currentPage=3
        //pageSize=5 라고 가정
        //start = 11
        //end   = 16

        // 1  2  3  4  5
        // 6  7  8  9  10
        // 11 12 13 14 15

        int end = currentPage * pageSize;
        int start = (currentPage-1) * pageSize + 1;

        //매개변수를 객체로 사용해야 함
        Map<String, Integer> pageInfo = new HashMap<>();
        pageInfo.put("start", start);
        pageInfo.put("end", end);

        return session.selectList("a.selectPage", pageInfo);
    }

    public int countAll(){
        return session.selectOne("a.selectCount");
    }


}
