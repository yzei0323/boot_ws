package com.acorn.pageSample;

import lombok.Data;


public class PageHandler {

	 int  currentPage;           //현재페이지
	 int  totRecords ;           // 총 레코드 수
	 int  pageSize ;              //페이지 사이즈  (데이터 건수 , 한 페이지에 보이는 레코드 수 )
	 int  grpSize ;               // 한 그룹에 5깨씩 보겟다

	 int  totalPage;              // 총 페이지수: 전체 페이수
	 int  currentGrp ;  	      // 현재그룹
	 int  grpStartPage;           // 현재그룹의 시작번호
	 int  grpEndPage;             // 현재그룹의 마지막번호
	 
	 
	 
	    //현재페이지, 전체레코드수, 페이지사이즈 , 그룹사이즈
	public PageHandler(int currentPage, int totRecords , int pageSize , int grpSize) {
		this.currentPage= currentPage;
		this.totRecords= totRecords;
		this.pageSize = pageSize; 
		this.grpSize = grpSize;
		
		//페이징관련 값 구하기
		calcPage(); 
	}
	

	public int getCurrentPage() {
		return currentPage;
	}





	public int getTotRecords() {
		return totRecords;
	}




	public int getPageSize() {
		return pageSize;
	}



	public int getTotalPage() {
		return totalPage;
	}



	public int getGrpSize() {
		return grpSize;
	}




	public int getCurrentGrp() {
		return currentGrp;
	}




	public int getGrpStartPage() {
		return grpStartPage;
	}




	public int getGrpEndPage() {
		return grpEndPage;
	}



		/* 외부에서 호출되지 못하도록 한다 */
	private void calcPage(){
		 int reamin = totRecords  %  pageSize ;		 
		 //1. 총 페이지수 구하기
		 if( reamin ==0 )
			 totalPage = totRecords / pageSize;			 
		 else 
			 totalPage = totRecords / pageSize +1;		 
		 //2. 현재페이지에 대한  현재그룹 구하기
		 //3. 현재그룹의 시작번호
		 //4. 현재그룹의 끝번호
		 int remain2 = currentPage % grpSize;            	 
		 
		 if( remain2 ==0 )
			 currentGrp  = currentPage  / grpSize ;      	 
		 else 
			 currentGrp = currentPage  / grpSize  +1;    
		 
	  
		 
			 
		 grpStartPage = ( currentGrp -1 ) * grpSize +1 ;  // 그룹의 시작번호   현재그룹 1 => 1  , 현재그룹 2 -> 6
		 grpEndPage = currentGrp * grpSize;               // 그룹의 끝번호    1-> 5  , 2-> 10		 
		 


		 // 5. 현재그룹의 마지막번호 확인하기
		 //  현재그룹의 마지막번호가 마지막페이지보다 크다면
		 //그룹의 마지막번호가 마지막페이지로 변경해야됨
		 if( grpEndPage > totalPage){
			 grpEndPage = totalPage;                      // 그룹의 끝번호   10 -> 9로 변경 , 그룹의 끝번호가 마지막페이지번호 크다면
		 }
		 
		 
		 
		 
	}
	

}
