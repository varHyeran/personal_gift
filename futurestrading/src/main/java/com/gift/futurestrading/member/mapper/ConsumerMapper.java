package com.gift.futurestrading.member.mapper;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ConsumerMapper {
	
	int insertConsumer(HashMap<String, Object> map);
	
}
