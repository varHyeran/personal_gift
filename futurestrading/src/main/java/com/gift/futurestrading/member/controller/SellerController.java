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
/**
 * @author 정진우
 * @ClassName : SellerController
 * @Version : JDK1.8
 * @LatestUpdate : 2018-12-28
 * seller 가입 , 정보수정 , 상세파일 업로드 , 가입 시 필요한 ajax 요청등을 수행
 */

@Controller
public class SellerController {
	@Autowired
	private SellerService sellerService;
	
	
	/**
	 * @author 정진우
	 * addseller 요청
	 * 회원가입 초기 화면
	 * @param : 
	 * @return : member/seller/addMemberSeller
	 * 
	 */
	@RequestMapping(value="/signup/addseller", method = RequestMethod.GET)
	public String addSellerForm() {
		System.out.println("SellerController / addSellerForm() 호출");
		return "member/seller/addMemberSeller";
	}
	/**
	 * @author 정진우
	 * addrSeller 요청
	 * 고객(사용자)가 가입 정보 입력 후 회원 가입 요청 
	 * @param : sellerRequestVo
	 * @return : index
	 * 
	 */
	@RequestMapping(value = "/signup/addseller/re", method = RequestMethod.POST)
	public String addSeller(SellerRequestVo sellerRequestVo) {
		int insertResult = sellerService.insertSeller(sellerRequestVo);
		System.out.println(insertResult + " <---insertResult");
		return "index";
	}
	
	/**
	 * @author 정진우
	 * addSellerDetail 요청
	 * 판매자 정보 상세입력 화면 요처잇 렌더링
	 * @param : HttpSession , Model
	 * @return : member/seller/addMemberSellerDetail
	 * 
	 */
	@RequestMapping("/signup/addseller/detail")
	public String addSellerDetail(HttpSession session, Model model) {
		System.out.println("SellerController / addSellerDetail");
		model.addAttribute("sessionLogin", session.getAttribute("sessionLoginMember"));
		return "member/seller/addMemberSellerDetail";
	}
	
	/**
	 * @author 정진우
	 * addSellerDetail 요청
	 * action 및 서브스 호출
	 * @param : SellerFileRequestVo , HttpSession
	 * @return : member/seller/index
	 * 
	 */
	@RequestMapping("/signup/addseller/detail/re")
	public String addSellerDetailAction(SellerFileRequestVo sellerFileRequestVo , HttpSession session, Model model) throws IOException {
		System.out.println("SellerController/ addSellerDetailAction");
		model.addAttribute("sessionLogin", session.getAttribute("sessionLoginMember"));
		String path = session.getServletContext().getRealPath("\\upload\\");
		sellerService.sellerFileUpload(sellerFileRequestVo, path);
		return "index"; 
	} 
	
	/**
	 * @author 정진우
	 * sellerMypage 요청
	 * mypage를 요청했을때 세션값의 유무에따라 화면 결정
	 * @param : HttpSession , Model
	 * @return : member/seller/addMemberSeller
	 * 
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
	 * @author 정진우
	 * idCheck 요청
	 * ajax 비동기적 요청
	 * 데이터베이스 확인후 중복 여부 리턴
	 * @param : String
	 * @return : count
	 * 
	 */
	@RequestMapping(value = "/checkId", method = { RequestMethod.POST })
	@ResponseBody 
	public int checkId(@RequestBody String id) {
		System.out.println("SellerController / checkId");
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
	 * @author 정진우
	 * sellerAccountCheck 요청
	 * ajax비동기적 요청 
	 * 데이터 베이스 확인 후  가능여부 리턴
	 * @param : HashMap<String , Object>
	 * @return : count
	 * 
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
