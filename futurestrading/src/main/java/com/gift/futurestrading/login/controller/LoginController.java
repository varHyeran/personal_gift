package com.gift.futurestrading.login.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gift.futurestrading.login.service.LoginService;
import com.gift.futurestrading.login.vo.LoginVo;

@Controller
public class LoginController {
	@Autowired
	private LoginService loginService;
	/*  로그인 폼 */
	@RequestMapping(value="/login/login", method=RequestMethod.GET)
	public String getLoginMember(HttpSession session) {
		System.out.println("LoginController.getLoginMember() 호출 GET");
		String loginReturn = null;
		if(session.getAttribute("sessionLoginMember")!=null) {
			loginReturn = "redirect:/";
		}else {
			loginReturn = "login/login";
		}
		return loginReturn;
	}
	/*  로그인 액션*/
	@RequestMapping(value="/login/login", method=RequestMethod.POST)
	public String getLoginMember(LoginVo loginVo,HttpSession session) {
		System.out.println("LoginController.getLoginConsumer() 호출 POST");
		String loginReturn = null;
		if(loginService.getLoginMember(loginVo)!=null) {
			System.out.println("login success!!");
			LoginVo sessionLoginMember = loginService.getLoginMember(loginVo);
			System.out.println(sessionLoginMember+"<--sessionLoginMember");
			session.setAttribute("sessionLoginMember", sessionLoginMember);
			loginReturn = "redirect:/";
		}else {
			System.out.println("login fail!!");
			loginReturn = "login/login";
		}
		return loginReturn;
	}
	/* 로그아웃*/
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logoutMember(HttpSession session) {
		System.out.println("LoginController.logoutMember() 호출 GET");
		session.invalidate();
		return "redirect:/";
	}
}
