<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.tdSpace td input {
	margin-left: 3px;
	margin-right: 3px;
}
</style>
</head>
<body>

	<h1>게시판 작성</h1>

	<br>
	<form action="insertBoard" method="post">
		<div style="margin-left: 50px;">
			<table border="1" cellpadding="0" cellspacing="0">
				<tr height="30" class="tdSpace">
					<td width="100">제목</td>
					<td width="300"><input type="text" size="40" name="b_title">
					<td width="100">작성자</td>
					<td width="170"><input type="text" size="20" name="m_id">
				</tr>
				<tr height="30" class="tdSpace">
					<td colspan="4">내용</td>

				</tr>	
				<tr height="30" class="tdSpace">

					<td colspan="4"><textarea rows="20" cols="85" name="b_content"
							style="width: 99%;"></textarea></td>
				</tr>	
				<tr height="30" class="tdSpace">
					<td colspan="4"><input type="submit" value="글쓰기"> <input
						type="button" value="취소"></td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>