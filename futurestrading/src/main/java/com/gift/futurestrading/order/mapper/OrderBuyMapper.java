package com.gift.futurestrading.order.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gift.futurestrading.order.vo.OrderBuyListVo;
@Mapper
public interface OrderBuyMapper {
	/*주문리스트 전체 행 구하기 위한 select*/
	int selectOrderBuyAllCount(String sessionLoginId);
	/*품목에 따른 회원별 주문리스트*/
	List<OrderBuyListVo> selectOrderBuyList(Map<String, Object> idAndCri);
	/*구매자 주문매수 위한 insert*/
	int insertOrderBuy(HashMap<String, Object> map);
	/*매수주문 등록할 때 pk값 1씩증가해서 들어가도록 하는 select*/
	int selectOneAutoMaxOrderBuy();
	/*품목에 따른 시가 조회하는 select*/
	int selectClosePriceItemOne();
}
