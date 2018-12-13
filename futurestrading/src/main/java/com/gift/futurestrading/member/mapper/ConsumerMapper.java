package com.gift.futurestrading.member.mapper;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ConsumerMapper {
	/* 구매자 회원가입을 위한 insert */
	int insertConsumer(HashMap<String, Object> map);
	
	/* 구매자 회원가입시 아이디 중복확인을 위한 select */
	int selectIdCheck(String id);
	
}