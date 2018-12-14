package com.gift.futurestrading.member.controller;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.gift.futurestrading.member.service.SellerService;
import com.gift.futurestrading.member.vo.ConsumerRequestVo;
import com.gift.futurestrading.member.vo.SellerRequestVo;

	@Controller
	public class SellerController {
		@Autowired
		private SellerService sellerService;
		
		
		
		@RequestMapping(value="/joinseller" , method=RequestMethod.GET)
		public String test() {
			System.out.println("출력");
			return "member/seller/addMemberSeller";
		}
		
/*	@Controller
	public class SellerDetailController {
		
		@RequestMapping("/joinsellerdetail")
		public String test() {
			System.out.println("출력");
			return "member/seller/joinsellerdetail";
		}
	}*/
		
	@RequestMapping(value="/addseller", method=RequestMethod.POST)
	public String addConsumer(SellerRequestVo sellerRequestVo) {
		System.out.println("ConsumerController.addConsumer() 호출");
		int insertResult = sellerService.insertSeller(sellerRequestVo);
		System.out.println(insertResult+" <---insertResult");
		return "index";
	}
	@RequestMapping(value = "/checkId", method = {RequestMethod.POST})
	@ResponseBody 
	public int idCheck(@RequestBody String id) {
        System.out.println("SellerController");
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
			count = sellerService.idCheck(id);
			}
		return count;
	}
}
