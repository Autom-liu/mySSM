<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute type="com.scnu.bean.Page" name="page" required="true" %>
<%@ attribute type="String" name="callBack" required="true" %>

<script type="text/javascript">
	function transPage(currentPage) {
		var rule = /^[0-9]*[1-9][0-9]*$/;
		if(!rule.test(currentPage)) {
			currentPage = 1;
		}
		eval("${callBack}(currentPage)");
	}
</script>

<div class="page fix">
	<a href="javascript:transPage(1);" class="first">首页</a>
	<a href="javascript:transPage(${page.currentPage - 1 });" class="pre">上一页</a>
	当前第<span>${page.currentPage }/${page.totalPage }</span>页
	<a href="javascript:transPage(${page.currentPage + 1 });" class="next">下一页</a>
	<a href="javascript:transPage(${page.totalPage });" class="last">末页</a>
	跳至 &nbsp;<input value="1" id="currentPageInput" class="allInput w28" type="text"/>&nbsp;页 &nbsp;
	<a href="###" class="javascript:transPage($('#currentPageInput').val());">GO</a>
</div>
