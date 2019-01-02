package com.gift.futurestrading.admin.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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
	
	public String getChart(HashMap<String, Object> years) {
		System.out.println("AdminService.getChart() 호출");
		adminMapper.selectChart(years);
		return null;
	}
	
	/** 관리자 비밀번호확인
	 * 관리자 비밀번호 select
	 * @param HashMap<String, Object> idAndPassword
	 * @return idResult
	 * @since JDK1.8
	 */
	public String adminPasswordCheck(HashMap<String, Object> idAndPassword) {
		System.out.println("AdminService.adminPasswordCheck() 호출");
		String idResult = adminMapper.selectAdminPassword(idAndPassword);
		return idResult;
	}
	/** 관리자 삭제
	 * 관리자 정보 delete
	 * @param String adminId
	 * @since JDK1.8
	 */
	public void removeAdmin(String adminId) {
		System.out.println("AdminService.removeAdmin() 호출");
		adminMapper.deleteAdmin(adminId);
	}
	/** 최고관리자 비밀번호확인
	 * 최고관리자 비밀번호 select
	 * @param String topAdminPassword
	 * @return passwordCheck
	 * @since JDK1.8
	 */
	public String checkTopAdmin(String topAdminPassword) {
		System.out.println("AdminService.checkTopAdmin() 호출");
		String passwordCheck = adminMapper.selectTopAdminPassword(topAdminPassword);
		return passwordCheck;
	}
	/** 관리자 수정처리
	 * 관리자 수정 update
	 * @param AdminVo adminRequest
	 * @since JDK1.8
	 */
	public void modifyAdmin(AdminVo adminRequest) {
		System.out.println("AdminService.modifyAdmin() 호출");
		adminMapper.updateAdmin(adminRequest);
	}
	/** 관리자 수정폼
	 * 관리자 수정폼 관련 select
	 * @param String adminId
	 * @return getAdminOneVo
	 * @since JDK1.8
	 */
	public AdminVo getAdminOne(String adminId) {
		System.out.println("AdminService.getAdminOne() 호출");
		AdminVo getAdminOneVo = adminMapper.selectAdminOne(adminId);
		return getAdminOneVo;
	}
	/** 관리자 등록
	 * 관리자 insert
	 * @param AdminVo adminVoRequest
	 * @since JDK1.8
	 */
	public void addAdmin(AdminVo adminVoRequest) {
		System.out.println("AdminService.addAdmin() 호출");
		AdminVo adminVo = new AdminVo();
		adminVo.setAdminId(adminVoRequest.getAdminId());
		adminVo.setAdminPassword(adminVoRequest.getAdminPassword());
		adminVo.setAdminName(adminVoRequest.getAdminName());
		adminMapper.insertAdmin(adminVoRequest);
	}
	/** 관리자 아이디중복체크
	 * 관리자 아이디 select
	 * @param String inputAdminId
	 * @return countId
	 * @since JDK1.8
	 */
	public int inputIdcheck(String inputAdminId) {
		System.out.println("AdminService.inputIdcheck() 호출");
		int countId = adminMapper.selectInputAdminId(inputAdminId);
		return countId;
	}
	/** 관리자 리스트
	 * 관리자 리스트 select
	 * @return adminList
	 * @since JDK1.8
	 */
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
		System.out.println("AdminService.selectConsumerAllCount() 호출");
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
		System.out.println("AdminService.selectSellerAllCount() 호출");
		return adminMapper.selectSellerAllCount();
	}
	/** 구매자 계좌조회
	 * 구매자 계좌조회(한명)하기위한 select
	 * 
	 * @return accountConsumer
	 * @since JDK1.8
	 */
	public AccountConsumerVo getConsumerAccountOne(ConsumerVo consumerVo) {
		System.out.println("AdminService.getConsumerAccount() 호출");
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
		System.out.println("AdminService.getSellerDocumentOne() 호출");
		SellerFileVo sellerFile = adminMapper.selectSellerDocumentOne(sellerVo);
		return sellerFile;	
	}
	/** 판매자 승인
	 * 판매자 서류업로드조회 후 승인하기위한 update
	 * 
	 * @return 
	 * @since JDK1.8
	 */
	public int modifySellerRightCheck(SellerVo sellerVo) {
		System.out.println("AdminService.modifySellerRightCheck() 호출");
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("sellerIdPk", sellerVo.getSellerIdPk());
		System.out.println(sellerVo.getSellerIdPk()+"<--sellerVo.getSellerIdPk()");
		map.put("adminIdPk", sellerVo.getSellerAdmitAdmin());
		System.out.println(sellerVo.getSellerAdmitAdmin()+"<--sellerVo.getSellerAdmitAdmin()");
 		int sellerCheck = adminMapper.updateSellerRightCheck(map);
		return sellerCheck;
	}
}