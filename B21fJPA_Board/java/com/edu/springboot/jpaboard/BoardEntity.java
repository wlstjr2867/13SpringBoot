package com.edu.springboot.jpaboard;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.SequenceGenerator;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//게시판 테이블 생성
@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Entity(name="jpaboard")
public class BoardEntity {
	//PK컬럼, 시퀀스 설정
	@Id
	@SequenceGenerator(
			name = "mySequence",
			sequenceName = "jpaboard_seq",
			initialValue = 1,
			allocationSize = 1
	)
	@GeneratedValue (generator = "mySequence")
	private Long idx; //일련번호
	private String name; //이름
	private String title; //제목
	private String contents; //내용
	private Long hits; //조회수
	@Column(columnDefinition = "DATE DEFAULT SYSDATE")
	private LocalDateTime postdate; // 작성일
	/*
	 * @PrePersist
	 :엔티티가 저장(insert)되기전에 실행되는 콜백 메서드를
	 	정의할때 사용하는 어노테이션으로, 엔티티가 처음 저장될 때 필요한 작업을
	 	수행하는데 사용된다.
	 	만약 저장후에 실행하고 싶다면 @PostPersist를 사용하면된다.
	 */
	@PrePersist
	protected void onPrePersist() {
		//작성일 : 현재시작으로 설정
		this.postdate = LocalDateTime.now();
		//조회수 : 0으로 설정
		if(this.hits == null) {
			this.hits = 0L;
		}
	}
}
