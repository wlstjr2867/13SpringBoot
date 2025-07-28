<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스프링 부트 프로젝트</title>
<!-- 정적 리소스인 js와 css파일을 링크를 걸어서 사용 -->
<script src="./js/commons.js"></script>
<link rel="stylesheet" href="./css/main.css" />
</head>
<body>
	<h2>스프링 부트 프로젝트</h2>
	<ul>
		<li><a href="/" >루트</a>	</li>
	</ul>
	
	<script>
		window.onload = function(){
			myConsole("시큐리티");
		}
	</script>
	
	<h2>Spring Security 기본</h2>
	<ul>
		<li><a href="/guest/index.do" >Guest</a></li>
		<li><a href="/member/index.do" >Member</a></li>
		<li><a href="/admin/index.do" >Admin</a></li>
	</ul>
	
	<div class="spring" onclick="myAlert();">
		여기를 클릭해보세요.
	</div>
</body>
</html>