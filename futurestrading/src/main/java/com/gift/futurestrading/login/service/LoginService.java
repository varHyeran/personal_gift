package com.gift.futurestrading.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gift.futurestrading.login.mapper.LoginMapper;
import com.gift.futurestrading.login.vo.LoginVo;

@Service
public class LoginService {
	@Autowired
	private LoginMapper loginMapper;
	/** 로그인
	 * 로그인 처리를 위한 메서드
	 * @param LoginVo loginVo
	 * @return loginMember
	 * @since JDK1.8
	 */
	public LoginVo getLogin(LoginVo loginVo) {
		System.out.println("LoginService.getLogin()");
		LoginVo loginMember = loginMapper.selectLogin(loginVo);
		System.out.println(loginMember+"<--loginMember");
		return loginMember;
	}
}
