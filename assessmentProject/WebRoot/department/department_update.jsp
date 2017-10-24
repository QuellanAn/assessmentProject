<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
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
<script type="text/javascript">
	/* $(document).ready(function() {
		$("#btn1").click(function(e) {
			var paras = $("#form_query").serialize();
			var url = "user/systemUserUpdate?1=1&" + paras;
			$.get(url, function(data, status) {
				if (status = 'success') {
					alert(status);
					location.reload([true]);
				} else {
					alert('删除失败！');
				}
			});
			return false;
		});

	}); */
</script>
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
					<h1 class="page-head-line">修改部门信息</h1>
				</div>
			</div>
			<!-- /. ROW  -->
			<form method="post" action="department/department_departmentUpdate" id="form_query">
				<div class="row">
					<div class="col-md-6 ">
						<div class="panel panel-info">
							<div class="panel-body">								
								<div style="margin-top: 40px;">
									<div class="form-group">
										<label>部门名称：</label> <input class="form-control" type="text"
											name="departmentName" id="departmentName" value="<s:property value="departmentDto.departmentName"/>">
									</div>
									<input type="hidden" name="departmentId" value="<s:property value="departmentDto.departmentId"/>">
									
									<div class="form-group">
										<label>部门人数：</label> <input class="form-control" type="text"
											name="departmentCount" id="departmentCount" value="<s:property value="departmentDto.departmentCount"/>" readonly="readonly">
									</div>
									<input type="submit" class="btn btn-info" value="提 交 "
										id="submitForm"
										style="width: 100px; margin-top: 50px;margin-bottom: 40px;margin-left: 80px;">

								</div>
							</div>
						</div>
					</div>

				</div>
			</form>

		</div>
	</div>

</body>
</html>