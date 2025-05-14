package com.acorn.day1Prac;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DanService {

    public ArrayList<String> showdan3(){
        ArrayList<String> dan3 = new ArrayList<String>();

        for(int i=1; i<=9; i++){
            dan3.add("3 × "+i+" = "+3*i);
        }

        return dan3;
    }

    public ArrayList<String> gugudan(int num){
        ArrayList<String> dan = new ArrayList<String>();

        for(int i=1; i<=9; i++){
            dan.add(num+" × "+i+" = "+num*i);
        }

        return dan;
    }


}
