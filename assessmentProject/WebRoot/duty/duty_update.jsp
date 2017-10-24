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
	
$(document).ready(function() {
	firstloaddepartments($("#firstDepartment").val());
	
	
/**
 * 加载部门信息
 */
function loaddepartments(){
	var url = "user/manager_getDepartmentList";
	var dis = $('#department');;
	dis.empty();
	dis.append("<option value=''>全部</option>");
	$.get(url , function(data, status){
		var jarr = eval(data);     
		for (var i in jarr){
			var o = $('<option></option>').val(jarr[i].departmentId).html(jarr[i].departmentName);
			dis.append(o.get());
		}
	});
}


function firstloaddepartments(type){
	var url = "user/manager_getDepartmentListFirst?departmentId="+type;
	var dis = $('#department');;
	dis.empty();	
	$.get(url , function(data, status){
		var jarr = eval(data);     
		for (var i in jarr){
			var o = $('<option></option>').val(jarr[i].departmentId).html(jarr[i].departmentName);
			dis.append(o.get());
		}
	});
}
		
});
	
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
					<h1 class="page-head-line">修改职务信息</h1>
				</div>
			</div>
			<!-- /. ROW  -->
			<form method="post" action="duty/duty_dutyUpdate" id="form_query">
				<div class="row">
					<div class="col-md-6 ">
						<div class="panel panel-info">
							<div class="panel-body">
								<div style="margin-top: 40px;">
									<div class="form-group">
										<label>部门：</label> <select id="department" name="dutyDto.departmentId"
											style="width: 150px; height: 30px; padding: 4px 8px;"
											class="form-control">
											<option value="<s:property value="manageDto.departmentId"/>">
												<s:property value="manageDto.departmentName" />
											</option>
										</select> <input type="hidden" id="firstDepartment"
											value="<s:property value="manageDto.departmentId" />">
									</div>
									<div class="form-group">
									<input type="hidden" name="dutyDto.dutyId" value="<s:property value="manageDto.dutyId" />">	
										<label>职务名称：</label> <input class="form-control" type="text"
											name="dutyDto.dutyName" id="dutyName"
											value="<s:property value="manageDto.dutyName"/>">
									</div>
									<div class="form-group">
										<label>薪资：</label> <input class="form-control" type="text"
											name="dutyDto.dutySalary" id="dutySalary"
											value="<s:property value="manageDto.dutySalary"/>">
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