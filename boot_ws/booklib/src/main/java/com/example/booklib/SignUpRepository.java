package com.example.booklib;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class SignUpRepository {

    private SqlSession session;
    private String namespace = "com.example.UserSignUpMapper.";

    public int insertUser(UserDTO user) throws Exception {
        return session.insert(namespace + "insertUser", user);
    }
}
