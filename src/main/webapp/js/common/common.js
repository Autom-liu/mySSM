var common = window.common || {};

/**
 * 展示指定的消息内容。
 */
common.showMsg = function(title, msg, success) {
	var msgBox = $('#msg-box');
	success = success || function() {
		msgBox.modal('hide');
	};
	msgBox.find('.modal-title').html(title);
	msgBox.find('.modal-body').html(msg);
	success && msgBox.find('.modal-footer .btn-success').one('click',success);
	msgBox.modal('show');
}

common.menuHref = function(obj) {
	var url = obj.href;
	$('#mainPage').attr('src', url);
}

/**
 * 对jQuery的ajax方法的二次封装
 */
common.ajax = function(param) {
	var mergeParam = $.extend({
		timeout : 10000
	} , param , {
		complete : function(response) {
			var url = response.getResponseHeader("url");
			if(url) {
				location.href = url;
			} else {
				if(param.complete && typeof param.complete == "function") {
					param.complete();
				}
			}
		}
	});
	$.ajax(mergeParam);
}

/**
 * 页面返回码定义，与后台PageCode定义对应
 */
common.pageCode = {
		"ADD_SUCCESS" : 1000,
		"MODIFY_SUCCESS" : 1100,
		"REMOVE_SUCCESS" : 1200
}

common.menuPrefix = {
		"PREFIX_MENU" : "MENU_",
		"PREFIX_ACTION" : "ACTION_"
}