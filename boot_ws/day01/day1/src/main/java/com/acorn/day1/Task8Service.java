package com.acorn.day1;


import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class Task8Service {


    public  String getRandomMessage(){



        //
        String[] messages = new String[]{
                "안녕하세요!",
                "오늘도 화이팅!",
                "스프링부트 시작 화이팅 !",
                "즐거운 오후 되세요"
        };


        Random r = new Random();
        int randomIndex  = r.nextInt(messages.length);  // 4-> 0~3사이의 임의의 수 반환

        String randomMessage  = messages[randomIndex];

        return randomMessage;

    }
}
