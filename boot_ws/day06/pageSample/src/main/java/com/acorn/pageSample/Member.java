package com.acorn.pageSample;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Member {

	String m_id;
	String m_pw;
	String m_name;
	String m_tel;
	String m_birthday;
	int m_point;
	String m_grade;



}
