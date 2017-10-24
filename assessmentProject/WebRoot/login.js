$(document).ready(function() {	
	var flag1 = false;
	var flag2 = false;
	var name, password;
/*	$("#username").blur(function(){
		name = $(this).val();
		if($.trim(name).length==0){
			//alert('账号不能为空！'); 
			flag1=false;
			return false;
		}else{
			flag1 = true;
		}
	});			
	$("#password").blur(function(){
		password = $(this).val();
		if($.trim(password).length==0){
			//alert('密码不能为空！');
			flag2=false;			
			return false;
		}else{
			flag2 = true;
		}
	});	*/	
	$('#loginForm').click(function() {		
		name = $(this).val();
		if($.trim(name).length==0){
			alert('账号不能为空！'); 
			flag1=false;
			return false;
		}
		password = $(this).val();
		if($.trim(password).length==0){
			alert('密码不能为空！');
			flag2=false;			
			return false;
		}
	});
	
	var flag3 = false;
	var flag4 = false;
	var flag5 = false;
	var flag6 = false;
	var flag7 = false;
	var flag8 = false;
	var emailMsg, password1,password2;
	$("#emailMsg").blur(function(){
		emailMsg = $(this).val();
		if($.trim(emailMsg).length==0){
			//alert('邮箱或电话不能为空！'); 
			flag4=false;
			return false;
		}else{				
			if(emailMsg.match(/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/)){ 
			//alert("邮箱格式不正确"); 
			flag7=true;
		}
			if((/^1[34578]\d{9}$/.test(emailMsg))){ 
			//alert("手机号码格式不正确！"); 
			flag8=true;
		}
		if(flag7==true||flag8==true){
			flag4=true;
		}		
		}
	});		
	$("#password1").blur(function(){
		password1 = $(this).val();
		if($.trim(password1).length==0){
			//alert('密码不能为空！'); 
			flag5=false;
			return false;
		}else{
			flag5 = true;
		}
	});		
	$("#password2").blur(function(){
		password2 = $(this).val();
		if($.trim(password2).length==0){
			//alert('请再次填写确认密码'); 
			flag6=false;
			return false;
		}else{
			if(password1==password2){
				flag6 = true;
			}else{
				//alert("两次密码输入的不一样，请重新输入确认密码。");				
				flag6=false;
				return false;
			}
			
		}
	});	
	
	$('#signUp').click(function() {		
		
		if(flag4==false){
			alert("请填写正确的电话或邮箱信息");			
			return false;
		}
		if(flag5==false){
			alert("密码不能为空，请重新填写");			
			return false;
		}
		if(flag6==false){
			alert("请重新填写确认密码");			
			return false;
		}
		if(flag3==false){
			alert("请填写正确的验证码");			
			return false;
		}
	});
		
	$("#verificationCode").blur(function(){
		var code;
		code = $(this).val();
		if($.trim(code).length==0){
			//alert('请输入验证码！'); 
			flag3=false;
			return false;			
		}else{
			$.post("systemUser/systemUser_checkVerificationCode",
					{verificationCode:code},
					function success(data,status){
						data = eval('(' + data + ')');
						
						if (data.result == '0'){
							//alert("验证码匹配成功");
							$("#checkRetuen").html("验证码匹配成功");
							 $("#checkRetuen").css("color","green");
							flag3=true;
						}else{
							//alert("验证码错误");
							$("#checkRetuen").html("验证码错误");
							  $("#checkRetuen").css("color","red");
							flag3=false;
							return false;
						}
					});
		}
	});
	
});

function reloadimg(){
  	
		var obj = document.getElementById("checkimg");
		obj.src="random.jsp?"+Math.random();
		
}
