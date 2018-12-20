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
	 * 
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
		int orderBuyMax = orderBuyMapper.selectOneAutoMax();
		orderBuyMax += 1;
		String orderBuyPk = "order_buy_"+orderBuyMax;
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("order_consumer_pk",orderBuyPk);
		map.put("fk_consumer__order_buy", orderBuyVo.getFkConsumerOrderBuy());
		map.put("fk_item_detail__order_buy", orderBuyVo.getFkItemDetailOrderBuy());
		map.put("order_buy_consumer_name", orderBuyVo.getOrderBuyConsumerName());
		map.put("order_buy_method", orderBuyVo.getOrderBuyMethod());
		map.put("order_buy_per_price", orderBuyVo.getOrderBuyPerPrice());
		map.put("order_buy_amount", orderBuyVo.getOrderBuyAmount());
		int orderBuyResult = orderBuyMapper.insertOrderBuy(map);
		return orderBuyResult;
	}
}
