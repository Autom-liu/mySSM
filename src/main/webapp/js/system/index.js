// 当前登录用户可以访问的菜单Map
var menuMap = {};

function init() {
	common.ajax({
			url : $("#basePath").val() + "/session/menus",
			success : function(data) {
				if(data && data.length > 0) {
					$.each(data,function(i,value) {
						if(!menuMap[value.parentId]) {
							menuMap[value.parentId] = new Array();
						}
						menuMap[value.parentId].push(value);
					});
					initMenu();
				}
			}
	});
}

/**
 * 初始化菜单
 */
function initMenu() {
	var menuList = menuMap[0];
	$("#menuDiv").html("");
	$.each(menuList,function(i,value) {
		$("#menuDiv").append("<li onclick='clickMenu(this," + value.id + ")'><a><span>" + value.name + "</span></a></li>");
	});
}

/**
 * 根据父菜单ID初始化子菜单
 */
function initSubMenu(parentId) {
	var menuList = menuMap[parentId];
	$("#subMenuDiv").html("");
	$.each(menuList,function(i,value) {
		$("#subMenuDiv").append("<h3 onclick=\"clickSubMenu(this,'" + value.url + "')\"><a>" + value.name + "</a></h3>");
	});
}

/**
 * 方法描述:单击菜单（页面上部菜单），初始化子菜单（即页面左部菜单）
 */
function clickMenu(element,id) {
	// 将当前单击的节点置为[选中样式]，清除兄弟样式
	$(element).addClass('on').siblings().removeClass('on');
	// 加载子菜单内容
	// initSubMenu(id);
	$('#' + id).show().siblings().hide();
}

/**
 * 方法描述:单击子菜单（页面左部菜单），初始化主页面
 */
function clickSubMenu(element,path) {
	// 将当前单击的节点置为[选中样式]，清除兄弟样式
	$(element).addClass('on').siblings().removeClass('on');
	// 按指定地址加载主页面(iframe)
	$("#mainPage").attr("src", path);
}

/**
* 打开密码修改弹出层
*/
function openAddDiv(){
	$("#mengban").css("visibility","visible");
	$(".wishlistBox").show();
	$(".wishlistBox").find(".persongRightTit").html("&nbsp;&nbsp;修改密码");
	$("#submitVal").show();
}

/**
* 关闭密码修改弹出层
*/
function closeDiv(){
	$("#mengban").css("visibility","hidden");
	$("#oldPassword").val("");
	$("#newPassword").val("");
	$("#newPasswordAgain").val("");
	$(".wishlistBox").hide();
}