package com.gift.futurestrading.order.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.gift.futurestrading.order.service.OrderSellService;
import com.gift.futurestrading.order.vo.OrderSellVo;

@Controller
public class OrderSellController {
	@Autowired
	private OrderSellService orderSellService;
	
	
	@RequestMapping("/order/sell")
	public String OrderSell(HttpSession session, Model model ,OrderSellVo orderSellVo) {
		System.out.println("OrderSellController / OrderSell");
		model.addAttribute("sessionLogin", session.getAttribute("sessionLoginMember"));
		//service Test
		
		orderSellVo.setFkSellerOrderSell("seller");
		orderSellVo.setFkItemDetailOrderSell("배추");
		orderSellVo.setOrderSellMethod("지정가");
		orderSellVo.setOrderSellPerPrice(50000);
		orderSellVo.setOrderSellAmount(20);
		
		orderSellService.insertOrderSelller(orderSellVo);
		
		return "index";
	}
}
