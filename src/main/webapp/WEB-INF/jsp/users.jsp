<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    request.setAttribute("ctx", request.getContextPath());
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${ctx}/js/jquery-3.1.1.min.js"></script>
<title>用户列表</title>
</head>
<body>
<table>
	<thead>
		<tr><th>id</th><th>学号</th><th>姓名</th><th>性别</th></tr>
	</thead>
	<tbody>
		<c:forEach items="${listUsers}" var="user">
			<tr><td>${user.id}</td><td>${user.uid}</td><td>${user.name}</td><td><c:choose><c:when test="${user.sex eq 0}">男</c:when><c:otherwise>女</c:otherwise></c:choose></td></tr>		
		</c:forEach>
	</tbody>
</table>
</body>
</html>