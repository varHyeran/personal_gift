package com.gift.futurestrading.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gift.futurestrading.admin.mapper.AdminMapper;
import com.gift.futurestrading.member.vo.ConsumerVo;
import com.gift.futurestrading.member.vo.SellerVo;
import com.gift.futurestrading.page.vo.Criteria;

@Service
public class AdminService {
	@Autowired
	private AdminMapper adminMapper;
	/*1. 구매자 리스트*/
	public List<ConsumerVo> getConsumerAll(Criteria cri){
		System.out.println("AdminService.getConsumerAll() 호출");
		List<ConsumerVo> consumerList = adminMapper.selectConsumerAll(cri);
		return consumerList;
	}
	public int selectConsumerAllCount() {
		System.out.println("SampleService.selectConsumerAllCount()");
		return adminMapper.selectConsumerAllCount();
	}
	/*1. 판매자 리스트*/
	public List<SellerVo> getSellerAll(Criteria cri){
		System.out.println("AdminService.getSellerAll() 호출");
		List<SellerVo> sellerList = adminMapper.selectSellerAll(cri);
		return sellerList;
	}
	public int selectSellerAllCount() {
		System.out.println("SampleService.selectSellerAllCount()");
		return adminMapper.selectSellerAllCount();
	}
	
	
	
}