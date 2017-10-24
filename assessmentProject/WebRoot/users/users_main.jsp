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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Home</title>
<link href="assets/css/bootstrap.css" rel="stylesheet" />
<link href="assets/css/font-awesome.css" rel="stylesheet" />
<link href="assets/css/bootstrap-fileupload.min.css" rel="stylesheet" />
<link href="assets/css/basic.css" rel="stylesheet" />
<link href="assets/css/custom.css" rel="stylesheet" />
<script src="assets/js/jquery-1.10.2.js"></script>
<script src="assets/js/bootstrap.js"></script>
<script src="assets/js/bootstrap-fileupload.js"></script>
<script src="assets/js/jquery.metisMenu.js"></script>
<script src="assets/js/custom.js"></script>
<script src="users/users_main.js"></script>
</head>

<body>
<s:if
	test="#session.userDto==null">
	<script type="text/javascript">
		location.href = "login.jsp";
	</script>
</s:if> 
	<div id="wrapper">
		<div id="page-inner">
			<div class="row">
				<div class="col-md-12">
					<h1 class="page-head-line">用户信息管理</h1>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="panel panel-info">	
						<div class="panel-body">
							<form action="" id="form_query" method="post">
								<table height="100%" style="margin-top: -3px;" >
								<tr >
									<td valign="middle" style="padding: 10px 0 10px 10px;">姓名：</td>
									<td valign="middle" style="padding: 10px 10px 10px 0;"><input type="text" id="name"
										name="name" style="width: 100px; height: 30px; "/>
									</td>
									<td valign="middle" style="padding: 10px 0 10px 10px;">电话：</td>
									<td valign="middle" style="padding: 10px 10px 10px 0;"><input type="text" id="telephone"
										name="telephone" style="width: 150px; height: 30px;"/>
									</td>
									<td valign="middle" style="padding: 10px 0 10px 10px;">邮箱：</td>
									<td valign="middle" style="padding: 10px 10px 10px 0;"><input type="text" id="email"
										name="email" style="width: 150px; height: 30px; "/>
									</td>
									<td valign="middle" style="padding: 10px 0 10px 10px;">身份证号：</td>
									
									<td valign="middle" style="padding: 10px 10px 10px 0;"><input type="text" id="identificationCard"
										name="identificationCard" style="width: 200px; height: 30px; "/>
									</td>
									</tr><tr>
									<td valign="middle" style="padding: 10px 0 10px 10px;">性别：</td>
									<td valign="middle" style="padding: 10px 10px 10px 0;"><select id="sex" name="sex"
										style="width: 100px; height: 30px; padding: 4px 8px;">
											<option value="">全部</option>
											<option value="1">男</option>
											<option value="2">女</option>
									</select></td> 
									<td valign="middle" style="padding: 10px 0 10px 10px;">部门：</td>
									<td valign="middle" style="padding: 10px 10px 10px 0;"><select id="department"
										name="departmentId"
										style="width: 150px; height: 30px; padding: 4px 8px;">
									</select>
									
									<%-- <select  name="departmentName" id="department"
										>
											<option value="">全部</option>
											<option value="软件部"><s:property value="%{}"/></option>
											<option value="打印机">打印机</option>
											<option value="物联网">物联网</option>
											<option value="智能自助">智能自助</option>
											<option value="数据平台">数据平台</option>
									</select> --%></td> 
									<td valign="middle" style="padding: 10px 0 10px 10px;">职位：</td>
									<td valign="middle" style="padding: 10px 10px 10px 0;">
									<select id="duty" name="dutyId"
										style="width: 150px; height: 30px; padding: 4px 8px;">
									</select>
									</td> 
									<td valign="middle" width="150" align="center" colspan="2"><button
											id="act_query" class="btn btn-info">查询</button></td>
									
									</tr>								
							</table>
							</form>
						</div>
					</div>
				</div>
			</div>

			<!-- /. ROW  -->
			<div id="div_cnt_table"></div>		
		</div>
	</div>

</body>

</html>