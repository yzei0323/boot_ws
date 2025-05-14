package com.acorn.day02Batis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    // @Autowired 필드주입
    final MemberRepository repository;
    //final은 생성자주입할때 씁니다

    @Autowired  //생성자주입
    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }


    //회원조회 서비스
    public List<Member> getMembers(){
        return repository.selectAll();
    }

    //회원가입 서비스
    public int registerMember(Member member){
        return repository.insert(member);
    }

}
