<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Dashboard">
    <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

    <title>大众点评 - 后台管理页面模板</title>

    <!-- Bootstrap core CSS -->
    <link href="${basePath }/assets/css/bootstrap.css" rel="stylesheet">
    <!--external css-->
    <link href="${basePath }/assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
        
    <!-- Custom styles for this template -->
    <link href="${basePath }/assets/css/style.css" rel="stylesheet">
    <link href="${basePath }/css/login.css" rel="stylesheet">
    <link href="${basePath }/assets/css/style-responsive.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>

      <!-- 
      **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** 
      -->

	  <div id="login-page">
	  	<div class="container">
		      <form class="form-login" id="login-form" action="${basePath }/login/check" onSubmit="LoginPage.submit();return false;">
		        <h2 class="form-login-heading">大众点评后台登录</h2>
		        <div class="login-wrap">
		        	<div class="form-group">
			            <input type="text" class="form-control" name="username" placeholder="用户名" autofocus>	        	
		        	</div>
					<div class="form-group">
		            	<input type="password" class="form-control" placeholder="密码" name="password">
					</div>
					<div class="form-group">
		            	<button class="btn btn-theme btn-block"><i class="fa fa-lock"></i>登录</button>
					</div>
		        </div>
		      </form>
	  	</div>
	  </div>
	  <!-- Modal -->
	  <div class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" id="msg-box" aria-hidden="true">
			<div class="modal-dialog modal-sm">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title"></h4>
					</div>
					<div class="modal-body">

					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-success">确定</button>
						<button type="button" class="btn btn-primary" data-dismiss="modal">取消</button>
					</div>
				</div>
			</div>
		</div>

    <!-- js placed at the end of the document so the pages load faster -->
    <script src="${basePath }/assets/js/jquery.js"></script>
    <script src="${basePath }/assets/js/bootstrap.min.js"></script>
    <script src="${basePath }/assets/js/jquery.md5.js"></script>
    <script src="${basePath }/js/common/common.js"></script>
    <script src="${basePath }/js/system/login.js"></script>

    <!--BACKSTRETCH-->
    <!-- You can use an image of whatever size. This script will stretch to fit in any screen size.-->
    <script type="text/javascript" src="${basePath }/assets/js/jquery.backstretch.min.js"></script>
    <script>
        $.backstretch("${basePath }/assets/img/login-bg.jpg", {speed: 500});
    </script>


  </body>
</html>
