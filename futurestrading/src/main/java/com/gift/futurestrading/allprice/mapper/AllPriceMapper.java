package com.gift.futurestrading.allprice.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.gift.futurestrading.allprice.vo.AllPriceVo;


@Mapper
public interface AllPriceMapper {
	
	/* 품목별 시가,종가,최고가,최저가 테이블 insert*/
	int insertAllPrice(AllPriceVo allPriceVo);
	
	/*sign table에서 allPrice테이블에 추가할 리스트(시가(시작가격), 종가(마지막 가격), 최고가, 최저가) select*/
	AllPriceVo selectSignAddAllPrice();
	
	/* auto increment를 위한 select */
	int selectOneAutoMaxAllPrice();
}
