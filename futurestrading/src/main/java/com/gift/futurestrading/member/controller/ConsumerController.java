// 애플리케이션 클래스
package com.gift.futurestrading.member.controller;

import java.util.regex.Pattern;

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
	@RequestMapping(value="/idcheck", method=RequestMethod.POST)	
	@ResponseBody
	public int idCheck(@RequestBody String id) {
		System.out.println("ConsumerController.idCheck() 호출");
		System.out.println(id+" <---id");
		
		String pattern = "^[a-zA-Z0-9]*$"; 
		String pattern2 = "^[0-9]*$"; 
		
		int count = 1;
			//문자 숫자
		 boolean result = Pattern.matches(pattern, id);
		 	//문자만
		 boolean result2  = Pattern.matches(pattern2, id);
		 	//숫자만
		/*
		 * count o 사용가능
		  count 1 중복됨
		  count 2  숫자만
		  count 3 특수문자가 있음
		 */
		 
		 // 특수문자 있는지 확인
		 if(!result) {
			 System.out.println("특수문자가 포함되어 있음");
			 count = 3; 
			// 숫자만 있는지 확인
		 }else if(result2) {
			 	count = 2 ;				
		}else{
			System.out.println("완벽함");
			/* id로 중복성 체크 메소드 호출*/
			count = consumerService.idCheck(id);
			}
		return count;
	}

	
}