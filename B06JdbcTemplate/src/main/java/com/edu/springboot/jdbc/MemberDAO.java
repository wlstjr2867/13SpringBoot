package com.edu.springboot.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Repository;

/*
스프링 컨테이너가 시작될때 자동으로 Scan되어 빈을 생성한다.
즉 @Controller, @Service, @Repository 모두 유사한 역할을 한다.
 */
@Repository
public class MemberDAO implements IMemberService {
	
	/*
	JDBC 작업을 위해 자동주입받는다. JdbcTemplate 빈은 개발자가 직접
	설정하지않고, build.gradle에 의존성추가가 되어있으면 스프링 컨테이너가
	자동으로 빈을 생성해준다.
	 */
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//회원목록
	@Override
	public List<MemberDTO> select() {
		//회원 레코드를 가입일을 내림차순 정렬해서 인출하는 쿼리문
		String sql = "select * from member order by regidate desc";
		
		/*
		query() 메서드를 통해 select쿼리문을 시행한다. 쿼리문 실행후
		반환되는 ResultSet은 RowMapper가 자동으로 반복하여 DTO에 저장한 후
		이를 List에 추가해서 반환해준다.
		즉 레코드를 List에 저장하기 위한 반복적인 작업을 자동으로 수행해준다.
		 */
		return jdbcTemplate.query(sql, 
			new BeanPropertyRowMapper<MemberDTO>(MemberDTO.class));
	}

	@Override
	public int insert(MemberDTO memberDTO) {
		/*
		insert, update, delete와 같이 행의 변화가 있는 쿼리문 실행시에는
		update() 메서드를 실행한다. 실행 후 적용된 행의 갯수가 int형으로
		반환된다.
		 */
		int result = jdbcTemplate.update(new PreparedStatementCreator() {
			/*
			PreparedStatementCreator 인터페이스로 익명클래스를 생성한 후 
			오버라이딩 된 메서드내에서 인파라미터가 있는 insert쿼리문을 실행한다.
			결과는 정수형으로 반환된다.
			 */
			@Override
			public PreparedStatement createPreparedStatement(Connection con) 
					throws SQLException {
				//인파라미터가 있는 쿼리문 작성
				String sql = "insert into member (id, pass, name) "
						+ " values (?, ?, ?)";
				//인파라미터 세팅 후 쿼리문 실행
				PreparedStatement psmt = con.prepareStatement(sql);
				
				psmt.setString(1, memberDTO.getId());
				psmt.setString(2, memberDTO.getPass());
				psmt.setString(3, memberDTO.getName());
				
				return psmt;
			}
		});
		//insert 쿼리문 실행 후 결과를 컨트롤러로 반환한다.
		return result;
	}

	@Override
	public MemberDTO selectOne(MemberDTO memberDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(MemberDTO memberDTO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(MemberDTO memberDTO) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
