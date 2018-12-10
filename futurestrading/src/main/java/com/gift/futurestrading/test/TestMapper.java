package com.gift.futurestrading.test;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestMapper {
	List<SellerVo> selectSeller();
}
