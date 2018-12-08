<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
		<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE"/>
		<title></title>
		<link rel="stylesheet" type="text/css" href="${basePath}/assets/css/bootstrap.css"/>
		<style>
			body{background: #f2f2f2;}
			.btn{margin: 0 8px;}
		</style>
	</head>
	<body>
		<div class="right">
				<form action="${basePath }/ad/add" role="form" class="form-horizontal" id="form-data">
					<div class="row">
						<div class="form-group col-sm-5">
							<div class="col-sm-4 control-label">
								<label>标题</label>
							</div>
							<div class="col-sm-8">
								<input type="text" class="form-control" placeholder="" name="title" />
							</div>
						</div>
						<div class="form-group col-sm-6">
							<div class="col-sm-4 control-label">
								<label>上传图片</label>
							</div>
							<div class="col-sm-8">
								<input type="file" class="form-control" placeholder="" name="imgFile" />
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group col-sm-5">
							<div class="col-sm-4 control-label">
								<label>链接地址</label>
							</div>
							<div class="col-sm-8">
								<input type="text" class="form-control" placeholder="" name="link"/>
							</div>
						</div>
						<div class="form-group col-sm-7">
							<div class="col-sm-4 control-label">
								<label>权重(值越大排名越靠前)</label>
							</div>
							<div class="col-sm-6">
								<input type="text" class="form-control" placeholder="值越大排名越靠前" name="weight"/>
							</div>
						</div>
					</div>
					<div class="form-group row">
						<div class="col-sm-offset-2 col-sm-8">
							<button class="btn btn-default" onClick="adAddPage.submit();return false;">保存</button>
							<button class="btn btn-success" onClick="adAddPage.goback();return false;">返回</button>
						</div>
					</div>
				</form>
			</div>
		</div>
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
		<script type="text/javascript" src="${basePath}/assets/js/jquery.js"></script>
		<script src="${basePath}/assets/js/bootstrap.min.js"></script>
		<script src="${basePath}/js/content/adAddEdit.js"></script>
	</body>
</html>