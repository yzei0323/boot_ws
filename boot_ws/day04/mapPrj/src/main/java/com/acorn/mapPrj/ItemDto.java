package com.acorn.mapPrj;



public class ItemDto {

	String id;
	String pw;
	
	public ItemDto() {
		// TODO Auto-generated constructor stub
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}


	public ItemDto(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}
	
	
	
}
