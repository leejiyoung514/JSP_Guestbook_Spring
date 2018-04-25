<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.javaex.vo.GuestbookVo"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>삭제페이지</title>
</head>
<body>

<%--  <form  action="/guestbook3/delete" method="post">
	<table>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="password"></td>
			<td><input type="text" name="no" value="${no}"></td>  <!--requestScope.no, requestAttribute영역에 no라고 담겨있음   -->
			<td><input type="submit" value="삭제"></td>
			<td><a href="/guestbook3/list">목록으로 돌아가기</a></td>
		</tr>
	</table>
	</form>  --%>

 <form  action="/guestbook3/delete" method="post">
	<table>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="password"></td>
			<td><input type="text" name="no" value="${param.no}"></td>
			<td><input type="submit" value="삭제"></td>
			<td><a href="/guestbook3/list">목록으로 돌아가기</a></td>
		</tr>
	</table>
	</form> 
</body>
</html>