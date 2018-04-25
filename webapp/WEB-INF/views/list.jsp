<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.javaex.vo.GuestbookVo"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록</title>
</head>
<body>
	<form action="/guestbook3/insert" method="post">
	<table border=1 width=500>
		<tr>
			<td>이름</td><td><input type="text" name="name" value=""></td>
			<td>비밀번호</td><td><input type="password" name="password" value=""></td>
		</tr>
		<tr>
			<td colspan=4><textarea name="content" cols=60 rows=5 value=""></textarea></td>
		</tr>
		<tr>
			<td colspan=4 align=right><input type="submit" VALUE=" 확인 " value=""></td>
		</tr>
	</table>
	</form>
	<br/>
	
	<!--URL 형태로 보낸거  -->
	
	 <%-- <c:forEach items="${list}" var="GuestbookVO">
	<table width=510 border=1>
		<tr>
			<td>${GuestbookVO.no}</td>
			<td>${GuestbookVO.name}</td>
			<td>${GuestbookVO.req_date}</td>
			<td><a href="/guestbook3/deleteform/${GuestbookVO.no}">삭제</a></td> 
		</tr>
		<tr>
			<td colspan=4>${GuestbookVO.content}</td>
		</tr>
	</table>
        <br/>
    </c:forEach> --%>
	
		<!--파라미터 형태 (Key-value)로 보낸거  -->

    <c:forEach items="${list}" var="GuestbookVO">
	<table width=510 border=1>
		<tr>
			<td>${GuestbookVO.no}</td>
			<td>${GuestbookVO.name}</td>
			<td>${GuestbookVO.req_date}</td>
			<td><a href="/guestbook3/deleteform?no=${GuestbookVO.no}">삭제</a></td> 
		</tr>
		<tr>
			<td colspan=4>${GuestbookVO.content}</td>
		</tr>
	</table>
        <br/>
    </c:forEach> 
    
</body>
</html>