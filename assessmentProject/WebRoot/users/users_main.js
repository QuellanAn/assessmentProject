$(document).ready(function() {
	loaddepartments();
	loaddedutys(0);
	datalist_ctrl.loaddatalist("user/manager_getUserList?page=1");
	
	
	$("#department").change(function(e){
		var type=$("#department").val();
		loaddedutys(type);
	});
	$("#act_query").click(function(e) {
		var paras = $("#form_query").serialize();
		var url = "user/manager_getUserList?page=1&" + paras;
		datalist_ctrl.loaddatalist(url);
		return false;
	});
});
var datalist_ctrl = {
	loaddatalist : function(url) {
		var cnt = $('#div_cnt_table');

		$.get(url, function(data, status) {

			if (data && data.msg) {
				alert(data.msg);
			} else if (data) {
				cnt.empty();
				cnt.append(data);
			}
		});
	},
	topage : function(url) {
		this.loaddatalist(url);
	}
};


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

/**
 * 加载职位信息
 */
function loaddedutys(type){
	var url = "user/manager_getDutyList?type="+type;
	var dis = $('#duty');;
	dis.empty();
	dis.append("<option value=''>全部</option>");
	$.get(url , function(data, status){
		var jarr = eval(data);     
		for (var i in jarr){
			var o = $('<option></option>').val(jarr[i].dutyId).html(jarr[i].dutyName);
			dis.append(o.get());
		}
	});
}

/**
 * 删除指定的数据
 * @param 数据的id
 * @param 当前页数
 */
function deletehosinfo(e, p){
	if (confirm("你确认要删除该条记录吗？")){		
		$.post("user/manager_deleteUser",
				{selectNumber:e, page:p},
				function success(data,status){
					if (status = 'success'){
						alert(status);
						var cnt = $('#div_cnt_table');
						cnt.empty();
						cnt.append(data);
					}else{
						alert('删除失败！');									
					}
				});
		//datalist_ctrl.loaddatalist("employeesAction/getEmployeeList?page=1");
	}
}
