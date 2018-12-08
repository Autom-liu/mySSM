<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<title></title>
		<link rel="stylesheet" type="text/css" href="${basePath}/assets/css/bootstrap.css"/>
		<script type="text/javascript" src="${basePath}/assets/js/jquery.js"></script>
		<script src="${basePath}/assets/js/bootstrap.min.js"></script>
		<style>
			body {
				background: #f2f2f2;
			}
			.row {
				margin: 14px 0;
			}
			.btn {
				margin: 0 8px;
			}
		</style>
	</head>
	<body>
			<div class="right">
				<div class="row">
					<div class="col-md-6 col-md-offset-1">
						<div class="form-inline">
							<div class="form-group">
								<label class="sr-only">标题</label>
								<input type="text" class="form-control" placeholder="标题" name="title" />
							</div>
							<div class="form-group">
								<button class="btn btn-success" onClick="adListPage.getData()">查询</button>
								<a href="${basePath }/ad/addPage" class="btn btn-info">添加</a>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<table class="table table-striped table-bordered table-hover">
						<thead>
							<tr>
								<th>编号</th>
								<th>标题</th>
								<th>链接</th>
								<th>图片</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody id="data-table">
							<tr class="active">
								<td>表格单元格</td>
								<td>表格单元格</td>
								<td>表格单元格</td>
								<td>表格单元格</td>
								<td>表格单元格</td>
							</tr>
							<tr class="success">
								<td>表格单元格</td>
								<td>表格单元格</td>
								<td>表格单元格</td>
								<td>表格单元格</td>
								<td>表格单元格</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="row">
					<div id="pagination">
						<ul class="pager">
						    <li><a href="javascript:adListPage.goFirst()">首页</a></li>
						    <li><a href="javascript:adListPage.goPrev()">上一页</a></li>
						    <li class="info">当前第1页/共0页</li>
						    <li><a href="javascript:adListPage.goNext()">下一页</a></li>
						    <li><a href="javascript:adListPage.goLast()">尾页</a></li>
						</ul>
					</div>
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
		<script>
			var basePath = "${basePath}";
		</script>
		<script src="${basePath }/js/content/adList.js"></script>
	</body>
</html>