package com.gift.futurestrading.admin.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import com.gift.futurestrading.member.vo.SellerFileVo;
import com.gift.futurestrading.member.vo.SellerVo;
import com.gift.futurestrading.page.vo.Criteria;
import com.gift.futurestrading.page.vo.PageMaker;


@Controller
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	/*관리자 비밀번호 확인(ajax)*/
	@RequestMapping(value="/adminPwCheck", method=RequestMethod.POST)
	@ResponseBody
	public String checkAdminPw(@RequestBody HashMap<String, Object> idAndPw) {
		System.out.println("AdminController.checkAdminPw() 관리자 비밀번호확인");
		System.out.println(idAndPw.get("adminId") + "<-- adminId(ajax)");
		System.out.println(idAndPw.get("adminPw") + "<-- adminPw(ajax)");
		String idResult = adminService.adminPwCheck(idAndPw);
		System.out.println(idResult + "<-----idResult");
			if(idResult != null) {
				System.out.println("현재 비밀번호 일치");
				idResult = "일치";
			} else {
				System.out.println("현재 비밀번호 불일치");
				idResult = "불일치";
			}
		return idResult;
	}
	/*최고관리자 비밀번호 확인(ajax)*/
	@RequestMapping(value="/checkTopAdminPw", method=RequestMethod.POST)
	@ResponseBody
	public String checkTopAdminPw(@RequestBody String topAdminPw, HttpSession session, Model model) {
		System.out.println("AdminController.checkTopAdminPw() 최고관리자 비밀번호확인");
		System.out.println(topAdminPw + "<----------topAdminPw");
		model.addAttribute("sessionLogin", session.getAttribute("sessionLoginMember"));
		String pw = null;
		String topAdminPwCheck = adminService.checkTopAdmin(topAdminPw);
		System.out.println(topAdminPwCheck + "<------------------topAdminPwCheck1");
			/*입력한 비밀번호와 최고관리자의 비밀번호를 비교 후 결과를 리턴*/
			if(topAdminPwCheck != null) {
				System.out.println("최고관리자 비밀번호 일치");
				pw = "일치";
			} else {
				System.out.println("최고관리자 비밀번호 불일치");
				pw = "불일치";
			}
		return pw;
	}
	/*최고관리자 비밀번호 확인, 관리자 삭제액션*/
	@RequestMapping(value="/topAdmin/checkTopAdmin", method=RequestMethod.POST)
	public String checkTopAdmin(@RequestParam(value="topAdminPw") String topAdminPw, @RequestParam(value="adminId") String adminId, HttpSession session, Model model) {
		System.out.println("AdminController.checkTopAdmin() 최고관리자 비밀번호확인, 관리자삭제");
		model.addAttribute("sessionLogin", session.getAttribute("sessionLoginMember"));
		String topAdminPwCheck = adminService.checkTopAdmin(topAdminPw);
			/*입력한 비밀번호와 최고관리자의 비밀번호가 일치한다면 관리자를 삭제*/
		System.out.println(topAdminPwCheck + "<------------------topAdminPwCheck2");
			if(topAdminPwCheck != null) {
				System.out.println("최고관리자 비밀번호 일치");
				adminService.removeAdmin(adminId);
			} else {
				System.out.println("최고관리자 비밀번호 불일치");
			}
		return "redirect:/topAdmin/listAdmin";
	}
	/*최고관리자 비밀번호 확인폼*/
	@RequestMapping(value="/topAdmin/checkTopAdminForm", method=RequestMethod.GET)
	public String checkTopAdminForm(Model model, HttpServletRequest request, HttpSession session) {
		System.out.println("AdminController.checkTopAdminForm() 최고관리자 비밀번호확인폼");
		model.addAttribute("sessionLogin", session.getAttribute("sessionLoginMember"));
		String adminId = request.getParameter("adminId");
		System.out.println(adminId + "<--------------get으로 보낸 아이디");
		model.addAttribute("getAdminId", adminId);
		return "topAdmin/checkTopAdmin";
	}
	
	/*관리자수정액션*/
	@RequestMapping(value="/topAdmin/modifyAdminAction", method=RequestMethod.POST)
	public String modifyAdminAction(@RequestParam(value="adminId") String adminId, @RequestParam(value="newAdminPw") String newAdminPw, @RequestParam(value="adminName") String adminName, HttpSession session, Model model) {
		System.out.println("AdminController.modifyAdminAction() 수정액션");
		model.addAttribute("sessionLogin", session.getAttribute("sessionLoginMember"));
		AdminVo adminRequest = new AdminVo();
		adminRequest.setAdminId(adminId);
		adminRequest.setAdminPw(newAdminPw);
		adminRequest.setAdminName(adminName);
		adminService.modifyAdmin(adminRequest);
		return "redirect:/topAdmin/listAdmin";
	}
	/*관리자수정폼*/
	@RequestMapping(value="/topAdmin/modifyAdminForm", method=RequestMethod.GET)
	public String modifyAdminForm(Model model, @RequestParam(value="adminId") String adminId, HttpSession session) {
		System.out.println("AdminController.modifyAdminForm() 수정폼");
		model.addAttribute("sessionLogin", session.getAttribute("sessionLoginMember"));
		AdminVo getAdminOneVo = adminService.getAdminOne(adminId);
		model.addAttribute("adminOne", getAdminOneVo);
		return "topAdmin/modifyAdmin";
	}
	/*관리자 아이디중복체크(ajax)*/	
	@RequestMapping(value="/adminIdCheck", method=RequestMethod.POST)
	@ResponseBody
	public int adminIdcheck(@RequestBody String inputAdminId, HttpSession session, Model model) {
		System.out.println("AdminController.adminIdcheck() 아이디 중복체크");
		System.out.println(inputAdminId + "<---inputAdminId");
		model.addAttribute("sessionLogin", session.getAttribute("sessionLoginMember"));
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
	public String addAdminAction(AdminVo adminVoRequest, HttpSession session, Model model) {
		System.out.println("AdminController.addAdminAction() 등록액션");
		model.addAttribute("sessionLogin", session.getAttribute("sessionLoginMember"));
		adminService.addAdmin(adminVoRequest);
		return "redirect:/topAdmin/listAdmin";
	}
	/*관리자등록폼*/
	@RequestMapping(value="/topAdmin/addAdminForm", method=RequestMethod.GET)
	public String addAdminForm(HttpSession session, Model model) {
		model.addAttribute("sessionLogin", session.getAttribute("sessionLoginMember"));
		System.out.println("AdminController.addAdminForm() 등록폼");
		return "topAdmin/addAdmin";
	}
	/*관리자조회*/
	@RequestMapping(value="/topAdmin/listAdmin", method=RequestMethod.GET)
	public String listAdmin(Model model,HttpSession session) {
		System.out.println("AdminController.listAdmin() 관리자리스트");
		model.addAttribute("sessionLogin", session.getAttribute("sessionLoginMember"));
		List<AdminVo> adminList = adminService.getAdmin();
		model.addAttribute("adminList", adminList);
		return "topAdmin/listAdmin";
	}
	/** 구매자 리스트
	 * ConsumerController에서 등록한 구매자리스트를 보여준다.(Criteria, PageMaker이용해서 페이징)
	 * @param Criteria cri, Model model, HttpSession session
	 * @return admin/listConsumer
	 * @since JDK1.8
	 */
	@RequestMapping(value="/admin/get/consumer/all", method=RequestMethod.GET)
	public String getConsumerAll(@ModelAttribute("cri") Criteria cri, Model model, HttpSession session) {
		System.out.println("AdminController.getConsumerAll() 호출");
		model.addAttribute("sessionLogin", session.getAttribute("sessionLoginMember"));
		List<ConsumerVo> consumerList = adminService.getConsumerAll(cri);
		model.addAttribute("consumerList", consumerList);
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(adminService.getConsumerAllCount());
		model.addAttribute("pageMaker", pageMaker);
		return "admin/listConsumer";
	}
	/** 판매자 리스트
	 * SellerController에서 등록한 판매자리스트를 보여준다.(Criteria, PageMaker이용해서 페이징)
	 * @param Criteria cri, Model model, HttpSession session
	 * @return admin/listSeller
	 * @since JDK1.8
	 */
	@RequestMapping(value="/admin/get/seller/all", method=RequestMethod.GET)
	public String getSellerAll(@ModelAttribute("cri") Criteria cri, Model model, HttpSession session) {
		System.out.println("AdminController.getSellerAll() 호출");
		model.addAttribute("sessionLogin", session.getAttribute("sessionLoginMember"));
		List<SellerVo> sellerList = adminService.getSellerAll(cri);
		model.addAttribute("sellerList", sellerList);
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(adminService.getSellerAllCount());
		model.addAttribute("pageMaker", pageMaker);
		return "admin/listSeller";
	}
	/** 구매자계좌조회
	 * 구매자 리스트에서 상세 버튼 누르면 그 아이디에 해당하는 회원의 계좌를 조회
	 * @param Model model, ConsumerVo consumerVo, HttpSession session
	 * @return admin/getConsumer
	 * @since JDK1.8
	 */
	@RequestMapping(value="/admin/get/consumer/account/one", method = RequestMethod.GET)
	public String getConsumerAccountOne(Model model, ConsumerVo consumerVo, HttpSession session) {
		System.out.println("AdminController.getConsumerAccount() 호출");
		model.addAttribute("sessionLogin", session.getAttribute("sessionLoginMember"));
		AccountConsumerVo accountConsumer = adminService.getConsumerAccountOne(consumerVo);
		System.out.println(accountConsumer+"<--accountConsumer");
		model.addAttribute("accountConsumer", accountConsumer);
		return "admin/getConsumer";
	}
	/** 판매자서류조회
	 * 판매자 리스트에서 상세 버튼 누르면 그 아이디에 해당하는 회원이 올린 서류명을 볼 수 있다.(서류명 누르면 DocumentDownloadController통해서 다운로드)
	 * @param Model model, SellerVo sellerVo, HttpSession session
	 * @return admin/getSeller
	 * @since JDK1.8
	 */
	@RequestMapping(value="/admin/get/seller/document/one", method = RequestMethod.GET)
	public String getSellerDocumentOne(Model model, SellerVo sellerVo, HttpSession session) {
		System.out.println("AdminController.getSellerDocumentOne() 호출");
		model.addAttribute("sessionLogin", session.getAttribute("sessionLoginMember"));
		SellerFileVo sellerFile = adminService.getSellerDocumentOne(sellerVo);
		System.out.println(sellerFile+"<--sellerFile");
		model.addAttribute("sellerFile", sellerFile);
		return "admin/getSeller";
	}
}