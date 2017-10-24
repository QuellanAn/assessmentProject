$(document).ready(function() {
	
	
	firstloaddepartments($("#firstDepartment").val());
	$("#department").change(function(e){
		var type=$("#department").val();
		loaddedutys(type);
	});
	
	$("#duty").change(function(e){
		var type=$("#duty").val();
		loaddeSalary(type);
	});
	

	$("#province").change(function(e){
		var type=$("#address3").val();
		$("#address3").val("");
	});
	
	var flag1=false;
	var flag2=false;
	var flag3=false;
	var email,telephone,identificationCard;
	
	$("#email").blur(function(){		
		email=$('#email').val();
		if($.trim(email).length==0){
			//alert('邮箱不能为空!'); 
			flag1=false;
			return false;
		}else if(!email.match(/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/)){ 
			//alert("邮箱格式不正确"); 
			flag1=false;
			return false;		
		}else{
			flag1=true;
		}
	});

	$("#telephone").blur(function(){		
		telephone=$('#telephone').val();
		alert(telephone);
		if($.trim(telephone).length==0){
			//alert('电话不能为空!'); 
			flag2=false;
			return false;
		}else if(!(/^1[34578]\d{9}$/.test(telephone))){ 
			//alert("电话格式不正确"); 
			flag2=false;
			return false;		
		}else{
			flag2=true;
		}
	});
	
	$("#identificationCard").blur(function(){
		identificationCard=$('#identificationCard').val();
		if($.trim(identificationCard).length==0){
			//alert("身份证号不能为空");
			flag3=false;
			return false;
		}else if(isCardNo(identificationCard)==false){
			//alert("身份证号格式不正确。");
			flag3=false;
			return false;
		}else{
			flag3=true;
			loaddeMsgByIdcord(identificationCard);
		}
	});
	
	$('#submitForm').click(function() {
		var name=$('#name').val();
		var password=$('#password').val();
		if($.trim(name).length==0){
			alert("姓名不能为空");
			return false;			
		}
		if($.trim(password).length==0){
			alert("密码不能为空");
			return false;			
		}
		if(flag1==false){
			alert("邮箱信息有误，请重新填写！");
			return false;
		}
		if(flag2==false){
			alert("电话信息有误，请重新填写！");
			return false;
		}
		if(flag3==false){
			alert("身份证信息有误，请重新填写！");
			return false;
		}
	});
	
});

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
 * 加载职位对应的工资
 * @param type
 */
function loaddeSalary(type){
	var url = "user/operate_getSalary?dutyId="+type;
	var dis = $('#salary');
	dis.empty();
	$.get(url , function(data, status){
		var jarr = eval("("+data+")");
		dis.val(jarr.dutySalary);
	});		
}

/**
 * 通过身份证号获得其户籍，性别，姓名
 * @param type
 */
function loaddeMsgByIdcord(type){
	var url = "user/operate_getMsgByIdcord?identificationCard="+type;
	var dis1 = $('#sex');
	var dis2 = $('#age');
	var dis3 = $('#domicile');
	dis1.empty();
	dis2.empty();
	dis3.empty();
	$.get(url , function(data, status){
		var jarr = eval("("+data+")");		
		if(jarr.userSex==1){
			dis1.val("男");
		}else{
			dis1.val("女");
		}		
		dis2.val(jarr.userAge);
		dis3.val(jarr.domicile);
	});	
}

/**
 * 验证身份证号
 * @param card
 * @returns
 */
function isCardNo(card) { 
 var pattern = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/; 
 return pattern.test(card); 
}