package com.gift.futurestrading.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gift.futurestrading.login.mapper.LoginMapper;
import com.gift.futurestrading.login.vo.LoginVo;

@Service
public class LoginService {
	@Autowired
	private LoginMapper loginMapper;
	/*로그인*/
	public LoginVo getLoginMember(LoginVo loginVo) {
		System.out.println("LoginService.getLoginMember()");
		LoginVo loginMember = loginMapper.selectLoginMember(loginVo);
		System.out.println(loginMember+"<--loginMember");
		return loginMember;
	}
}
