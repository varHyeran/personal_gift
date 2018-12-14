package com.gift.futurestrading.member.mapper;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SellerMapper {
	int selectIdCheck(String id);
	/* 구매자 회원가입을 위한 insert */
	int insertSeller(HashMap<String, Object> map);
}
