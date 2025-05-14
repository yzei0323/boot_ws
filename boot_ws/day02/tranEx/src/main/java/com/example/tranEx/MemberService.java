package com.example.tranEx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberService {


    @Autowired
    MemberRepository  memberRepository;
    @Autowired
    PointRepository pointRepository;



    /*

       논리적단위 :
       모두 수행되거나 수행되지않게 하기

     */


    @Transactional
    public void  회원가입포인트적립( Member member){

        //회원가입
        memberRepository.memberRegistry(member);

        if(true) throw new RuntimeException(" 예외 발생시킴");

        //포인트등록
        PointDTO point  = new PointDTO();
        point.setMemberId(member.getId());
        point.setAmount(10000);


        pointRepository.pointRegistry(point);


    }

}
