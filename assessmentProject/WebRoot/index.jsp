<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理系统</title>
</head>
<s:if
	test="#session.userDto==null">
	<script type="text/javascript">
		location.href = "login.jsp";
	</script>
</s:if> 
<frameset rows="70,*" frameborder="no" framespacing="0">
	<frame src="top.jsp" name="topFrame" noresize="noresize" scrolling="no"/>
	<frameset cols="260,*">
	<frame src="users/menu.jsp" name="menulist"/>
	<frame src="users/users_main.jsp" name="mainframe"/>	
	
	</frameset>
	<noframes>
		<body>您的浏览器无法处理框架！
		</body>
	</noframes>
</frameset>
</html>