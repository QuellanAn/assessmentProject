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
<script src="assets/js/jquery.form.min.js"></script>
<script type="text/javascript">
 $(document).ready(function() {
 
 var formData=new FormData();

		$("#btn1").click(function(e) {
			/* var paras = $("#form_query").serialize();
			var url = "user/systemUserUpdate?" + paras; */
			
			 $("#form_query").ajaxSubmit({
              url: "systemUser/systemUser_systemUserUpdate",
              type: "post",
              enctype: 'multipart/form-data',
              dataType:'json',
              success: function (data){                     	
              },
              error: function (data)
              {
                top.location="index.jsp";
              }
            });
			
			
			/* $.post(url, function(data, status) {
				if (status = 'success') {
					alert(status);
					top.location="index.jsp";
					//location.reload([true]);
				} else {
					alert('');
				}
			}); */
			return false;
		});

	});
</script>
</head>

<body>
	<div id="wrapper">
		<div id="page-inner">
			<div class="row">
				<div class="col-md-12">
					<h1 class="page-head-line">系统用户信息</h1>
				</div>
			</div>
			<!-- /. ROW  -->
			<form method="post" action="" enctype="multipart/form-data"
				id="form_query">
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
												
												<s:if test="#session.userDto.userImg!=null">
													<img src="userImages/<s:property value="#session.userDto.userImg"/>"
													alt="" onerror="this.onerror=null;this.src='assets/img/demoUpload.jpg'" /> 
												</s:if>
												<s:else>
													<img src="assets/img/demoUpload.jpg" alt="" />
												</s:else>
													<input type="hidden" name="backupImg"
													value="<s:property value="#session.userDto.userImg"/>">
											</div>
											<div class="fileupload-preview fileupload-exists thumbnail"
												style="max-width: 250px; max-height: 200px; line-height: 20px;"></div>
											<div>
												<span class="btn btn-file btn-primary"><span
													class="fileupload-new">上传</span><span
													class="fileupload-exists">修改</span><input type="file"
													name="file" id="fileName"> </span> <a href="#"
													class="btn btn-danger fileupload-exists"
													data-dismiss="fileupload">移除</a>
											</div>
										</div>
									</div>
								</div>



							</div>
						</div>
					</div>

					<div class="col-md-6 ">
						<div class="panel panel-info">
							<!-- <div class="panel-heading"></div> -->

							<div class="panel-body">
								<div class="form-group">
									<label>姓名：</label> <input class="form-control" type="text"
										name="name" id="name"
										value="<s:property value="#session.userDto.userName"/>">
									<input type="hidden" name="systemuserid"
										value="<s:property value="#session.userDto.userId"/>">
								</div>
								<div class="form-group">
									<label>密码：</label> <input class="form-control" type="password"
										name="password" id="password"
										value="<s:property value="#session.userDto.password"/>">
								</div>

								<div class="form-group">
									<label>邮箱</label> <input class="form-control" type="text"
										id="email" name="email"
										value="<s:property value="#session.userDto.email"/>">
									<!-- <p class="help-block">Help text here.</p> -->
								</div>
								<div class="form-group">
									<label>电话：</label> <input class="form-control" type="text"
										id="telephone" name="telephone"
										value="<s:property value="#session.userDto.telephone"/>">
								</div>
								<button id="btn1" class="btn btn-info"
									style="margin-left: 50px; margin-top: 40px;margin-bottom: 30px;">&nbsp;&nbsp;提&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;交&nbsp;&nbsp;</button>

							</div>
						</div>
					</div>

				</div>
			</form>

		</div>
	</div>

</body>
</html>