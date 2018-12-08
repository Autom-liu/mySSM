var adAddPage = (function() {
	
	var form = document.getElementById('form-data');
	var url  = form.action;
	
	function submit() {
		var postData = new FormData(form);
		$.ajax({
			type: 'post',
			dataType: 'json',
			url: url,
			data: postData,
			processData: false,
			contentType: false,
			success: function(res) {
				if(res.code * 1 === 10000) {
					showMsg('添加/编辑成功', res.msg);
				} else {
					showMsg('添加/编辑失败', res.msg);					
				}
			},
			error: function() {

			}
		})
		return false;
	}
	
	function showMsg(title, msg) {
		var msgBox = $('#msg-box');
		msgBox.find('.modal-title').html(title);
		msgBox.find('.modal-body').html(msg);
		msgBox.modal('show');
	}
	
	return {
		submit: submit,
		goback: function() {
			window.history.back();
		}
	};
})();