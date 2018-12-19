package com.gift.futurestrading.member.mapper;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gift.futurestrading.member.vo.ConsumerMypageVo;

@Mapper
public interface ConsumerMapper {
	/* 구매자 회원가입을 위한 insert */
	int insertConsumer(HashMap<String, Object> map);
	
	/* 구매자 회원가입시 아이디 중복확인을 위한 select */
	int selectIdCheck(String id);
	
	/* 구매자 마이페이지 회원정보 수정폼을 위한 select */
	ConsumerMypageVo selectConsumerMypageInformation(Map<String, Object> ConsumerMypageIdPw);
	
	/* 구매자 마이페이지 회원정보 수정처리를 위한 update */
	int updateConsumerMypageInformation(ConsumerMypageVo consumerMypageVo);
	
	/* 구매자 마이페이지 비밀번호 수정처리를 위한 update*/
	int updateConsumerMypagePassword(Map<String, Object> ConsumerMypageChangePw);
}