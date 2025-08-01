package com.edu.springboot;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	
	@RequestMapping("/")
	public String main() {
		return "main";
	}
	
	/*
	컨트롤러엣거 매핑을 위한 메서드에 @ResponseBody 어노테이션을 추가하면
	반환되는 값을 웹브라우저에 출력한다. 만약 이 어노테이션이 없다면 View의
	경로가 되므로 포워드된다.
	 */
	@RequestMapping("/json.do")
	@ResponseBody
	public String json() {
		/*
		외부 라이브러리인 simple-json을 통해 사용할 수 있는 클래스로
		JSON배열과 JSON객체를 만들어준다. 사용법은 List, Map 컬렉션과
		완전히 동일하다.
		 */
		//배열은 List와 동일함
		JSONArray arr = new JSONArray();
		//객체는 Map과 동일함
		JSONObject obj = new JSONObject();
		
		//배열에 데이터 추가 
		arr.add("손오공");
		arr.add("저팔계");
		arr.add("사오정");
		
		//객체에 데이터 추가
		obj.put("서유기", arr);
		obj.put("result", 1);
		
		//JSON을 String형식으로 웹브라우저에 출력한다.
		return obj.toJSONString();
	}
	
	@RequestMapping("/jsonQuiz.do")
	@ResponseBody
	public String jsonQuiz() {
		JSONObject objResult = new JSONObject();
		
		//취미
		JSONArray arr1 = new JSONArray();
		arr1.add("자전거");arr1.add("수영");arr1.add("축구");
		
		//중딩친구
		JSONArray arrMidFriend = new JSONArray();
		arrMidFriend.add("손오공");arrMidFriend.add("저팔계");
		arrMidFriend.add("사오정");

		//고딩친구
		JSONArray arrCircle = new JSONArray();
		arrCircle.add("유비");arrCircle.add("관우");
		arrCircle.add("장비");
		JSONArray arrClass = new JSONArray();
		arrClass.add("이몽룡");arrClass.add("성춘향");
		JSONObject objHighFriend = new JSONObject();
		objHighFriend.put("circle", arrCircle);
		objHighFriend.put("class", arrClass);
		
		//중딩,고딩통합
		JSONObject objFriend = new JSONObject();
		objFriend.put("mid", arrMidFriend);
		objFriend.put("high", objHighFriend);
		
		objResult.put("name", "홍길동");
		objResult.put("age", 99);
		objResult.put("hobby", arr1);
		objResult.put("friend", objFriend);
		return objResult.toJSONString();

	}
}

////		JSONArray arr = new JSONArray();
////		JSONObject obj = new JSONObject();
////		
////		obj.put("name", "홍길동");
////		obj.put("age", "99");
////		
////		arr.add("자전거");
////		arr.add("수영");
////		arr.add("축구");
////		obj.put("hobby", arr);
////		
////		arr2.add("손오공");
////		arr2.add("저팔계");
////		arr2.add("사오정");
////		obj.put("mid", arr2);
////		
////		arr3.add("유비");
////		arr3.add("관우");
////		arr3.add("장비");
////		obj.put("circle", arr3);
////		
////		arr4.add("이몽룡");
////		arr4.add("성춘향");
////		obj.put("class", arr4);
////		
//		
//		return obj.toJSONString();