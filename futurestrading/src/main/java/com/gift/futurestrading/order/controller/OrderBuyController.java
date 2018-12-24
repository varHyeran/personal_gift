package com.gift.futurestrading.order.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gift.futurestrading.order.service.OrderBuyService;
import com.gift.futurestrading.order.vo.OrderBuyVo;

@Controller
public class OrderBuyController {
	@Autowired
	private OrderBuyService orderBuyService;

	/** 매수주문
	 * url 요청이 들어오면 구매자 주문페이지로 랜더링 해준다.
	 * 
	 * @return 
	 * @since JDK1.8
	 */
	@RequestMapping(value="/consumer/order", method=RequestMethod.GET)
	public String addConsumerOrder(HttpSession session, Model model) {
		System.out.println("OrderBuyController.addConsumerOrder() 호출");
		model.addAttribute("sessionLogin", session.getAttribute("sessionLoginMember"));
		int getClosingPriceResult = orderBuyService.getClosingPrice();
		model.addAttribute("closingPrice", getClosingPriceResult);
		System.out.println(getClosingPriceResult+"<--getClosingPriceResult");
		return "order/consumer/addMemeberConsumerOrder";
	}
	@RequestMapping(value="/order/buy")
	public String addOrderBuy(HttpSession session, Model model , OrderBuyVo orderBuyVo) {
		System.out.println("OrderBuyController.addOrderBuy() 호출");
		model.addAttribute("sessionLogin", session.getAttribute("sessionLoginMember"));
		String sessionLoginId = (String) session.getAttribute("sessionLoginId");
		orderBuyVo.setFkConsumerOrderBuy(sessionLoginId);
		System.out.println(orderBuyVo.getFkConsumerOrderBuy()+"<--구매자아이디");
		System.out.println(orderBuyVo.getFkItemDetailOrderBuy()+"<--품목코드");
		System.out.println(orderBuyVo.getOrderBuyMethod()+"<--매수방법");
		orderBuyVo.setOrderBuyPerPrice(50000);
		orderBuyVo.setOrderBuyAmount(10);
		orderBuyService.addOrderBuy(orderBuyVo);
		return "index";
	}
}
