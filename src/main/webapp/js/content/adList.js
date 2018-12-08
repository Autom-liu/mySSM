
var adListPage = (function() {
	var listData = {currentPage: 1};
	var getUrl   = basePath + '/ad/list';
	var deleteUrl= basePath + '/ad/delete';
	var editPage = basePath + '/ad/editPage?id=${id}'
	
	getData();
	
	function getData() {
		var title = $('input[name="title"]').val().trim();
		var postData = {title: title, 'page.currentPage': listData.currentPage};
		$.get(getUrl, postData, function(res) {
			listData = res;
			renderData(res.data);
		}, 'json');
		return false;
	}

	function renderData(data) {
		var html = '';
		var template = '<tr>\
			<td>${id}</td>\
			<td>${title}</td>\
			<td>${link}</td>\
			<td>${img}</td>\
			<td>\
				<div class="btn-group">\
					<a href="'+ editPage +'" class="btn btn-default">编辑</a>\
					<button class="btn btn-danger" onClick="adListPage.showDeleteConfirm(${id})">删除</button>\
				</div>\
			</td></tr>';
		if(Array.isArray(data)) {
			data.forEach(function (ele, index) {
				html += template.replace(/\${(\w+)}/g, function(p, $1) {
					return ele[$1];
				});
			});
		}
		$('#data-table').html(html);
		renderPagination();
	}
	
	function renderPagination() {
		var template = '当前第${currentPage}页/共${totalPage}页';
		$('#pagination .info').html(template.replace(/\${(\w+)}/g, function(p, $1) {
			return listData[$1];
		}));
	}
	
	function showMsg(title, msg, success) {
		var msgBox = $('#msg-box');
		msgBox.find('.modal-title').html(title);
		msgBox.find('.modal-body').html(msg);
		success && msgBox.find('.modal-footer .btn-success').one('click',success);
		msgBox.modal('show');
	}
	
	function showDeleteConfirm(id) {
		showMsg('系统确认？', '你确定要删除吗？', function() {
			var postData = {id: id};
			$.post(deleteUrl, postData, function(res) {
				showMsg('系统提示', res.msg);
				getData();
			}, 'json');
		});
	}
	
	return {
		getData: getData,
		goFirst: function() {
			listData.currentPage = 1;
			getData();
		},
		goPrev: function() {
			var current = listData.currentPage;
			if(current > 1) {
				listData.currentPage = current - 1;
				getData();
			}
		},
		goNext: function() {
			var current = listData.currentPage;
			var last	= listData.totalPage;
			if(current < last) {
				listData.currentPage = current + 1;
				getData();
			}
		},
		goLast: function() {
			var last = listData.totalPage;
			if(last) {
				listData.currentPage = last;
				getData();
			}
		},
		showDeleteConfirm: showDeleteConfirm,
	}
})();
