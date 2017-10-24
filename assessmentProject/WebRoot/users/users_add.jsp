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
<script src="assets/js/city.js"></script>
<script src="users/users_add.js"></script>

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
					<h1 class="page-head-line">用户详细信息</h1>
				</div>
			</div>
			<!-- /. ROW  -->
			<form id="" method="post" action="user/operate_addUser" enctype="multipart/form-data">
				<div class="row">
					<div class="col-md-4 ">
						<div class="panel panel-info">
							<!-- <div class="panel-heading"></div> -->
							<div class="panel-body">


								<div class="form-group" style="margin-left: 10px;">
									<label class="control-label col-lg-4">图像</label>
									<div class="">
										<div class="fileupload fileupload-new"
											data-provides="fileupload">
											<div class="fileupload-new thumbnail"
												style="width: 250px; height: 200px;">
												<img src="assets/img/demoUpload.jpg" alt="" />
											</div>
											<div class="fileupload-preview fileupload-exists thumbnail"
												style="max-width: 250px; max-height: 200px; line-height: 20px;"></div>
											<div>
												<span class="btn btn-file btn-primary"><span
													class="fileupload-new">上传</span><span
													class="fileupload-exists">修改</span><input type="file" name="file">
												</span> <a href="#"  class="btn btn-danger fileupload-exists"
													data-dismiss="fileupload">移除</a>
											</div>
										</div>
									</div>
								</div>
								<s:property value="manageDto.userName" />

								<div class="form-group">
									<label>姓名：</label> <input class="form-control" type="text"
										name="name" id="name">
								</div>
								<div class="form-group">
									<label>密码：</label> <input class="form-control" type="password"
										name="password" id="password"
										>
								</div>


							</div>
						</div>
					</div>

					<div class="col-md-4 ">
						<div class="panel panel-info">
							<!-- <div class="panel-heading"></div> -->
							<div class="panel-body">


								<div class="form-group">
									<label>邮箱</label> <input class="form-control" type="text"
										name="email" id="email">
									<!-- <p class="help-block">Help text here.</p> -->
								</div>
								<div class="form-group">
									<label>电话：</label> <input class="form-control" type="text"
											name="telephone" id="telephone" >
								</div>

								<div class="form-group">
									<label>身份证：</label> <input class="form-control" type="text"
										name="identificationCard" id="identificationCard">
								</div>
								<div class="form-group">
									<label>户籍：</label> <input class="form-control" type="text"
										readonly="readonly" id="domicile">
								</div>

								<div class="form-group">
									<label>性别：</label> <input class="form-control" type="text"
										readonly="readonly" id="sex">
								</div>
								<div class="form-group">
									<label>年龄：</label> <input class="form-control" type="text"
										readonly="readonly" id="age">
								</div>


							</div>
						</div>
					</div>


					<div class="col-md-4 ">
						<div class="panel panel-default">

							<div class="panel-body">


								<div class="form-group">
									<label>现居住址：</label> <select id="province" onchange="getCity()"
										name="address1" class="form-control"
										style="width: 200px; height: 30px; padding: 4px 8px;">
										<option value="">请选择</option>
										<option value=0>北京</option>
										<option value=1>上海</option>
										<option value=2>天津</option>
										<option value=3>重庆</option>
										<option value=4>河北</option>
										<option value=5>山西</option>
										<option value=6>内蒙古</option>
										<option value=7>辽宁</option>
										<option value=8>吉林</option>
										<option value=9>黑龙江</option>
										<option value=10>江苏</option>
										<option value=11>浙江</option>
										<option value=12>安徽</option>
										<option value=13>福建</option>
										<option value=14>江西</option>
										<option value=15>山东</option>
										<option value=16>河南</option>
										<option value=17>湖北</option>
										<option value=18>湖南</option>
										<option value=19>广东</option>
										<option value=20>广西</option>
										<option value=21>海南</option>
										<option value=22>四川</option>
										<option value=23>贵州</option>
										<option value=24>云南</option>
										<option value=25>西藏</option>
										<option value=26>陕西</option>
										<option value=27>甘肃</option>
										<option value=28>宁夏</option>
										<option value=29>青海</option>
										<option value=30>新疆</option>
										<option value=31>香港</option>
										<option value=32>澳门</option>
										<option value=33>台湾</option>
									</select> <select id="city" name="address2"
										style=" margin-top: 5px; width: 200px; height: 30px; padding: 4px 8px;"
										class="form-control">
									</select> <input class="form-control" style="margin-top: 5px;"
										id="address3" name="address3" type="text"
										value="<s:property value="manageDto.address"/>">
								</div>
								<div class="form-group">
									<label>部门：</label> <select id="department" name="departmentId"
										style="width: 200px; height: 30px; padding: 4px 8px;"
										class="form-control">
									</select>
								</div>
								<div class="form-group">
									<label>职务：</label> <select id="duty" name="dutyId"
										style="width: 200px; height: 30px; padding: 4px 8px;"
										class="form-control">
									</select>
								</div>
								<div class="form-group">
									<label>薪资：</label> <input class="form-control" type="text"
										readonly="readonly" id="salary" >
								</div>
								
								<input type="submit" class="btn btn-info" value="提 交 " id="submitForm" 
								style="width: 100px; margin-top: 40px;margin-bottom: 30px;">

							</div>
						</div>
					</div>
				</div>
			</form>

		</div>
	</div>

</body>
</html>