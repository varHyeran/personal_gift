package com.gift.futurestrading.login.service;

import java.util.HashMap;

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
		System.out.println("LoginService.getLogin() 호출");
		LoginVo loginMember = loginMapper.selectLogin(loginVo);
		System.out.println(loginMember+"<--loginMember");
		return loginMember;
	}
	/** 아이디, 비밀번호 일치하는지 체크
	 * 로그인 시 아이디와 비밀번호가 일치하는지 체크하기 위한 메서드
	 * @param 
	 * @return 
	 * @since JDK1.8
	 */
	public int getIdPasswordCheck(HashMap<String, Object> idAndPassword) {
		System.out.println("LoginService.getIdPasswordCheck() 호출");
		int selectResult = loginMapper.selectIdPasswordCheck(idAndPassword);
		return selectResult;
	}
}
