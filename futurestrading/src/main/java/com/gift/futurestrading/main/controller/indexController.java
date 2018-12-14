package com.gift.futurestrading.main.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class indexController {
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index(HttpSession session, Model model) {
		System.out.println("indexController.index() 호출 GET");
		String indexReturn = null;
		if(session.getAttribute("sessionLoginMember")==null) {
			indexReturn = "index";
		}else {
			indexReturn = "index";
		}
		System.out.println(session.getAttribute("sessionLoginMember"));
		model.addAttribute("sessionId", session.getAttribute("sessionLoginMember"));
		return indexReturn;
	}
}
