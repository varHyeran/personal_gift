package com.gift.futurestrading.order.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gift.futurestrading.order.service.OrderBuyService;
import com.gift.futurestrading.order.vo.OrderBuyVo;

@Controller
public class OrderBuyController {
	@Autowired
	private OrderBuyService orderBuyService;
	@RequestMapping(value="/order/buy")
	public String addOrderBuy(HttpSession session, Model model , OrderBuyVo orderBuyVo) {
		System.out.println("OrderBuyController.addOrderBuy() 호출");
		model.addAttribute("sessionLogin", session.getAttribute("sessionLoginMember"));
		/*orderBuyVo.setFkConsumerOrderBuy("id001");
		orderBuyVo.setFkItemDetailOrderBuy("goods_detail02");
		orderBuyVo.setOrderBuyMethod("지정가");
		orderBuyVo.setOrderBuyPerPrice(50000);
		orderBuyVo.setOrderBuyAmount(10);*/
		orderBuyService.addOrderBuy(orderBuyVo);
		return "index";
	}
}
