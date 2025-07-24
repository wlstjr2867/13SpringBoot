package com.edu.springboot.jdbc;

import lombok.Data;

@Data
public class MemberDTO {
	//member 테이블의 컬럼과 1:1로 매칭된 멤버변수
	private String id;
	private String pass;
	private String name;
	private String regidate;
	//검색 관련 멤버변수 추가
	private String searchField;
	private String searchKeyword;
}
