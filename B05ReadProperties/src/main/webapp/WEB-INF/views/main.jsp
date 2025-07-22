<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- build.gradle에 JSP 사용을 위한 4개의 의존성을 통해 JSTL을 사용할
수 있다. taglib 지시어를 통해 설정한다. -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SpringBoot</title>
</head>
<body>
	<h2>스프링 부트 프로젝트</h2>
	<ul>
		<li><a href="/">루트</a></li>
		<li><a href="/link1">application.properties에서 가져오기</a></li>
		<li><a href="/link2">사용자 정의 properties파일에서 가져오기</a></li>
	</ul>
</body>
</html>