<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<head>
<base href="<%=basePath%>" />
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Home</title>
<link href="assets/css/bootstrap.css" rel="stylesheet" />
<link href="assets/css/font-awesome.css" rel="stylesheet" />
<link href="assets/css/basic.css" rel="stylesheet" />
<link href="assets/css/custom.css" rel="stylesheet" />
<script src="assets/js/jquery-1.10.2.js"></script>
<script src="assets/js/bootstrap.js"></script>
<script src="assets/js/jquery.metisMenu.js"></script>
<script src="assets/js/custom.js"></script>
</head>

<body>

	<div>
		<div class="navbar-default navbar-side" role="navigation">
			<div class="sidebar-collapse">
				<ul class="nav" id="main-menu">
					<li>
						<div class="user-img-div">
							<a href="users/systemuser_update.jsp" target="mainframe">
							<s:if test="#session.userDto.userImg!=null">
								<img
									src="userImages/<s:property value="#session.userDto.userImg"/>"
									alt="编辑"  onerror="this.onerror=null;this.src='assets/img/demoUpload.jpg'"
									 />
							</s:if>
							<s:else>
								<img src="assets/img/demoUpload.jpg" alt="编辑" />
							</s:else>
							</a>
							<div class="inner-text">
								<s:property value="#session.userDto.userName" />
								<br /> <small><s:property
										value="#session.userDto.telephone" /> </small>
							</div>
						</div>
					</li>

					<li><a href="#"><i class="fa fa-desktop "></i>用户信息管理<span
							class="fa arrow"></span> </a>
						<ul class="nav nav-second-level">
							<li><a href="users/users_main.jsp" target="mainframe"><i
									class="fa fa-toggle-on"></i>信息管理</a>
							</li>
							<li><a href="users/users_add.jsp" target="mainframe"><i
									class="fa fa-bell "></i>添加新用户</a></li>			
						</ul>
					</li>
					<li><a href="#"><i class="fa fa-yelp "></i>部门信息管理 <span
							class="fa arrow"></span> </a>
						<ul class="nav nav-second-level">
							<li><a href="department/department_main.jsp"
								target="mainframe"><i class="fa fa-key "></i>信息管理</a></li>
						</ul>
					</li>

					<li><a href="#"><i class="fa fa-dashboard "></i>职务信息管理 <span
							class="fa arrow"></span> </a>
						<ul class="nav nav-second-level">
							<li><a href="duty/duty_main.jsp" target="mainframe"><i
									class="fa fa-send  "></i>信息管理</a></li>
						</ul>
					</li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>