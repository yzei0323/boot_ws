package com.example.tranEx;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PointRepository {

    @Autowired
    SqlSession session;


    public  int pointRegistry(PointDTO point){
       return session.insert("b.insertPoint" , point);
    }
}
