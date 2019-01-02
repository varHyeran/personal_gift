package com.gift.futurestrading.order.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gift.futurestrading.order.service.OrderBuyService;
import com.gift.futurestrading.order.vo.OrderBuyListVo;
import com.gift.futurestrading.order.vo.OrderBuyVo;
import com.gift.futurestrading.page.vo.Criteria;
import com.gift.futurestrading.page.vo.PageMaker;

@Controller
public class OrderBuyController {
	@Autowired
	private OrderBuyService orderBuyService;

	/** 매수주문폼
	 * url 요청이 들어오면 구매자 주문페이지로 랜더링 해준다.
	 * @param HttpSession session, Model model, OrderBuyVo orderBuyVo
	 * @return order/consumer/addMemeberConsumerOrder
	 * @throws IOException 
	 * @since JDK1.8
	 */
	@RequestMapping(value="/consumer/add/order", method=RequestMethod.GET)
	public String addConsumerOrder(@ModelAttribute("cri") Criteria cri, HttpSession session, Model model, OrderBuyVo orderBuyVo, HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("OrderBuyController.addConsumerOrder() 호출");
		/*로그인 전과 후로 나뉨*/
		if(session.getAttribute("sessionLoginMember")==null) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('로그인 후 이용가능합니다.'); history.go(-1);</script>");
			out.flush();
		}else {
			/*회원별 리스트 가져옴 페이징완료*/
			model.addAttribute("sessionLogin", session.getAttribute("sessionLoginMember"));
			String sessionLoginId = (String) session.getAttribute("sessionLoginId");
			List<OrderBuyListVo> getOrderBuyList = orderBuyService.getOrderBuyList(sessionLoginId, cri);
			System.out.println(getOrderBuyList+"<--getOrderBuyList");
			model.addAttribute("orderBuyList", getOrderBuyList);
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(orderBuyService.getOrderBuyAllConut(sessionLoginId));
			model.addAttribute("pageMaker", pageMaker);
			/*종가가져옴*/
			int getClosingPriceResult = orderBuyService.getClosePriceItemOne();
			model.addAttribute("closingPrice", getClosingPriceResult);
			System.out.println(getClosingPriceResult+"<--getClosingPriceResult");	
		}
		
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
		return "redirect:/consumer/add/order";
	}
}
