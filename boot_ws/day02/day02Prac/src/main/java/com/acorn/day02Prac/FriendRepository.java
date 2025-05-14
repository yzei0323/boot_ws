package com.acorn.day02Prac;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FriendRepository {

    @Autowired
    SqlSession session;

    //친구전체조회
    public List<Friend> selectAll(){
        return session.selectList("a.selectAll"); //mapper에 있는거
    }

    //친구추가
    public int insert(Friend friend){
        return session.insert("a.insert", friend);
    }

    //친구정보변경
    public int update(Friend friend){
        return session.update("a.update", friend);
    }



}
