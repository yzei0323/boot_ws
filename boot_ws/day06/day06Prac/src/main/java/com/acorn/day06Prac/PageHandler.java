package com.acorn.day06Prac;

public class PageHandler {
    int currentPage;
    int pageSize;
    int grpSize;
    int totRecords;

    int totalPage;
    int currentGrp;
    int grpStartPage;
    int grpEndPage;

    public PageHandler(int currentPage, int grpSize, int totRecords, int pageSize) {
        this.currentPage = currentPage;
        this.grpSize = grpSize;
        this.totRecords = totRecords;
        this.pageSize = pageSize;

        pageCalc();
    }


    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotRecords() {
        return totRecords;
    }

    public void setTotRecords(int totRecords) {
        this.totRecords = totRecords;
    }

    public int getGrpSize() {
        return grpSize;
    }

    public void setGrpSize(int grpSize) {
        this.grpSize = grpSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getCurrentGrp() {
        return currentGrp;
    }

    public void setCurrentGrp(int currentGrp) {
        this.currentGrp = currentGrp;
    }

    public int getGrpEndPage() {
        return grpEndPage;
    }

    public void setGrpEndPage(int grpEndPage) {
        this.grpEndPage = grpEndPage;
    }

    public int getGrpStartPage() {
        return grpStartPage;
    }

    public void setGrpStartPage(int grpStartPage) {
        this.grpStartPage = grpStartPage;
    }

    private void pageCalc(){
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

    }

}
