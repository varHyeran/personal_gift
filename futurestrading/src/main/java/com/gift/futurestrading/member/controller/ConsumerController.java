// 애플리케이션 클래스
package com.gift.futurestrading.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gift.futurestrading.member.service.ConsumerService;
import com.gift.futurestrading.member.vo.ConsumerRequestVo;

@Controller
public class ConsumerController {
	@Autowired
	private ConsumerService consumerService;
	
	/**
	 * /joinconsumer로 요청이 들어왔을 때, 구매자 회원가입폼 뷰로 렌더링 해준다.
	 * 
	 * @return 해당 되는 뷰의 경로
	 * @since JDK1.8
	 */
	@RequestMapping(value="/joinconsumer", method=RequestMethod.GET)
	public String addConsumerForm() {
		System.out.println("ConsumerController.joinconsumer() 호출");
		return "member/consumer/addMemberConsumer";
	}
	
	@RequestMapping(value="/addconsumer", method=RequestMethod.POST)
	public String addConsumer(ConsumerRequestVo consumerRequestVo) {
		System.out.println("ConsumerController.addConsumer() 호출");
		int insertResult = consumerService.insertConsumer(consumerRequestVo);
		System.out.println("insertResult: "+insertResult);
		return "index";
	}
	
	
	
	
	
	
	
	
}