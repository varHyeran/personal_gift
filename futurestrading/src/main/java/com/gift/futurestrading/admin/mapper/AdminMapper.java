package com.gift.futurestrading.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gift.futurestrading.member.vo.ConsumerVo;
import com.gift.futurestrading.member.vo.SellerVo;
import com.gift.futurestrading.page.vo.Criteria;
@Mapper
public interface AdminMapper {
	/*구매자 리스트*/
	List<ConsumerVo> selectConsumerAll(Criteria cri);
	/*구매자 전체 행*/
	int selectConsumerAllCount();
	/*판매자 리스트*/
	List<SellerVo> selectSellerAll(Criteria cri);
	/*판매자 전체 행*/
	int selectSellerAllCount();
	
	
}
