<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Pageable(페이징적용)</h2>
	<ul>
		<li><a href=/selectByNameLike.do?name=test&page=1>Name Like 조회(1page)</a></li>
		<li><a href=/selectByNameLike.do?name=test&page=2>Name Like 조회(2page)</a></li>
		<li><a href=/selectByNameLike.do?name=test&page=3>Name Like 조회(3page)</a></li>
		<li><a href=/selectByNameLike.do?name=test&page=4>Name Like 조회(4page)</a></li>
	</ul>
</body>
</body>
</html>
