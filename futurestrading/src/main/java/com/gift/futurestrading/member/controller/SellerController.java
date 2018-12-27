package com.gift.futurestrading.member.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.regex.Pattern;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.gift.futurestrading.member.service.SellerService;
import com.gift.futurestrading.member.vo.SellerFileRequestVo;
import com.gift.futurestrading.member.vo.SellerRequestVo;


@Controller
public class SellerController {
	@Autowired
	private SellerService sellerService;
	
	
	/**
	 * @author Administrator
	 * addMemberSeller 요청
	 */
	@RequestMapping(value = "/joinseller", method = RequestMethod.GET)
	public String test() {
		System.out.println("출력");
		return "member/seller/addMemberConsumers";
	}
	
	/**
	 * @author Administrator
	 * sellerDetail 페이지 요청
	 */

	@RequestMapping("/joinsellerdetail")
	public String joinSellerDetail(HttpSession session, Model model) {
		System.out.println("출력");
		model.addAttribute("sessionLogin", session.getAttribute("sessionLoginMember"));
		return "member/seller/addMemberSellerDetail";
	}
	/**
	 * @author Administrator
	 * sellerDetail 페이지 요청
	 * joinsellerdetail에서 post방식 요청 처리
	 * Vo와 파일경로를 service에 보냄
	 */

	@RequestMapping("/sellerFileUpload")
	public String getSellerDetail(SellerFileRequestVo sellerFileRequestVo , HttpSession session, Model model) throws IOException {
		System.out.println("출력111");
		model.addAttribute("sessionLogin", session.getAttribute("sessionLoginMember"));
		String path = session.getServletContext().getRealPath("\\upload\\");
		String realPath =path;
		sellerService.sellerFileUpload(sellerFileRequestVo, realPath);
		return "index"; 
	} 
	
	/**
	 * @author Administrator
	 * sellerDetail 페이지 요청
	 * joinsellerdetail에서 post방식 요청 처리
	 */
	@RequestMapping(value="/seller/mypage", method=RequestMethod.GET)
	public String sellerMypage(HttpSession session, Model model) {
		String returnView = null;
		if(session.getAttribute("sessionLoginMember")==null) {
			returnView = "index";
		}else {
			returnView = "member/seller/getMemberSellerMypage";
		}
		
		model.addAttribute("sessionLogin", session.getAttribute("sessionLoginMember"));
		return returnView;
	}
	/**
	 * @author Administrator
	 * joinseller에서 회원가입 요청시 insertSeller수행 후 index리턴
	 */
	@RequestMapping(value = "/addseller", method = RequestMethod.POST)
	public String addSeller(SellerRequestVo sellerRequestVo) {
		int insertResult = sellerService.insertSeller(sellerRequestVo);
		System.out.println(insertResult + " <---insertResult");
		return "index";
	}
	/**
	 * @author Administrator
	 * Seller회원가입시 아이디 유효성을 ajax로 검사하는 코드
	 * 특수문자 , 숫자 , 중복을 체크하고 값을 반환함
	 */

	@RequestMapping(value = "/checkId", method = { RequestMethod.POST })
	@ResponseBody 
	public int idCheck(@RequestBody String id) {
		System.out.println("SellerController");
		System.out.println(id + " <---id");

		String pattern = "^[a-zA-Z0-9]*$";
		String pattern2 = "^[0-9]*$";

		int count = 1; 
		// 문자 숫자
		boolean result = Pattern.matches(pattern, id);
		// 문자만
		boolean result2 = Pattern.matches(pattern2, id);
		// 숫자만
		/*
		 * count o 사용가능 count 1 중복됨 count 2 숫자만 count 3 특수문자가 있음
		 */

		// 특수문자 있는지 확인
		if (!result) {
			System.out.println("특수문자가 포함되어 있음");
			count = 3;
			// 숫자만 있는지 확인
		} else if (result2) {
			count = 2;
		} else {
			System.out.println("완벽함");
			/* id로 중복성 체크 메소드 호출 */ 
			count = sellerService.idCheck(id);
		} 
		return count;  
	}     
	/**
	 * @author Administrator
	 * joinsellerDetail에서 계좌의 유효성을 체크하는 코드
	 * ajax로 넘어오다 보니 map으로 넘겨줌
	 */
	@RequestMapping(value = "/ajaxAccountCheck",method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public int sellerAccountCheck(@RequestBody HashMap<String , Object> ajaxValue) {
		System.out.println("SellerController / sellerAccountCheck");
		System.out.println(ajaxValue.get("sellerId") + " <---userId");     
		System.out.println(ajaxValue.get("sellerName") + " <---sellerName");
		System.out.println(ajaxValue.get("userAccountBank") + " <---userId");     
		System.out.println(ajaxValue.get("userAccountNo") + " <---sellerName");  

		int count = 1;
		count = sellerService.accountCheck(ajaxValue);
		return count; 
	}  
}
