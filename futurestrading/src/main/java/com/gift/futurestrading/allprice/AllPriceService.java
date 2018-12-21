package com.gift.futurestrading.allprice;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AllPriceService {
	
	@Autowired
	private AllPriceMapper allPriceMapper;

	/* 품목별 시가,종가,최고가,최저가 테이블 insert*/
	public int addAllPrice() {
		System.out.println("AllPriceService.addAllPrice() 호출");

		/*실행되는 시간을 기준으로 1시간 사이의 모든 체결 리스트*/
		AllPriceVo signAddAllPrice = allPriceMapper.selectSignAddAllPrice();
		System.out.println(signAddAllPrice.getItemName());		//품목명
		System.out.println(signAddAllPrice.getOpeningPrice());	//시가
		System.out.println(signAddAllPrice.getClosingPrice());	//종가
		System.out.println(signAddAllPrice.getTopPrice());		//최고가
		System.out.println(signAddAllPrice.getBottomPrice());	//최저가
		System.out.println(signAddAllPrice.getAllPriceDate());	//날짜
		
		//allPriceMapper.insertAllPrice(allPriceVo);
		return 0;
	}
}
