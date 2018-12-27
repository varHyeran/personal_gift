package com.gift.futurestrading.member.mapper;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.gift.futurestrading.member.vo.AccountCheckResultVo;

@Mapper
public interface SellerMapper {
	//id 유효성 확인
	int selectIdCheck(String id);
	//계좌 유효성 확인
	AccountCheckResultVo selectAccountCheck(HashMap<String, Object> map);
	//seller회원가입
	int insertSeller(HashMap<String, Object> map);
	//sellerFileUpload
	int insertSellerFile (HashMap<String, Object> map);
	//PK값 자동증가 코드시 최대값 가져오기
	int selectOneAutoMax(); 
}
