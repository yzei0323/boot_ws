package com.example.ExceptionEx;

import lombok.SneakyThrows;

import java.io.IOException;


//한 문자 읽기
public class 예외처리하기 {


    public static void main(String[] args) {
        try {
            System.in.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
