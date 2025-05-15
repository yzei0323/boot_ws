package com.acorn.mybatisFor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberService {

    @Autowired
    private MemberRepository repository;

    public void registerCustomers( ) {

        List<Member> members = new ArrayList<>();
        // 고객 정보 3개 추가
        members.add(new Member("acorn", "권지언", "jiun@domain.com"));
        members.add(new Member("acorn4", "윤현기", "hyungi@domain.com"));
        members.add(new Member("acorn3", "박예린", "yelin@domain.com"));

        for(  Member  member:  members){
            repository.insertMember(member);
        }


    }


    public List<Member> getMembers() throws Exception {
        return   repository.selectAll();
    }


    public List<Member> getMembers2( List<String> userid) throws Exception {
        return   repository.selectAll2(   userid);
    }
}
