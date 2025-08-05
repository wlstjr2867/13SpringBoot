package com.edu.springboot.jpaboard;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
	/*
	게시판은 최근 게시물이 항상 위로 출력되야 하므로 내림차순 정렬이 기본이다.
	따라서 아래와 같이 Sort객체를 사용해서 정렬한 상태로 인출한다.
	 */
	List<BoardEntity> findAll(Sort sort);

}
