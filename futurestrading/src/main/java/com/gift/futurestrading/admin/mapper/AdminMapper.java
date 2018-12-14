package com.gift.futurestrading.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gift.futurestrading.admin.vo.AdminVo;
import com.gift.futurestrading.member.vo.ConsumerVo;
import com.gift.futurestrading.member.vo.SellerVo;
import com.gift.futurestrading.page.vo.Criteria;
@Mapper
public interface AdminMapper {
	/*관리자 리스트*/
	List<AdminVo> selectAdmin();
	/*관리자 등록*/
	int insertAdmin(AdminVo adminVoRequest);
	/*관리자 한 명의 수정폼 불러오기*/
	AdminVo selectAdminOne(String adminId);
	/*관리자 수정*/
	int updateAdmin(AdminVo adminRequest);
	/*최고관리자 비밀번호 체크*/
	String selectTopAdminPw(String topAdminPw);
	/*관리자 삭제*/
	int deleteAdmin(String adminId);
	/*관리자 아이디 중복체크*/
	int selectInputAdminId(String inputAdminId);	
	/*구매자 리스트*/
	List<ConsumerVo> selectConsumerAll(Criteria cri);
	/*구매자 전체 행*/
	int selectConsumerAllCount();
	/*판매자 리스트*/
	List<SellerVo> selectSellerAll(Criteria cri);
	/*판매자 전체 행*/
	int selectSellerAllCount();
}
