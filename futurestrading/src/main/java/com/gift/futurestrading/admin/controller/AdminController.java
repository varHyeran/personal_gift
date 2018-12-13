package com.gift.futurestrading.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.gift.futurestrading.admin.service.AdminService;
import com.gift.futurestrading.member.vo.ConsumerVo;
import com.gift.futurestrading.member.vo.SellerVo;
import com.gift.futurestrading.page.vo.Criteria;
import com.gift.futurestrading.page.vo.PageMaker;


@Controller
public class AdminController {
	@Autowired
	private AdminService adminService;
	/*1. 구매자 리스트*/
	@GetMapping("/listConsumer")
	public String getConsumerAll(@ModelAttribute("cri") Criteria cri, Model model) {
		System.out.println("AdminController.getConsumerAll() 호출");
		List<ConsumerVo> consumerList = adminService.getConsumerAll(cri);
		model.addAttribute("consumerList", consumerList);
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(adminService.selectConsumerAllCount());
		model.addAttribute("pageMaker", pageMaker);
		return "admin/listConsumer";
	}
	/*2. 판매자 리스트*/
	@GetMapping("/listSeller")
	public String getSellerAll(@ModelAttribute("cri") Criteria cri, Model model) {
		System.out.println("AdminController.getSellerAll() 호출");
		List<SellerVo> sellerList = adminService.getSellerAll(cri);
		model.addAttribute("sellerList", sellerList);
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(adminService.selectSellerAllCount());
		model.addAttribute("pageMaker", pageMaker);
		return "admin/listSeller";
	}
}