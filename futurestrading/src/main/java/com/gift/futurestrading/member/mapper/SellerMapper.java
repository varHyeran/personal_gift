package com.gift.futurestrading.member.mapper;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SellerMapper {
	int selectIdCheck(String id);
	int insertSeller(HashMap<String, Object> map);
	int insertSellerFile (HashMap<String, Object> map);
	int selectOneAutoMax();
}
