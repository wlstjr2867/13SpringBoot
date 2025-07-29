package com.edu.springboot.restboard;

import lombok.Data;

@Data
public class BoardDTO {
	private String num;
	private String title;
	private String content;
	private String id;
	private java.sql.Date postdate;
	private String visitcount;
}
