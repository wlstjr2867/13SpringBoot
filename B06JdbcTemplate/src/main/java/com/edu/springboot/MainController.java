package com.edu.springboot;

import java.lang.reflect.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.edu.springboot.jdbc.IMemberService;
import com.edu.springboot.jdbc.MemberDTO;


@Controller
public class MainController {

    private final B06JdbcTemplateApplication b06JdbcTemplateApplication;

    MainController(B06JdbcTemplateApplication b06JdbcTemplateApplication) {
        this.b06JdbcTemplateApplication = b06JdbcTemplateApplication;
    }
	
	@RequestMapping("/")
	public String main() {
		return "main";
	}
	
	/*
	Service역할의 인터페이스의 빈을 자동주입 받는다. 이를통해
	DAO의 메서드를 호출할 수 있다 
	*/
	@Autowired
	IMemberService dao;
	
	//회원목록
	@RequestMapping("/list.do")
	public String member2(Model model) {
		//DAO select()메서드 호출 후 반환되는 List<MemberDTO>를 영역에 저장한다.
		model.addAttribute("memberList", dao.select());
		return "list";
	}
	
	/*
	@RequestMapping 어노테이션을 통해 매핑할때 아래와 같이 value, method속성을
	추가해서 요청명과 전송방식을 설정할 수 있다. 하지만 Spring boot 3.x 에서는
	매핑시 @GetMapping, @PostMapping 의 사용을 권고하고 있다. 
	 */
	
	//회원등록 페이지 매핑
//	@RequestMapping(value="/regist.do", method=RequestMethod.GET)
	@GetMapping("/regist.do")
	public String member1() {
		return "regist";
	}
	
	//회원 등록 처리
//	@RequestMapping(value="regist.do", method=RequestMethod.POST)
	@PostMapping("/regist.do")
	public String member6(MemberDTO memberDTO) {
		// 입력한 폼값을 한번에 받은 후 DAO를 호출
		int result = dao.insert(memberDTO);
		// 반환값을 통해 성공/실패 판단 가능
		if(result==1) System.out.println("입력되었습니다.");
		/*
		컨트롤러에서 String을 반환하면 View의 경로로 포워드 되지만,
		redirect: 를 사용하면 설정한 요청명으로 이동한다.
		 */
		return "redirect:list.do";
	}
}
