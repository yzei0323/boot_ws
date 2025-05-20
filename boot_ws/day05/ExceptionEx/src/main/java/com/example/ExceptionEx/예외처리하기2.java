package com.example.ExceptionEx;

public class 예외처리하기2 {

    public static void main(String[] args) {

        int money=-1;

        try {
            int result  =doubler(money);
        } catch (Exception e) {

            System.out.println("음수는 안됩니다");
            throw new RuntimeException(e);
        }

        System.out.println( "프로그램 정상 종료");
        System.out.println( "투자보고서");

    }


    //매서드예외서 예외를 throws 하면 상위매서드로 전달된다
    public static  int doubler( int money) throws Exception {
        if( money<=0) throw new Exception( "음수안도ㅐ");
        return  money*2;
    }
}
