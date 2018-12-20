package com.gift.futurestrading.order.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gift.futurestrading.order.mapper.OrderSellMapper;
import com.gift.futurestrading.order.vo.OrderSellVo;
@Service
public class OrderSellService {
	@Autowired
	private OrderSellMapper orderSellMapper;
	
	public int insertOrderSelller(OrderSellVo orderSellVo) {
		System.out.println("sellerService.insertseller() 호출");
		int sellerMaxId = orderSellMapper.selectOneAutoMax();
		sellerMaxId += 1;
		String orderSellerPkLetter = "order_sell_"+sellerMaxId;
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("order_sell_pk",orderSellerPkLetter);
		map.put("fk_seller__order_sell", orderSellVo.getFkSellerOrderSell());
		map.put("fk_item_detail__order_sell", orderSellVo.getFkItemDetailOrderSell());
		map.put("order_sell_seller_name", orderSellVo.getFkSellerOrderSell());
		map.put("order_sell_method", orderSellVo.getOrderSellMethod());
		map.put("order_sell_per_price", orderSellVo.getOrderSellPerPrice());
		map.put("order_sell_amount", orderSellVo.getOrderSellAmount());

		int insertResult = orderSellMapper.insertOrderSeller(map);

		return insertResult;
	}
}
