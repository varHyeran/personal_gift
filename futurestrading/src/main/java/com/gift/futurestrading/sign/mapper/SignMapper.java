package com.gift.futurestrading.sign.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gift.futurestrading.sign.vo.OrderBuyVo;
import com.gift.futurestrading.sign.vo.OrderSellVo;

@Mapper
public interface SignMapper {
	
	/* sign 테이블에 데이터 추가 되면 order_sell 테이블의 상태 컬럼에 '미체결' -> '체결'로 update 시키기  */
	int updateStatusOfOrderSell(String orderSellPk);
	
	/* sign 테이블에 데이터 추가 되면 order_buy 테이블의 상태 컬럼에 '미체결' -> '체결'로 update 시키기 */
	int updateStatusOfOrderBuy(String orderBuyPk);
	
	/* order_buy, order_sell 테이블에서 각각 조회해온 데이터를 sign 테이블에 insert 시키기 */
	int insertSign(HashMap<String, Object> map);
	
	/* order_sell 테이블에서 미체결 상태인 특정 품목의 1계약당 가격 중 최소값 구하기 */
	List<OrderSellVo> selectOneRowOfOrderSellForSign();
	
	/* order_buy 테이블에서 미체결 상태인 특정 품목의 1계약당 가격 중 최대값 구하기 */
	List<OrderBuyVo> selectOneRowOfOrderBuyForSign();	
	
	/* 문자  + 숫자 조합의 primary key에서 숫자를 가져오기위한(기본키값 자동증가 구현을 위해) select */
	List<Integer> selectPkOfSign();
	
}