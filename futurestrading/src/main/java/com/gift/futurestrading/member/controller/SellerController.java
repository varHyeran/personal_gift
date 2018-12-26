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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gift.futurestrading.member.service.SellerService;
import com.gift.futurestrading.member.vo.SellerAccountCheckVo;
import com.gift.futurestrading.member.vo.SellerFileRequestVo;
import com.gift.futurestrading.member.vo.SellerRequestVo;


@Controller
public class SellerController {
	@Autowired
	private SellerService sellerService;
	//test용
	@RequestMapping(value = "/joinseller", method = RequestMethod.GET)
	public String test() {
		System.out.println("출력");
		return "member/seller/addMemberSeller";
	}
	//sellerDetail 페이지 요청
	@RequestMapping("/joinsellerdetail")
	public String joinSellerDetail(HttpSession session, Model model) {
		System.out.println("출력");
		model.addAttribute("sessionLogin", session.getAttribute("sessionLoginMember"));
		return "member/seller/addMemberSellerDetail";
	}
	// joinsellerdetail 창에서 값을 받아서 이쪽으로 요청
	@RequestMapping("/sellerFileUpload")
	public String getSellerDetail(SellerFileRequestVo sellerFileRequestVo , HttpSession session, Model model) throws IOException {
		System.out.println("출력111");
		model.addAttribute("sessionLogin", session.getAttribute("sessionLoginMember"));
		//D:\gift\maven.1544422656107\futurestrading\src\main\resources\sellerFile
		String path = session.getServletContext().getRealPath("\\upload\\");
		String realPath =path;
		System.out.println(sellerFileRequestVo.getSellerId()+"pathpathpathpath");
		System.out.println(path+"pathpathpathpath");
		System.out.println(sellerFileRequestVo.getMultipartFile()+"파일옵로드");
		sellerService.sellerFileUpload(sellerFileRequestVo, realPath);
		return "index"; 
	} 
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
	//add seller 넘겨준 값 데이터 베이스 저장
	@RequestMapping(value = "/addseller", method = RequestMethod.POST)
	public String addSeller(SellerRequestVo sellerRequestVo) {
		int insertResult = sellerService.insertSeller(sellerRequestVo);
		System.out.println(insertResult + " <---insertResult");
		return "index";
	}
	//ajax 관련
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
