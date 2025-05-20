package com.acorn.day05PracException;

public class 예외처리하기2 {

    public static void main(String[] args) {

        int money = 5000;
        int result = 0;
        try {
            result = doubler(money);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("처리되지 않았습니다");
            throw new RuntimeException(e); //이 코드가 있는 거랑 없는거랑 차이가 있음
            //ㄴ 예외를 다시 일으키기 => 정상적인 흐름이 아니고 중단되게 할 수 있다
        }

        System.out.println("투자 보고서");
        System.out.println("투자 금액: " + money);
        System.out.println("투자 결과: " + result);
        System.out.println("프로그램 정상 종료 !!!");
    }

    //매서드 만들기
    // int doubler(int money)
    public static int doubler(int money) throws Exception{
        //money가 음수면 예외를 발생시키기
        if(money<=0) throw new Exception("음수안돼");
        return money*2;
    }
}
