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
<script src="department/department_main.js"></script>
</head>

<body>
	<s:if test="#session.userDto==null">
		<script type="text/javascript">
			location.href = "login.jsp";
		</script>
	</s:if>
	<div id="wrapper">
		<div id="page-inner">
			<div class="row">
				<div class="col-md-12">
					<h1 class="page-head-line">部门信息管理</h1>
				</div>
			</div>
			<div class="row">
				<div class="col-md-8">
					<div class="panel panel-info">
						<div class="panel-body">
							<form action="" id="form_query" method="post">
								<table height="100%" style="margin-top: -3px;">
									<tr>
										<td valign="middle" style="padding: 10px 0 10px 10px;">部门：</td>
										<td valign="middle" style="padding: 10px 10px 10px 0;"><input
											type="text" id="msg" name="msg"
											style="width: 200px; height: 30px;" /></td>
										<td valign="middle" align="right" style="padding: 10px 0 10px 30px;"><button id="act_query"
												class="btn btn-info">查&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;询</button>
										</td>
									</tr>
								</table>
							</form>
						</div>
					</div>

					<div id="div_cnt_table"></div>
				</div>

				<div class="col-md-4">
					<div class="panel panel-info">
						<div class="panel-body">
							<div class="col-md-12">
								<h1 class="page-head-line">添加部门信息</h1>
							</div>
							<div style="margin-top: 120px;">
								<form action="department/department_addDepartment" id="form_add"
									method="post">

									<div class="form-group">
										<label>部门名称：</label> <input class="form-control" type="text"
											name="departmentName" id="departmentName">
									</div>
									<div class="form-group">
										<label>部门人数：</label> <input class="form-control" type="text"
											name="departmentCount" id="departmentCount" value="0"
											readonly="readonly">
									</div>
									<input type="submit" class="btn btn-info" value="提 交 "
										id="submitForm"
										style="width: 100px; margin-top: 50px;margin-bottom: 40px;margin-left: 80px;">
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>

			<!-- /. ROW  -->

		</div>
	</div>

</body>

</html>