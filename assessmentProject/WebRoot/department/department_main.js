$(document).ready(function() {
	datalist_ctrl.loaddatalist("department/department_getDepartment?page=1");
	
	$("#act_query").click(function(e) {
		var paras = $("#form_query").serialize();
		var url = "department/department_getDepartment?page=1&" + paras;
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
 * 删除指定的数据
 * @param 数据的id
 * @param 当前页数
 */
function deletehosinfo(e, p){
	if (confirm("你确认要删除该条记录吗？")){		
		$.post("department/department_deleteDepartment",
				{selectNumber:e, page:p},
				function success(data,status){
					data = eval('(' + data + ')');					
					if (data.result == '0'){
						alert("删除成功");
						datalist_ctrl.loaddatalist("department/department_getDepartment?page="+p);
					}
					if(data.result == '1'){
						alert('删除失败,请先删除对应的职务和员工信息！');	
						datalist_ctrl.loaddatalist("department/department_getDepartment?page="+p);
					}
				});
	}
}
