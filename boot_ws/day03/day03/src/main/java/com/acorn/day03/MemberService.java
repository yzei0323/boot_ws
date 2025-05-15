package com.acorn.day03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    @Autowired
    MemberRepository repository;

    public List<Member> getSearchMember(List<String> userid){
        return repository.selectSearch(userid);
    }
}
