package com.gift.futurestrading.login.mapper;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.gift.futurestrading.login.vo.LoginVo;

@Mapper
public interface LoginMapper {
	/*로그인할때 사용하는 select*/
	LoginVo selectLogin(LoginVo loginVo);
	/*아이디와 비밀번호 일치하는지 체크하는 select*/
	int selectIdPasswordCheck(HashMap<String, Object> idAndPassword);
}
