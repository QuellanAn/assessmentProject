<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta charset="utf-8" />
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<base href="<%=basePath%>" />
<title>Login</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,700"
	rel="stylesheet"> -->
<link rel="stylesheet" href="mode/css/animate.css">
<link rel="stylesheet" href="mode/css/icomoon.css">
<link rel="stylesheet" href="mode/css/themify-icons.css">
<link rel="stylesheet" href="mode/css/bootstrap.css">
<link rel="stylesheet" href="mode/css/magnific-popup.css">
<link rel="stylesheet" href="mode/css/owl.carousel.min.css">
<link rel="stylesheet" href="mode/css/owl.theme.default.min.css">
<link rel="stylesheet" href="mode/css/style.css">
<script src="mode/js/modernizr-2.6.2.min.js"></script>
<script language="JavaScript">    
//判断当前窗口是否有顶级窗口，如果有就让当前的窗口的地址栏发生变化，    
//这样就可以让登陆窗口显示在整个窗口了    
function loadTopWindow(){    
    if (window.top!=null && window.top.document.URL!=document.URL){    
        window.top.location= document.URL;     
    }    
}    
</script>    
</head>

<body onload="loadTopWindow()">
	<div class="gtco-loader"></div>
	<div id="page">
		<div class="page-inner">
			<header id="gtco-header" class="gtco-cover" role="banner"
				style="background-image: url(mode/images/img_4.jpg)">
			<div class="overlay"></div>
			<div class="gtco-container">
				<div class="row">
					<div class="col-md-12 col-md-offset-0 text-left">
						<div class="row row-mt-15em">
							<div class="col-md-7 mt-text animate-box"
								data-animate-effect="fadeInUp">
								<span class="intro-text-small">Welcome to </span>
								<h1 style="font-family:'微软雅黑';font-weight:normal;font-style:italic;">中航信息</h1>
								<h2 style="font-family:'微软雅黑';margin-top: 40px;margin-left: 150px;"> 非淡泊无以明志，非宁静无以致远。</h2>
							</div>
							<div class="col-md-4 col-md-push-1 animate-box"
								data-animate-effect="fadeInRight">
								<div class="form-wrap">
									<div class="tab">

										<%
											if (session.getAttribute("loginResult") == "error") {
												session.setAttribute("loginResult", null);
										%>
										<div style="color: red;">
											<span class="red">该用户的账号或密码错误！</span>
										</div>
										<%
											}
										%>

										<ul class="tab-menu">
											<li class="active gtco-first"><a href="#"
												data-tab="login">Login</a></li>
											<li class="gtco-second"><a href="#" data-tab="signup">Sign
													up</a>
											</li>
										</ul>
										<div class="tab-content">
											<div class="tab-content-inner " data-content="signup">
												<form action="systemUser/systemUser_regist" method="post">
													<div class="row form-group">
														<div class="col-md-12">
															<label for="username">Telephone or Email</label> <input
																type="text" class="form-control" id="emailMsg" name="emailMsg">
														</div>
													</div>
													<div class="row form-group">
														<div class="col-md-12">
															<label for="password1">Password</label> <input
																type="password" class="form-control" id="password1" name="password1">
														</div>
													</div>
													<div class="row form-group">
														<div class="col-md-12">
															<label for="password2">Repeat Password</label> <input
																type="password" class="form-control" id="password2" name="password2">
														</div>
													</div>

													<div class="row form-group">
														<div class="col-md-12">
															<label for="verificationCode">Verification Code:
																<a href="javaScript:reloadimg()"><img id="checkimg"
																	src="random.jsp">
															</a>
															</label> <input type="text" class="form-control"
																id="verificationCode" name="code">
														</div>
														<div class="col-md-12" >
															<span id="checkRetuen"> </span>
														</div>
													</div>

													<div class="row form-group">
														<div class="col-md-12">
															<input type="submit" class="btn btn-primary"
																value="Sign up" id="signUp">
														</div>
													</div>
												</form>
											</div>

											<div class="tab-content-inner active" data-content="login">
												<form action="systemUser/systemUser_login" method="post">
													<div class="row form-group">
														<div class="col-md-12">
															<label for="username">Username or Email</label> <input
																type="text" class="form-control" id="username"
																name="msg" value="<s:property  value="msg"/>">
														</div>
													</div>
													<div class="row form-group">
														<div class="col-md-12">
															<label for="password">Password</label> <input
																type="password" class="form-control" id="password"
																name="password">
														</div>
													</div>
													<div class="row form-group">
														<div class="col-md-12">
															<input type="submit" class="btn btn-primary"
																value="Login" id="loginForm">
														</div>
													</div>
												</form>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			</header>
		</div>
	</div>
	<script src="mode/js/jquery.min.js"></script>
	<script src="mode/js/jquery.easing.1.3.js"></script>
	<script src="mode/js/bootstrap.min.js"></script>
	<script src="mode/js/jquery.waypoints.min.js"></script>
	<script src="mode/js/owl.carousel.min.js"></script>
	<script src="mode/js/jquery.countTo.js"></script>
	<script src="mode/js/jquery.magnific-popup.min.js"></script>
	<script src="mode/js/magnific-popup-options.js"></script>
	<script src="mode/js/main.js"></script>
	<script src="login.js"></script>
</body>
</html>

