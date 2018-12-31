package com.gift.futurestrading.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageNotFoundController {
	@RequestMapping(value="/sorry", method=RequestMethod.GET)
	public String pageNotFound() {
		System.out.println("PageNotFoundController/  호출 GET");
		return "pageNotFound";
	}
}
