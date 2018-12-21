package com.gift.futurestrading.order.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gift.futurestrading.order.service.OrderSellService;
import com.gift.futurestrading.order.vo.OrderSellVo;

@Controller
public class OrderSellController {
	@Autowired
	private OrderSellService orderSellService;
	
	@RequestMapping(value="/seller/order", method=RequestMethod.GET)
	public String addsellerOrder() {
		System.out.println("SellerService.addSellerOrder() 호출");
		return "order/seller/addMemeberSellerOrder";
	}
	@RequestMapping("/order/sell")
	public String OrderSell(HttpSession session, Model model ,OrderSellVo orderSellVo) {
		System.out.println("OrderSellController / OrderSell");
		model.addAttribute("sessionLogin", session.getAttribute("sessionLoginMember"));
		System.out.println(session.getId()); //알수없는값
		System.out.println(orderSellVo.getFkItemDetailOrderSell()); //null
		System.out.println(orderSellVo.getOrderSellAmount()); //0
		System.out.println(orderSellVo.getOrderSellPerPrice());//0
		System.out.println(orderSellVo.getOrderSellMethod().substring(1));
		//service Test
		
/*		orderSellVo.setFkSellerOrderSell("seller");
		orderSellVo.setFkItemDetailOrderSell("배추");
		orderSellVo.setOrderSellMethod("지정가");
		orderSellVo.setOrderSellPerPrice(50000);
		orderSellVo.setOrderSellAmount(20);*/
		
		//orderSellService.insertOrderSeller(orderSellVo);
		
		return "index";
	}
}
