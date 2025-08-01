package com.edu.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edu.springboot.jdbc.AddMember;
import com.edu.springboot.jdbc.ITicketService;
import com.edu.springboot.jdbc.PayDTO;
import com.edu.springboot.jdbc.TicketDTO;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MainController {
	
	@Autowired
	ITicketService dao;
	
	@Autowired
	TransactionTemplate transactionTemplate;
	
	/*
	추가작업 클래스 : 회원테이블에 구매한 회원의 이력을 입력한다.
		정의시 @Service 어노테이션을 부착한 상태이므로 
		자동주입이 가능하다. */
	@Autowired
	AddMember addMember;
	
	@RequestMapping("/")
	public String main() {
		return "main";
	}
	
	//티켓 구매 페이지
	@GetMapping("/buyTicket.do")
	public String buy1() {
		return "buy";
	}
	

	@PostMapping("/buyTicket.do")
	public String buy2(TicketDTO ticketDTO, PayDTO payDTO,
			HttpServletRequest req, Model model) {
		String viewPath = "success";
		try {
			
			transactionTemplate.execute(new TransactionCallbackWithoutResult() {
				
				@Override
				protected void doInTransactionWithoutResult(TransactionStatus status) {
					
					
					// 1. 회원 정보 입력(추가작업. 클래스 외부에서 처리되는 부분)
					String errFlag = req.getParameter("err_flag");					
					addMember.memberInsert(ticketDTO, errFlag);
					
					// 2. 구매금액입력(DB처리1) - 내부처리
					payDTO.setAmount(ticketDTO.getT_count() * 10000);
					int result1 = dao.payInsert(payDTO);
					if(result1==1) System.out.println("transaction_pay 입력성공");
					
					//3. 비지니스로직 처리(의도적인 에러발생 지점)
					if(errFlag!=null && errFlag.equals("1")) {
						int money = Integer.parseInt("100원");
					}
					
					
					//4. 티켓 매수 입력 (DB처리2) - 내부처리
					int result2 = dao.ticketInsert(ticketDTO);
					if(result2==1) System.out.println("transaction_ticket 입력성공");
					
					model.addAttribute("ticketDTO", ticketDTO);
					model.addAttribute("payDTO", payDTO);
					
				}
			});

		}
		catch (Exception e) {
//			e.printStackTrace();
			System.out.println("transaction 테이블 Rollback됨");
			viewPath = "error";
		}
		return viewPath;
	}

}























