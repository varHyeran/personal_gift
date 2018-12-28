package com.gift.futurestrading.order.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gift.futurestrading.order.mapper.OrderBuyMapper;
import com.gift.futurestrading.order.vo.OrderBuyVo;

@Service
public class OrderBuyService {
	@Autowired
	private OrderBuyMapper orderBuyMapper;
	/**
	 * 매수 등록
	 * 매수주문에 필요한 메서드
	 * @param map 
	 * @return 
	 * @since JDK1.8
	 */
	public int addOrderBuy(OrderBuyVo orderBuyVo) {
		System.out.println("OrderBuyService.addOrderBuy() 호출");		
		/*order_buy_pk값이 증가되어 들어가도록 쿼리 실행
		 * select max(CAST(substring(order_buy_pk,11) AS DECIMAL)) from order_buy 실행되어 최대값구한 후 orderBuyMax에 대입
		 * orderBuyMax가 1씩 증가되어 insert되도록 한다.
		 * */
		int orderBuyMax = orderBuyMapper.selectOneAutoMaxOrderBuy();
		orderBuyMax += 1;
		String orderBuyPk = "order_buy_"+orderBuyMax;
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("order_buy_pk",orderBuyPk);											// pk
		map.put("fk_consumer__order_buy", orderBuyVo.getFkConsumerOrderBuy());		// 아이디
		map.put("fk_item_detail__order_buy", orderBuyVo.getFkItemDetailOrderBuy());	// 품목no
		map.put("order_buy_consumer_name", orderBuyVo.getFkConsumerOrderBuy());		// 이름
		map.put("order_buy_method", orderBuyVo.getOrderBuyMethod());				// 매수방법
		map.put("order_buy_per_price", orderBuyVo.getOrderBuyPerPrice());			// 가격
		map.put("order_buy_amount", orderBuyVo.getOrderBuyAmount());				// 수량
		int orderBuyResult = orderBuyMapper.insertOrderBuy(map);
		return orderBuyResult;
	}
	/**
	 * 종가조회
	 * 품목에 따른 종가조회에 필요한 메서드
	 * @param map 
	 * @return 
	 * @since JDK1.8
	 */
	public int getClosePriceItemOne() {
		System.out.println("OrderBuyService.getClosePriceItemOne() 호출");	
		int getClosingPriceResult = orderBuyMapper.selectClosePriceItemOne();
		return getClosingPriceResult;
	}
}
