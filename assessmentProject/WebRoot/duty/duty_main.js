$(document).ready(function() {
	
	loaddepartments();
	loaddepartments1();
	datalist_ctrl.loaddatalist("duty/duty_getDuty?page=1");
	
	$("#act_query").click(function(e) {
		var paras = $("#form_query").serialize();
		var url = "duty/duty_getDuty?page=1&" + paras;
		datalist_ctrl.loaddatalist(url);
		return false;
	});
	
	$("#submitForm1").click(function(e) {
		var salary=$("dutySalary1").val();
		//alert(salary);
		if(salsry.match(/^(([0-9]+\\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\\.[0-9]+)|([0-9]*[1-9][0-9]*))$/)){
		alert("请输入正确的薪资");
		return false;
		}
		
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
 * 删除指定的数据
 * @param 数据的id
 * @param 当前页数
 */
function deletehosinfo(e, p){
	if (confirm("你确认要删除该条记录吗？")){		
		$.post("duty/duty_deleteDuty",
				{selectNumber:e, page:p},
				function success(data,status){
					data = eval('(' + data + ')');					
					if (data.result == '0'){
						alert("删除成功");
						datalist_ctrl.loaddatalist("duty/duty_getDuty?page="+p);
					}
					if(data.result == '1'){
						alert('删除失败,请先删除对应的员工信息！');	
						datalist_ctrl.loaddatalist("duty/duty_getDuty?page="+p);
					}
				});
	}
}
/**
 * 加载部门信息
 */
function loaddepartments(){
	var url = "user/manager_getDepartmentList";
	var dis = $('#department');
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

function loaddepartments1(){
	var url = "user/manager_getDepartmentList";
	var dis1 = $('#department1');
	dis1.empty();
	/*dis1.append("<option value=''>全部</option>");*/
	$.get(url , function(data, status){
		var jarr = eval(data);     
		for (var i in jarr){
			var o = $('<option></option>').val(jarr[i].departmentId).html(jarr[i].departmentName);		
			dis1.append(o.get());
		}
	});
}


