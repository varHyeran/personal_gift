package com.gift.futurestrading.allprice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gift.futurestrading.allprice.mapper.AllPriceMapper;
import com.gift.futurestrading.allprice.vo.AllPriceVo;

@Service
public class AllPriceService {

	@Autowired
	private AllPriceMapper allPriceMapper;
	
	/**
	 * addMemeberConsumerOrder.html 에 chart data
	 * 
	 * @param 
	 * @return 0
	 * @since allList (차트를 구성항 데이터)
	 */
	public List<List<Long>> getOrderCahrtAllPrice() {
		System.out.println("AllPriceService.getCahrtAllPrice() 호출");
		List<Map<String,Object>> allPriceListForChart = allPriceMapper.selectOrderCahrtAllPrice();

		List<List<Long>> allList = new ArrayList<>();

		for(int i=0; i < allPriceListForChart.size(); i++ ) {
			List<Long> list = new ArrayList<>();
			long date = (long) allPriceListForChart.get(i).get("allPriceDate");
			int close = (int) allPriceListForChart.get(i).get("allPriceClose");
			long longclose = close;

			list.add(0, date);
			list.add(1, longclose);
			
			allList.add(list);
		}
		
		//System.out.println("리스트 : " + allList);
		//System.out.println("리스트 갯수 : " + allList.size());
		//System.out.println("큰리스트 갯수 : " + allPriceListForChart.size());
		
		return allList;
	}
	
	/**
	 * index.html 에 chart data
	 * 
	 * @param 
	 * @return 0
	 * @since allList (차트를 구성항 데이터)
	 */
	public List<List<Long>> getIndexCahrtAllPrice() {
		System.out.println("AllPriceService.getCahrtAllPrice() 호출");
		List<Map<String,Object>> allPriceListForChart = allPriceMapper.selectIndexCahrtAllPrice();

		List<List<Long>> allList = new ArrayList<>();

		for(int i=0; i < allPriceListForChart.size(); i++ ) {
			List<Long> list = new ArrayList<>();
			long date = (long) allPriceListForChart.get(i).get("allPriceDate");
			//System.out.println("date : " + date);
			int open = (int) allPriceListForChart.get(i).get("allPriceOpen");
			//System.out.println("open : " + open);
			long longOpen = open;
			//System.out.println("longopen : " + longOpen);
			int close = (int) allPriceListForChart.get(i).get("allPriceClose");
			int high = (int) allPriceListForChart.get(i).get("allPriceHigh");
			int row = (int) allPriceListForChart.get(i).get("allPriceRow");
			long longclose = close;
			long longHigh = high;
			long longRow = row;
			
			list.add(0, date);
			list.add(1, longOpen);
			list.add(2, longclose);
			list.add(3, longHigh);
			list.add(4, longRow);
			
			allList.add(list);
		}
		
		//System.out.println("리스트 : " + allList);
		//System.out.println("리스트 갯수 : " + allList.size());
		//System.out.println("큰리스트 갯수 : " + allPriceListForChart.size());
		
		return allList;
	}
	
	/**
	 * 품목별 시가,종가,최고가,최저가 테이블 insert
	 * 
	 * @param 
	 * @return 0
	 * @since JDK1.8
	 */
	public int addAllPrice() {
		System.out.println("AllPriceService.addAllPrice() 호출");

		/*실행되는 시간을 기준으로 1시간 사이의 모든 체결 리스트 가져오기*/
		List<AllPriceVo> signAddAllPriceList = allPriceMapper.selectSignAddAllPrice();
		AllPriceVo signAddAllPrice = signAddAllPriceList.get(0);
		
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
		int allPriceLastNo = allPriceMapper.selectOneAutoMaxAllPrice();
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
