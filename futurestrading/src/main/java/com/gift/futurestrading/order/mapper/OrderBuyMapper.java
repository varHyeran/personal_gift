package com.gift.futurestrading.order.mapper;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface OrderBuyMapper {
	/*구매자 주문매수 위한 insert*/
	int insertOrderBuy(HashMap<String, Object> map);
	/*pk값 증가시키기 위한 select*/
	int selectOneAutoMax();
}
