package com.gift.futurestrading.allprice;

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
		
		/*
		 1. auto increment를 위해 데이터베이스에서 pk 이름 잘라오기.
		 2. 자동증가 숫자 생성
		 3. insert
		*/		
		String allPriceNoText = "all_price_";
		int allPriceLastNo = allPriceMapper.selectAllPriceNo();
		String allPriceNoPk = allPriceNoText + (allPriceLastNo+1);
		System.out.println("(allPriceLastNo+1) : "+(allPriceLastNo+1));
		System.out.println("allPriceLastNo : " + allPriceLastNo);
		System.out.println("allPriceNoPk :" + allPriceNoPk);
		AllPriceVo allPriceVo = new AllPriceVo();
		
		// 1. 이름
		allPriceVo.setAllPriceNoPk(allPriceNoPk);
		// 2. 품목명
		allPriceVo.setItemName(signAddAllPrice.getItemName());
		// 2. 시가
		allPriceVo.setOpeningPrice(signAddAllPrice.getOpeningPrice());
		//3. 종가
		allPriceVo.setClosingPrice(signAddAllPrice.getClosingPrice());
		//4. 최고가
		allPriceVo.setTopPrice(signAddAllPrice.getTopPrice());
		//5. 최저가
		allPriceVo.setBottomPrice(signAddAllPrice.getBottomPrice());
		
		allPriceMapper.insertAllPrice(allPriceVo);
		System.out.println("allPriceVo :" + allPriceVo);
		return 0;
	}
}
