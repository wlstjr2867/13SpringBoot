<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>fileUpload</title>
</head>
<body>
	<h2>파일업로드 성공</h2>
	업로드 한 파일명 : ${originalFileName } <br />
	저장된 파일명 : ${savedFileName } <br />
	<img src="./uploads/${savedFileName }"> <br />
	제목 : ${title } <br />
	카테고리 :
	<c:foreach items="${cate }" var="row" varStatus="status">
		${row }
		<c:if test="${status.last eq false }">,</c:if>
	</c:foreach>
</body>
</html>