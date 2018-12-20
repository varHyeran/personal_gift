package com.gift.futurestrading.member.mapper;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.gift.futurestrading.member.vo.AccountCheckResultVo;

@Mapper
public interface SellerMapper {
	int selectIdCheck(String id);
	AccountCheckResultVo selectAccountCheck(HashMap<String, Object> map);
	int insertSeller(HashMap<String, Object> map);
	int insertSellerFile (HashMap<String, Object> map);
	int selectOneAutoMax(); 
}
