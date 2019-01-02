package com.gift.futurestrading.admin.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gift.futurestrading.admin.vo.AdminVo;
import com.gift.futurestrading.member.vo.AccountConsumerVo;
import com.gift.futurestrading.member.vo.ConsumerVo;
import com.gift.futurestrading.member.vo.SellerFileVo;
import com.gift.futurestrading.member.vo.SellerVo;
import com.gift.futurestrading.page.vo.Criteria;
@Mapper
public interface AdminMapper {
	String selectChart(HashMap<String, Object> years);
	/*관리자 비밀번호 체크*/
	String selectAdminPassword(HashMap<String, Object> idAndPassword);
	/*관리자 리스트*/
	List<AdminVo> selectAdmin();
	/*관리자 등록*/
	int insertAdmin(AdminVo adminVoRequest);
	/*관리자 한 명의 수정폼 불러오기*/
	AdminVo selectAdminOne(String adminId);
	/*관리자 수정*/
	int updateAdmin(AdminVo adminRequest);
	/*최고관리자 비밀번호 체크*/
	String selectTopAdminPassword(String topAdminPassword);
	/*관리자 삭제*/
	int deleteAdmin(String adminId);
	/*관리자 아이디 중복체크*/
	int selectInputAdminId(String inputAdminId);	
	/*구매자리스트(페이징포함)를 조회하기 위한 select*/
	List<ConsumerVo> selectConsumerAll(Criteria cri);
	/*구매자의 전체 행 구하기위한 select*/
	int selectConsumerAllCount();
	/*판매자리스트(페이징포함)를 조회하기 위한 select*/
	List<SellerVo> selectSellerAll(Criteria cri);
	/*판매자의 전체 행 구하기위한 select*/
	int selectSellerAllCount();
	/*구매자 계좌조회(한명)하기위한 select*/
	AccountConsumerVo selectConsumerAccountOne(ConsumerVo consumerVo);
	/*판매자 서류업로드조회(한명)하기위한 select*/
	SellerFileVo selectSellerDocumentOne(SellerVo sellerVo);
	/*판매자 서류업로드조회 후 승인하기위한 update*/
	int updateSellerRightCheck(HashMap<String, Object> map);
}
