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
<script type="text/javascript">

</script>
</head>

<body>
	<div id="wrapper">
		<div id="page-inner">
			<div class="row">
				<div class="col-md-12">
					<h1 class="page-head-line">用户详细信息</h1>
				</div>
			</div>
			<!-- /. ROW  -->
			<div class="row">
				<div class="col-md-4 ">
					<div class="panel panel-info">
						<!-- <div class="panel-heading"></div> -->
						<div class="panel-body">
							<form role="form">

								<div class="form-group">
									<label class="control-label col-lg-4">图像</label>
									<div class="">
										<div class="fileupload fileupload-new"
											data-provides="fileupload">
											<div class="fileupload-new thumbnail"
												style="width: 200px; height: 150px;">									
												<s:if test="#session.userDto.userImg!=null">
													<img src="userImages/<s:property value="manageDto.userImg"/>"
													alt="" onerror="this.onerror=null;this.src='assets/img/demoUpload.jpg'" /> 
												</s:if>
												<s:else>
													<img src="assets/img/demoUpload.jpg" alt="" />
												</s:else>											
											</div>
											
											
										</div>
									</div>
								</div>
								<input type="hidden" value="<s:property value="manageDto.userId"/>">
								

								<div class="form-group">
									<label>姓名：</label> <input class="form-control"
										type="text" readonly="readonly" value="<s:property value="manageDto.userName"/>">
								</div>
								<div class="form-group">
									<label>性别：</label> <input class="form-control"
										type="text" readonly="readonly" value="<s:property value="manageDto.userSex"/>">									
								</div>
								<div class="form-group">
									<label>年龄：</label> <input class="form-control"
										type="text" readonly="readonly" value="<s:property value="manageDto.userAge"/>">									
								</div>																
							</form>
						</div>
					</div>
				</div>
				<div class="col-md-8 ">
					<div class="panel panel-default">
						
						<div class="panel-body">
							<form role="form">	
								<div class="form-group">
									<label>邮箱</label> <input class="form-control"
										type="text" readonly="readonly" value="<s:property value="manageDto.email"/>">
									<!-- <p class="help-block">Help text here.</p> -->
								</div>
								<div class="form-group">
									<label>电话：</label> <input class="form-control"
										type="text" readonly="readonly" value="<s:property value="manageDto.telephone"/>">									
								</div>
																							
								<div class="form-group">
									<label>身份证：</label> <input class="form-control"
										type="text" readonly="readonly" value="<s:property value="manageDto.identificationCard"/>">									
								</div>
								<div class="form-group">
									<label>户籍：</label> <input class="form-control"
										type="text" readonly="readonly" value="<s:property value="manageDto.domicile"/>">									
								</div>
								<div class="form-group">
									<label>住址：</label> <input class="form-control"
										type="text" readonly="readonly" value="<s:property value="manageDto.address"/>">									
								</div>
								<div class="form-group">
									<label>部门：</label> <input class="form-control"
										type="text" readonly="readonly" value="<s:property value="manageDto.departmentName"/>">									
								</div>
								<div class="form-group">
									<label>职务：</label> <input class="form-control"
										type="text" readonly="readonly" value="<s:property value="manageDto.dutyName"/>">									
								</div>
								<div class="form-group">
									<label>薪资：</label> <input class="form-control"
										type="text" readonly="readonly"value="<s:property value="manageDto.dutySalary"/>">									
								</div>
								<button id="btn_edit"  class="btn btn-info" style="margin-left: 300px; margin-top: 20px;"><a style="text-decoration:none;" href="user/manager_updateViewUser?selectNumber=<s:property value="manageDto.userId"/>">&nbsp;&nbsp;编 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;辑&nbsp;&nbsp;</a></button>									
							
							</form>
						</div>
					</div>
				</div>
			</div>


		</div>
	</div>



</body>
</html>