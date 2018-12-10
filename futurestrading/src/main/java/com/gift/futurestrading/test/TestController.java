package com.gift.futurestrading.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {
	@Autowired
	private TestService testService;
	
	@RequestMapping("/cloneTest")
	public String test() {
		System.out.println("cloneTest");
		return "test/cloneTest";
	}
	
	@RequestMapping(value="/test", method=RequestMethod.GET)
	public String testSellerList(Model model) {
		System.out.println("TestController.testSellerList() 호출");
		List<SellerVo> testSellerList = testService.getSellerList();
		model.addAttribute("testSellerList", testSellerList);
		return "test/test";
	}
}
