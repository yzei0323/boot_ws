package com.acorn.day1Prac;

import org.springframework.stereotype.Service;

@Service
public class CalcService {

    public int plus(int su1, int su2){
        return su1+su2;
    }

    public int minus(int su1, int su2){
        return su1-su2;
    }

    public int multi(int su1, int su2){
        return su1*su2;
    }

    public double divide(int su1, int su2){
        return (double) su1/su2;
    }
}
