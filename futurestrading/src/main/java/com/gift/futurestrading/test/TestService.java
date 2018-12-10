package com.gift.futurestrading.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {
	
	@Autowired
	private TestMapper testMapper;
	
	public List<SellerVo> getSellerList(){
		System.out.println("TestService.getSellerList() 호출");
		List<SellerVo> sellerList = testMapper.selectSeller();
		return sellerList;
	};
}
