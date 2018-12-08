var LoginPage = (function () {
	
	var checkUrl = $('#login-form').attr('action');
	
	function getPostData() {
		var postData = {
			username: $('input[name="username"]').val().trim(),
			password: $.md5($('input[name="password"]').val().trim()),
		};
		return postData;
	}
	
	function submit() {
		var postData = getPostData();
		$.post(checkUrl, postData, function(res) {
			if(res.code !== 0) {
				common.showMsg('登录提示', res.msg);				
			} else {
				location.href = res.nextUrl;
			}
		}, 'json')
		return false;
	}
	
	return {
		submit: submit,
	}
	
})();
