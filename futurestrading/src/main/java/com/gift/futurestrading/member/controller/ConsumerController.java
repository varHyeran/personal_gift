package com.gift.futurestrading.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ConsumerController {
	@RequestMapping("/consumeradd")
	public String test() {
		System.out.println("출력");
		return "member/consumer/addMemberConsumer";
	}
}
