package com.gift.futurestrading.sign.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gift.futurestrading.sign.vo.OrderBuyVo;
import com.gift.futurestrading.sign.vo.OrderSellVo;

@Mapper
public interface SignMapper {

	/* orderSellVariableAmount 값에 따라 조건에 맞는 order_sell 테이블의 update */
	int updateOrderSell(HashMap<String, Object> mapForOrderSell);
	
	/* orderBuyVariableAmount 값에 따라 조건에 맞는 order_buy 테이블의 update */
	int updateOrderBuy(HashMap<String, Object> mapForOrderBuy);
	
	/* order_buy, order_sell 테이블에서 각각 조회해온 데이터를 sign 테이블에 insert */
	int insertSign(HashMap<String, Object> map);
	
	/* order_sell 테이블에서 '가격우선원칙->시간우선원칙->수량우선원칙'을 순서대로 만족하는 데이터 한 행을 조회하기위한 select */
	List<OrderSellVo> selectOneRowOfOrderSellForSign();
	
	/* order_buy 테이블에서 '가격우선원칙->시간우선원칙->수량우선원칙'을 순서대로 만족하는 데이터 한 행을 조회하기위한 select */
	List<OrderBuyVo> selectOneRowOfOrderBuyForSign();	
	
	/* 문자  + 숫자 조합의 primary key에서 숫자를 가져오기위한(기본키값 자동증가 구현을 위해) select */
	List<Integer> selectPkOfSign();
	
}