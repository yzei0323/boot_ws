package com.acorn.day06Prac;

public class PageHandlerMain {
    public static void main(String[] args) {


        // 페이징관련 데이터처리
        //1. 현재페이지 ( 기본값: 1, 사용자가 선택한 페이지 )
        //2. 한 페이지에 보이는 글의 수 ( 페이지 사이즈 )
        //3. 그룹의 사이즈 : 그룹에 포함되는 페이지의 수
        //4. 전체 레코드 수 : db


        //5. 전체 페이지 수 구하기 ( 전체레코드수 / 페이지사이즈 ), 나머지 있는 경우 +1
        //6. 현재페이지에 대한 현재그룹 구하기 ( 전체페이지수 / 그룹의사이즈), 나머지 있는 경우 +1
        //7. 현재 그룹에 대한 그룹 시작, 그룹 끝 구하기
        //   그룹 시작 : (현재그룹-1) * 그룹사이즈 +1
        //   그룹의 끝 : 현재그룹 * 그룹사이즈
        //8. 현재그룹의 시작 ~ 현재그룹의 마지막까지 반복

        /*
        1페이지  =>   1그룹  =>       [  1    2    3    4    5   ]
        2페이지  =>   1그룹  =>       [  1    2    3    4    5   ]
        3페이지  =>   1그룹  =>       [  1    2    3    4    5   ]
        4페이지  =>   1그룹  =>       [  1    2    3    4    5   ]
        5페이지  =>   1그룹  =>       [  1    2    3    4    5   ]
        6페이지  =>   2그룹  =>       [  6    7    8    9   10 ]
        7페이지  =>   2그룹  =>       [  6    7    8    9   10 ]
        8페이지  =>   2그룹  =>       [  6    7    8    9   10 ]
        9페이지  =>   2그룹  =>       [  6    7    8    9   10 ]
        10페이지  =>   2그룹  =>       [  6    7    8    9   10 ]
        11페이지  =>   3그룹  =>       [  11 12    13  14  15 ]
        12페이지  =>   3그룹  =>       [  11 12    13  14  15 ]
        13페이지  =>   3그룹  =>       [  11 12    13  14  15 ]
        14페이지  =>   3그룹  =>       [  11 12    13  14  15 ]
        15페이지  =>   3그룹  =>       [  11 12    13  14  15 ]
        16페이지  =>   4그룹  =>       [  16  ]
        */

        int currentPage;
        int pageSize;
        int grpSize;
        int totRecords;

        int totalPage;
        int currentGrp;
        int grpStartPage;
        int grpEndPage;

        currentPage=1;
        pageSize=5;
        grpSize=4;
        totRecords=46;

        int remain = totRecords % pageSize;

        if(remain==0){
            totalPage = totRecords / pageSize;
        }else{
            totalPage = (totRecords / pageSize) + 1;
        }

        //현재그룹 구하기
        int remain2 = currentPage % grpSize;

        if(remain2==0){
            currentGrp = currentPage / grpSize;
        }else{
            currentGrp = (currentPage / grpSize) + 1;
        }

        //현재그룹의 시작 번호
        //현재그룹의 마지막 번호

        //1     1그룹     1 2 3 4 5
        grpStartPage = (currentGrp-1) * grpSize + 1;  //1
        grpEndPage = currentGrp * grpSize;      // 1*5 => 5


        //그룹의 마지막 확인하기
        if( grpEndPage > totalPage ){
            grpEndPage = totalPage;
        }

        System.out.println(currentPage);
        System.out.println(pageSize);
        System.out.println(grpSize);
        System.out.println(totRecords);

        System.out.println(totalPage);
        System.out.println(currentGrp);
        System.out.println(grpStartPage);
        System.out.println(grpEndPage);


        for(int i=grpStartPage; i<=grpEndPage; i++){
            System.out.print("["+ i + "]");
        }



    }

}
