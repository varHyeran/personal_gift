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
	
	@RequestMapping(value="/tempt", method=RequestMethod.POST)
	@ResponseBody
	public String tempt(@RequestBody HashMap<String, Object> years) {
		System.out.println("AdminController.tempt() 호출");
		System.out.println(years.get("year1") + "<-- year1(ajax)");
		System.out.println(years.get("year2") + "<-- year2(ajax)");
		adminService.getChart(years);

		return null;
	}
	
	@RequestMapping(value="/testchart", method=RequestMethod.GET)
	public String testChart(Model model, HttpSession session) {
		System.out.println("AdminController.testChart() 호출");
		model.addAttribute("sessionLogin", session.getAttribute("sessionLoginMember"));
		return "topAdmin/getProfitDetail";
	}
	
	/** 관리자 비밀번호 확인(ajax)
	 * 수정폼의 현재 비밀번호 부분에서 관리자의 비밀번호가 일치하는지 확인한다.
	 * @param String topAdminPassword
	 * @return password
	 * @since JDK1.8
	 */
	@RequestMapping(value="/topadmin/check/admin/password", method=RequestMethod.POST)
	@ResponseBody
	public String checkAdminPassword(@RequestBody HashMap<String, Object> idAndPassword) {
		System.out.println("AdminController.checkAdminPassword() 관리자 비밀번호확인");
		System.out.println(idAndPassword.get("adminId") + "<-- adminId(ajax)");
		System.out.println(idAndPassword.get("adminPassword") + "<-- adminPassword(ajax)");
		String idResult = adminService.adminPasswordCheck(idAndPassword);
		System.out.println(idResult + "<-- idResult");
			if(idResult != null) {
				System.out.println("현재 비밀번호 일치");
				idResult = "일치";
			} else {
				System.out.println("현재 비밀번호 불일치");
				idResult = "불일치";
			}
		return idResult;
	}
	/** 최고관리자 비밀번호 확인(ajax)
	 * 최고관리자의 비밀번호를 확인한다.
	 * @param String topAdminPassword
	 * @return password
	 * @since JDK1.8
	 */
	@RequestMapping(value="/topadmin/check/password", method=RequestMethod.POST)
	@ResponseBody
	public String checkTopAdminPassword(@RequestBody String topAdminPassword) {
		System.out.println("AdminController.checkTopAdminPassword() 최고관리자 비밀번호확인");
		System.out.println(topAdminPassword + "<-- topAdminPassword");
		String password = null;
		String passwordCheck = adminService.checkTopAdmin(topAdminPassword);
			/*입력한 비밀번호와 최고관리자의 비밀번호를 비교 후 결과를 리턴*/
			if(passwordCheck != null) {
				System.out.println("최고관리자 비밀번호 일치");
				password = "일치";
			} else {
				System.out.println("최고관리자 비밀번호 불일치");
				password = "불일치";
			}
		return password;
	}
	/** 관리자 삭제액션
	 * 관리자를 삭제한다.(최고관리자는 삭제되지 않음)
	 * @param Model model, HttpSession session, String adminId
	 * @return topadmin/list/admin
	 * @since JDK1.8
	 */
	@RequestMapping(value="/topadmin/check/re", method=RequestMethod.POST)
	public String checkTopAdmin(@RequestParam(value="adminId") String adminId, HttpSession session, Model model) {
		System.out.println("AdminController.checkTopAdmin() 최고관리자 비밀번호확인, 관리자삭제");
		model.addAttribute("sessionLogin", session.getAttribute("sessionLoginMember"));
		adminService.removeAdmin(adminId);
		return "redirect:/topadmin/list/admin";
	}
	/** 최고관리자 비밀번호 확인폼
	 * 최고관리자 확인폼을 불러온다.
	 * @param Model model, HttpSession session
	 * @return topAdmin/checkTopAdmin
	 * @since JDK1.8
	 */
	@RequestMapping(value="/topadmin/check", method=RequestMethod.GET)
	public String checkTopAdmin(Model model, HttpServletRequest request, HttpSession session) {
		System.out.println("AdminController.checkTopAdmin() 최고관리자 비밀번호확인폼");
		model.addAttribute("sessionLogin", session.getAttribute("sessionLoginMember"));
		String adminId = request.getParameter("adminId");
		System.out.println(adminId + "<-- get으로 보낸 아이디");
		model.addAttribute("getAdminId", adminId);
		return "topAdmin/checkTopAdmin";
	}
	/** 관리자 수정액션
	 * 관리자 정보를 수정한다.(DB에 update)
	 * @param String adminId, String newAdminPassword, String adminName
	 * @return topadmin/list/admin
	 * @since JDK1.8
	 */
	@RequestMapping(value="/topadmin/modify/admin/re", method=RequestMethod.POST)
	public String modifyAdmin(@RequestParam(value="adminId") String adminId, @RequestParam(value="newAdminPassword") String newAdminPassword, @RequestParam(value="adminName") String adminName) {
		System.out.println("AdminController.modifyAdmin() 수정액션");
		AdminVo adminRequest = new AdminVo();
		adminRequest.setAdminId(adminId);
		adminRequest.setAdminPassword(newAdminPassword);
		adminRequest.setAdminName(adminName);
		adminService.modifyAdmin(adminRequest);
		return "redirect:/topadmin/list/admin";
	}
	/** 관리자 수정폼
	 * 관리자 정보를 수정하는 폼을 불러온다.
	 * @param Model model, HttpSession session, String adminId
	 * @return topAdmin/modifyAdmin
	 * @since JDK1.8
	 */
	@RequestMapping(value="/topadmin/modify/admin", method=RequestMethod.GET)
	public String modifyAdminForm(Model model, @RequestParam(value="adminId") String adminId, HttpSession session) {
		System.out.println("AdminController.modifyAdminForm() 수정폼");
		model.addAttribute("sessionLogin", session.getAttribute("sessionLoginMember"));
		AdminVo getAdminOneVo = adminService.getAdminOne(adminId);
		model.addAttribute("adminOne", getAdminOneVo);
		return "topAdmin/modifyAdmin";
	}
	/** 관리자 아이디중복체크(ajax)
	 * 관리자를 등록하기 전에 아이디 중복체크를 한다.
	 * @param String inputAdminId
	 * @return countId
	 * @since JDK1.8
	 */
	@RequestMapping(value="/topadmin/admin/id/check", method=RequestMethod.POST)
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
	/** 관리자 등록액션
	 * 관리자를 등록한다(DB에 insert).
	 * @param AdminVo adminVoRequest
	 * @return topadmin/list/admin
	 * @since JDK1.8
	 */
	@RequestMapping(value="/topadmin/add/admin/re", method=RequestMethod.POST)
	public String addAdmin(AdminVo adminVoRequest) {
		System.out.println("AdminController.addAdmin() 등록액션");
		adminService.addAdmin(adminVoRequest);
		return "redirect:/topadmin/list/admin";
	}
	/** 관리자 등록폼
	 * 관리자를 등록하기 위한 폼을 불러온다.
	 * @param Model model, HttpSession session
	 * @return topAdmin/addAdmin
	 * @since JDK1.8
	 */
	@RequestMapping(value="/topadmin/add/admin", method=RequestMethod.GET)
	public String addAdmin(HttpSession session, Model model) {
		System.out.println("AdminController.addAdmin() 등록폼");
		model.addAttribute("sessionLogin", session.getAttribute("sessionLoginMember"));
		return "topAdmin/addAdmin";
	}
	/** 관리자 리스트
	 * DB에 등록되어 있는 관리자들을 조회하여 리스트를 보여준다.
	 * @param Model model, HttpSession session
	 * @return topAdmin/listAdmin
	 * @since JDK1.8
	 */
	@RequestMapping(value="/topadmin/list/admin", method=RequestMethod.GET)
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
	/** 판매자 승인
	 * 판매자 서류업로드조회 후 승인하기위한 update
	 * 
	 * @return 
	 * @since JDK1.8
	 */
	@RequestMapping(value="/admin/modify/seller/right/check", method = RequestMethod.GET)
	public String modifySellerRightCheck(SellerVo sellerVo, HttpSession session, Model model) {
		System.out.println("AdminController.modifySellerRightCheck() 호출");
		model.addAttribute("sessionLogin", session.getAttribute("sessionLoginMember"));
		String sessionLoginId = (String) session.getAttribute("sessionLoginId");
		System.out.println(sessionLoginId+"<--sessionLoginId");
		sellerVo.setSellerAdmitAdmin(sessionLoginId);
		adminService.modifySellerRightCheck(sellerVo);
		return "redirect:/admin/get/seller/all";
	}
}