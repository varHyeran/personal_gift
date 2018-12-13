package com.gift.futurestrading.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

	@Controller
	public class SellerController {
		@RequestMapping("/selleradd")
		public String test() {
			System.out.println("출력");
			return "member/seller/addMemberSeller";
		}
		
	@Controller
	public class SellerDetailController {
		@RequestMapping("/sellerdetail")
		public String test() {
			System.out.println("출력");
			return "member/seller/addMemberSeller2";
		}
	}
}
