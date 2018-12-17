package com.gift.futurestrading.admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gift.futurestrading.admin.service.AdminService;
import com.gift.futurestrading.admin.vo.AdminVo;
import com.gift.futurestrading.member.vo.AccountConsumerVo;
import com.gift.futurestrading.member.vo.ConsumerVo;
import com.gift.futurestrading.member.vo.SellerVo;
import com.gift.futurestrading.page.vo.Criteria;
import com.gift.futurestrading.page.vo.PageMaker;


@Controller
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	/*최고관리자 비밀번호 확인, 관리자 삭제액션*/
	@RequestMapping(value="/topAdmin/checkTopAdmin", method=RequestMethod.POST)
	public String checkTopAdmin(@RequestParam(value="topAdminPw") String topAdminPw, @RequestParam(value="adminId") String adminId) {
		System.out.println("AdminController.checkTopAdmin() 최고관리자 비밀번호확인, 관리자삭제");
		String topAdminPwCheck = adminService.checkTopAdmin(topAdminPw);
			/*입력한 비밀번호와 최고관리자의 비밀번호가 일치한다면 관리자를 삭제*/
			if(topAdminPw.equals(topAdminPwCheck)) {
				System.out.println("최고관리자 비밀번호 일치");
				adminService.removeAdmin(adminId);
			} else {
				System.out.println("최고관리자 비밀번	호 불일치");
			}
		return "redirect:/topAdmin/listAdmin";
	}
	/*최고관리자 비밀번호 확인폼*/
	@RequestMapping(value="/topAdmin/checkTopAdminForm", method=RequestMethod.GET)
	public String checkTopAdminForm(Model model, HttpServletRequest request) {
		System.out.println("AdminController.checkTopAdminForm() 최고관리자 비밀번호확인폼");
		String adminId = request.getParameter("adminId");
		System.out.println(adminId + "<--------------get으로 보낸 아이디");
		model.addAttribute("getAdminId", adminId);
		return "topAdmin/checkTopAdmin";
	}
	
	/*관리자수정액션*/
	@RequestMapping(value="/topAdmin/modifyAdminAction", method=RequestMethod.POST)
	public String modifyAdminAction(@RequestParam(value="adminId") String adminId, @RequestParam(value="adminPw") String adminPw, @RequestParam(value="adminName") String adminName) {
		System.out.println("AdminController.modifyAdminAction() 수정액션");
		AdminVo adminRequest = new AdminVo();
		adminRequest.setAdminId(adminId);
		adminRequest.setAdminPw(adminPw);
		adminRequest.setAdminName(adminName);
		adminService.modifyAdmin(adminRequest);
		return "redirect:/topAdmin/listAdmin";
	}
	/*관리자수정폼*/
	@RequestMapping(value="/topAdmin/modifyAdminForm", method=RequestMethod.GET)
	public String modifyAdminForm(Model model, @RequestParam(value="adminId") String adminId) {
		System.out.println("AdminController.modifyAdminForm() 수정폼");
		AdminVo getAdminOneVo = adminService.getAdminOne(adminId);
		model.addAttribute("adminOne", getAdminOneVo);
		return "topAdmin/modifyAdmin";
	}
	/*관리자 아이디중복체크*/	
	@RequestMapping(value="/adminIdCheck", method=RequestMethod.POST)
	@ResponseBody
	public int adminIdcheck(@RequestBody String inputAdminId) {
		System.out.println("AdminController.adminIdcheck() 아이디 중복체크");
		System.out.println(inputAdminId + "<---inputAdminId");
		int countId = adminService.inputIdcheck(inputAdminId);
			if(countId == 1) {
				System.out.println("중복 아이디 존재");
				countId = 1;
			} else {
				System.out.println("사용 가능한 아이디");
				countId = 0;
			}
		System.out.println(countId+"<---countId");	
		return countId;
	}
	/*관리자등록액션*/
	@RequestMapping(value="/topAdmin/addAdminAction", method=RequestMethod.POST)
	public String addAdminAction(AdminVo adminVoRequest) {
		System.out.println("AdminController.addAdminAction() 등록액션");
		adminService.addAdmin(adminVoRequest);
		return "redirect:/topAdmin/listAdmin";
	}
	/*관리자등록폼*/
	@RequestMapping(value="/topAdmin/addAdminForm", method=RequestMethod.GET)
	public String addAdminForm() {
		System.out.println("AdminController.addAdminForm() 등록폼");
		return "topAdmin/addAdmin";
	}
	/*관리자조회*/
	@RequestMapping(value="/topAdmin/listAdmin", method=RequestMethod.GET)
	public String listAdmin(Model model) {
		System.out.println("AdminController.listAdmin() 관리자리스트");
		List<AdminVo> adminList = adminService.getAdmin();
		model.addAttribute("adminList", adminList);
		return "topAdmin/listAdmin";
	}
	/*구매자 리스트*/
	@RequestMapping(value="/listConsumer", method=RequestMethod.GET)
	public String getConsumerAll(@ModelAttribute("cri") Criteria cri, Model model) {
		System.out.println("AdminController.getConsumerAll() 호출");
		List<ConsumerVo> consumerList = adminService.getConsumerAll(cri);
		model.addAttribute("consumerList", consumerList);
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(adminService.getConsumerAllCount());
		model.addAttribute("pageMaker", pageMaker);
		return "admin/listConsumer";
	}
	/*판매자 리스트*/
	@RequestMapping(value="/listSeller", method=RequestMethod.GET)
	public String getSellerAll(@ModelAttribute("cri") Criteria cri, Model model) {
		System.out.println("AdminController.getSellerAll() 호출");
		List<SellerVo> sellerList = adminService.getSellerAll(cri);
		model.addAttribute("sellerList", sellerList);
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(adminService.getSellerAllCount());
		model.addAttribute("pageMaker", pageMaker);
		return "admin/listSeller";
	}
	/*구매자계좌조회*/
	@RequestMapping(value="/getConsumer", method = RequestMethod.GET)
	public String getConsumerAccount(Model model, ConsumerVo consumerVo) {
		System.out.println("AdminController.getConsumerAccount() 호출");
		AccountConsumerVo accountConsumer = adminService.getConsumerAccount(consumerVo);
		System.out.println(accountConsumer+"<--accountConsumer");
		model.addAttribute("accountConsumer", accountConsumer);
		return "admin/getConsumer";
	}
}