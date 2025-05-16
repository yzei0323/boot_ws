package com.acorn.Prac;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    //회원가입
    public int register(LibUser user) {
        return repository.insert(user);
    }

    //로그인
    public LibUser login(LibUser user){
        return repository.login(user);
    }
}
