<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>List Board</h1>

	<br>
	<div style="margin-left: 50px;">
		<table border="1" cellpadding="0" cellspacing="0">
			<tr height="30" class="tdSpace">
				<td width="100" colspan="5">게시판</td>
			</tr>
			<tr height="30" class="tdSpace">
				<td width="50">번호</td>
				<td width="250">제목</td>
				<td width="100">작성자</td>
				<td width="180">날자</td>
				<td width="50">조회수</td>
			</tr>

			<c:forEach var="list" items="${list }" varStatus="loop">
				<tr height="30" class="tdSpace">
					<td width="50">${list.b_num }</td>
					<td width="300"><a href="/board/ReadBoard?b_num=${list.b_num }">${list.b_title }</a></td>
					<td width="100">${list.m_id }</td>
					<td width="100"><fmt:formatDate value="${list.b_date }" type="both"/> </td>
					<td width="50">${list.b_count }</td>
				</tr>

			</c:forEach>
		</table>
	</div>
	
	<br>
	<br>
<a href="/board/insertBoard">글쓰기</a>




</body>
</html>