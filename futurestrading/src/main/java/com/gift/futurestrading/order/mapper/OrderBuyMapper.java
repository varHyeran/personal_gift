package com.gift.futurestrading.order.mapper;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface OrderBuyMapper {
	/*구매자 주문매수 위한 insert*/
	int insertOrderBuy(HashMap<String, Object> map);
	/*매수주문 등록할 때 pk값 1씩증가해서 들어가도록 하는 select*/
	int selectOneAutoMaxOrderBuy();
	/*품목에 따른 시가 조회하는 select*/
	int selectClosePriceItemOne();
}
