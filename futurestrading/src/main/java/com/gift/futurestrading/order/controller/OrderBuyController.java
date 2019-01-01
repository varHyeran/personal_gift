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

	/** 매수주문폼
	 * url 요청이 들어오면 구매자 주문페이지로 랜더링 해준다.
	 * @param HttpSession session, Model model, OrderBuyVo orderBuyVo
	 * @return order/consumer/addMemeberConsumerOrder
	 * @since JDK1.8
	 */
	@RequestMapping(value="/consumer/add/order", method=RequestMethod.GET)
	public String addConsumerOrder(HttpSession session, Model model, OrderBuyVo orderBuyVo) {
		System.out.println("OrderBuyController.addConsumerOrder() 호출");
		model.addAttribute("sessionLogin", session.getAttribute("sessionLoginMember"));
		
		/*종가가져옴*/
		int getClosingPriceResult = orderBuyService.getClosePriceItemOne();
		model.addAttribute("closingPrice", getClosingPriceResult);
		System.out.println(getClosingPriceResult+"<--getClosingPriceResult");
		return "order/consumer/addMemeberConsumerOrder";
	}
	/** 매수주문액션
	 * 주문실행됨
	 * @param HttpSession session, Model model, OrderBuyVo orderBuyVo
	 * @return index
	 * @since JDK1.8
	 */
	@RequestMapping(value="consumer/add/order/re", method=RequestMethod.POST)
	public String addOrderBuy(HttpSession session, Model model , OrderBuyVo orderBuyVo) {
		System.out.println("OrderBuyController.addOrderBuy() 호출");
		model.addAttribute("sessionLogin", session.getAttribute("sessionLoginMember"));
		
		/*세션의 아이디 가져옴*/
		String sessionLoginId = (String) session.getAttribute("sessionLoginId");
		orderBuyVo.setFkConsumerOrderBuy(sessionLoginId);
		System.out.println(orderBuyVo.getFkConsumerOrderBuy()+"<--orderBuyVo.getFkConsumerOrderBuy()");
		System.out.println(orderBuyVo.getFkItemDetailOrderBuy()+"<--orderBuyVo.getFkItemDetailOrderBuy()");
		System.out.println(orderBuyVo.getOrderBuyMethod()+"<--orderBuyVo.getOrderBuyMethod()");	
		System.out.println(orderBuyVo.getOrderBuyPerPrice()+"<--orderBuyVo.getOrderBuyPerPrice()");	
		System.out.println(orderBuyVo.getOrderBuyAmount()+"<--orderBuyVo.getOrderBuyAmount()");
		orderBuyService.addOrderBuy(orderBuyVo);
		return "index";
	}
}
