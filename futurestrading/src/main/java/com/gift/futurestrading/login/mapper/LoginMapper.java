package com.gift.futurestrading.login.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.gift.futurestrading.login.vo.LoginVo;

@Mapper
public interface LoginMapper {
	/*로그인*/
	LoginVo selectLoginMember(LoginVo loginVo);
}
