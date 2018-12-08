package com.scnu.web.controller.system;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.scnu.contanst.LoginCodeEnum;
import com.scnu.contanst.SessionKeyConst;
import com.scnu.dto.UserDto;
import com.scnu.service.UserService;
import com.scnu.util.CommonUtil;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private UserService us;
	@Autowired
	private HttpSession session;
	
	@RequestMapping
	public String index() {
		return "system/login";
	}
	
	@RequestMapping(value="/check", method=RequestMethod.POST)
	public @ResponseBody Map<?,?> check(UserDto userDto, HttpServletRequest request) {
		// TODO 增加验证码的功能
		
		if (userDto == null || CommonUtil.isEmpty(userDto.getUsername()) || CommonUtil.isEmpty(userDto.getPassword())) {
			return LoginCodeEnum.LOGIN_ERROR.convertToMap();
		}
		
		Map<String, Object> result = us.checkLogin(userDto).convertToMap();
		if((int)result.get("code") == 0) {
			// 添加session
			session.setAttribute(SessionKeyConst.USER_INFO, userDto);			
		}
		
		// 协议 + 主机名 + 端口号 + 项目名称
		String baseUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
		result.put("nextUrl", baseUrl + "/index");
		return result;
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		// 销毁session
		session.invalidate();
		return "redirect:/login";
	}
}
