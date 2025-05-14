package com.acorn.day2Batis;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
class OrderRpository {



    @Autowired
    SqlSession session;


    public List<Map<String, Object>> selectAll(){
      return   session.selectList( "b.SelectAll");
    }
}
