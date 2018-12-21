package com.gift.futurestrading.allprice;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AllPriceMapper {
	
	/* 품목별 시가,종가,최고가,최저가 테이블 insert*/
	int insertAllPrice(AllPriceVo allPriceVo);
	
	/*sign table에서 allPrice테이블에 추가할 리스트 select*/
	AllPriceVo selectSignAddAllPrice();
}
