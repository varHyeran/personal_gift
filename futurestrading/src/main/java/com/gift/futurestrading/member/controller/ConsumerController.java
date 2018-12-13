// 애플리케이션 클래스
package com.gift.futurestrading.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gift.futurestrading.member.service.ConsumerService;
import com.gift.futurestrading.member.vo.ConsumerRequestVo;

@Controller
public class ConsumerController {
	@Autowired
	private ConsumerService consumerService;
	
	/**
	 * 해당 url로 요청이 들어왔을 때, 구매자 회원가입폼 뷰로 렌더링 해준다.
	 * 
	 * @return 해당 되는 뷰의 경로
	 * @since JDK1.8
	 */
	@RequestMapping(value="/joinconsumer", method=RequestMethod.GET)
	public String addConsumerForm() {
		System.out.println("ConsumerController.joinconsumer() 호출");
		return "member/consumer/addMemberConsumer";
	}
	
	/**
	 * addMemberConsumer.html(구매자 회원가입)에서 데이터를 VO에 받아 service 계층의 메서드를 호출할 때 param으로 넘겨준다.
	 * 
	 * @param consumerRequestVo
	 * @return
	 * @since JDK1.8
	 */
	@RequestMapping(value="/addconsumer", method=RequestMethod.POST)
	public String addConsumer(ConsumerRequestVo consumerRequestVo) {
		System.out.println("ConsumerController.addConsumer() 호출");
		int insertResult = consumerService.insertConsumer(consumerRequestVo);
		System.out.println(insertResult+" <---insertResult");
		return "index";
	}
	
	/**
	 * 아이디 중복체크를 위해 화면에서 받아온 id 값을 param에 넣어 service 계층의 메서드를 호출할 때 넘겨준다.
	 * ResponseBody 어노테이션: 메소드에서 리턴되는 값이 뷰를 통해서 출력되지 않고 HTTP Response Body 에 직접 쓰여지게 된다.
	 * 
	 * @param id
	 * @return
	 * @since JDK1.8
	 */
	@RequestMapping(value="/idchcek", method=RequestMethod.POST)	
	@ResponseBody
	public int idCheck(@RequestBody String id) {
		System.out.println("ConsumerController.idCheck() 호출");
		System.out.println(id+" <---id");
		int count = 0;
	
		/* 서비스 계층의 메서드 호출 */
		count = consumerService.idCheck(id);			
		return count;
	}

	
}