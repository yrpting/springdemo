<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%
    request.setAttribute("ctx", request.getContextPath());
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${ctx}/js/jquery-3.1.1.min.js"></script>
<title>Post编码</title>
</head>
<body>
	<script type="text/javascript">
		$(function() {
			$(window).on("unload", function(e) {
				$.ajax({
					url:'${ctx}/springdemo/destroySession',
					async:false
				});
				return "a";
			});
		});
		
	</script>
	<form action="postdemo" method="post">
		<input name="name" type="text"> <input name="sex" type="text" value="${str}">
		<input type="submit" value="提交">
		<input type="button" value="switch" onclick="change()">
	</form>
</body>
</html>