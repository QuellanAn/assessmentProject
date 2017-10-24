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
<script src="duty/duty_main.js"></script>
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
					<h1 class="page-head-line">职务信息管理</h1>
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
										<td valign="middle" style="padding: 10px 10px 10px 0;"><select id="department"
										name="dutyDto.departmentId"
										style="width: 150px; height: 30px; padding: 4px 8px;">
									</select>
									
										<td valign="middle" align="center" style="padding-left: 60px;"><button
												id="act_query" class="btn btn-info">查&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;询</button>
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
								<h1 class="page-head-line">添加职务信息</h1>
							</div>
							<div style="margin-top: 120px;">
							<form action="duty/duty_addDuty" id="form_add" method="post">
								
								<div class="form-group">
									<label>部门：</label> <select id="department1" name="dutyDto.departmentId"
										style="width: 200px; height: 30px; padding: 4px 8px;"
										class="form-control">
									</select>
								</div>																
								<div class="form-group" >
									<label>职务名称：</label> <input class="form-control" type="text"
										name="dutyDto.dutyName" id="dutyName" value="<s:property value="dutyName"/>">								
								</div>
								<div class="form-group">
									<label>薪资：</label> <input class="form-control" type="text"
										name="dutyDto.dutySalary" id="dutySalary1">
								</div>								
								<input type="submit" class="btn btn-info" value="提 交 " id="submitForm1" 
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