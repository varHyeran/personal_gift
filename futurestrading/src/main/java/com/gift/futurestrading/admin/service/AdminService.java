package com.gift.futurestrading.admin.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gift.futurestrading.admin.mapper.AdminMapper;
import com.gift.futurestrading.admin.vo.AdminVo;
import com.gift.futurestrading.member.vo.AccountConsumerVo;
import com.gift.futurestrading.member.vo.ConsumerVo;
import com.gift.futurestrading.member.vo.SellerFileVo;
import com.gift.futurestrading.member.vo.SellerVo;
import com.gift.futurestrading.page.vo.Criteria;

@Service
public class AdminService {
	@Autowired
	private AdminMapper adminMapper;
	
	/*관리자 비밀번호체크*/
	public String adminPwCheck(HashMap<String, Object> idAndPw) {
		System.out.println("AdminService.adminPwCheck() 호출");
		String idResult = adminMapper.selectAdminPw(idAndPw);
		return idResult;
	}
	/*관리자삭제처리*/
	public void removeAdmin(String adminId) {
		System.out.println("AdminService.removeAdmin() 호출");
		adminMapper.deleteAdmin(adminId);
	}
	/*최고관리자 비밀번호체크*/
	public String checkTopAdmin(String topAdminPw) {
		System.out.println("AdminService.checkTopAdmin() 호출");
		String topAdminPwCheck = adminMapper.selectTopAdminPw(topAdminPw);
		return topAdminPwCheck;
	}
	/*관리자수정처리*/
	public void modifyAdmin(AdminVo adminRequest) {
		System.out.println("AdminService.modifyAdmin() 호출");
		adminMapper.updateAdmin(adminRequest);
	}
	/*관리자수정화면*/
	public AdminVo getAdminOne(String adminId) {
		System.out.println("AdminService.getAdminOne() 호출");
		AdminVo getAdminOneVo = adminMapper.selectAdminOne(adminId);
		return getAdminOneVo;
	}
	/*관리자등록*/
	public void addAdmin(AdminVo adminVoRequest) {
		System.out.println("AdminService.addAdmin() 호출");
		AdminVo adminVo = new AdminVo();
		adminVo.setAdminId(adminVoRequest.getAdminId());
		adminVo.setAdminPw(adminVoRequest.getAdminPw());
		adminVo.setAdminName(adminVoRequest.getAdminName());
		adminMapper.insertAdmin(adminVoRequest);
	}
	/*관리자 아이디중복체크*/
	public int inputIdcheck(String inputAdminId) {
		System.out.println("AdminService.inputIdcheck() 호출");
		int countId = adminMapper.selectInputAdminId(inputAdminId);
		return countId;
	}
	/*관리자조회*/
	public List<AdminVo> getAdmin(){
		System.out.println("AdminService.getAdmin() 호출");
		List<AdminVo> adminList = adminMapper.selectAdmin();
		return adminList;
	}
	/** 구매자 리스트
	 * 구매자 리스트 select
	 * @param Criteria cri
	 * @return consumerList
	 * @since JDK1.8
	 */
	public List<ConsumerVo> getConsumerAll(Criteria cri){
		System.out.println("AdminService.getConsumerAll() 호출");
		List<ConsumerVo> consumerList = adminMapper.selectConsumerAll(cri);
		return consumerList;
	}
	/** 구매자 리스트
	 * 구매자 전체 행 갯수 select
	 * 
	 * @return adminMapper.selectConsumerAllCount()
	 * @since JDK1.8
	 */
	public int getConsumerAllCount() {
		System.out.println("SampleService.selectConsumerAllCount() 호출");
		return adminMapper.selectConsumerAllCount();
	}
	/** 판매자 리스트
	 * 판매자 리스트 select
	 * @param Criteria cri
	 * @return sellerList
	 * @since JDK1.8
	 */
	public List<SellerVo> getSellerAll(Criteria cri){
		System.out.println("AdminService.getSellerAll() 호출");
		List<SellerVo> sellerList = adminMapper.selectSellerAll(cri);
		return sellerList;
	}
	/** 판매자 리스트
	 * 판매자의 전체 행 구하기위한 select
	 * 
	 * @return adminMapper.selectSellerAllCount()
	 * @since JDK1.8
	 */
	public int getSellerAllCount() {
		System.out.println("SampleService.selectSellerAllCount() 호출");
		return adminMapper.selectSellerAllCount();
	}
	/** 구매자 계좌조회
	 * 구매자 계좌조회(한명)하기위한 select
	 * 
	 * @return accountConsumer
	 * @since JDK1.8
	 */
	public AccountConsumerVo getConsumerAccountOne(ConsumerVo consumerVo) {
		System.out.println("SampleService.getConsumerAccount() 호출");
		AccountConsumerVo accountConsumer = adminMapper.selectConsumerAccountOne(consumerVo);
		return accountConsumer;
	}
	/** 판매자 서류업로드조회
	 * 판매자 서류업로드조회(한명)하기위한 select
	 * 
	 * @return sellerFile
	 * @since JDK1.8
	 */
	public SellerFileVo getSellerDocumentOne(SellerVo sellerVo) {
		System.out.println("SampleService.getSellerDocumentOne() 호출");
		SellerFileVo sellerFile = adminMapper.selectSellerDocumentOne(sellerVo);
		return sellerFile;
		
	}
}