package com.edu.springboot.jpa;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> 
{
	/*
	반환타입을 List로 생성하면 엔티티에서 인출한 레코드만 반환한다.
	즉 해당 페이지에 출력할 ResultSet만 가져오게된다.
	 */
//	List<member> findByNameLike(String keyword, Pageable pageable);
	
	/*
	반환타입을 Page로 설정하면 인출된 ResultSet을 포함하여, 페이지에 관련된
	다양한 정보를 추가로 반환한다. 총페이지수, 레코드갯수 등이 포함된다.
	 */
	Page<Member> findByNameLike(String keyword, Pageable pageable);
}
