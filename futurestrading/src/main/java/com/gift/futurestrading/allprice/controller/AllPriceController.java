package com.gift.futurestrading.allprice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;

import com.gift.futurestrading.allprice.service.AllPriceService;


@EnableScheduling
@SpringBootApplication
@Controller
public class AllPriceController {
	
	@Autowired
	AllPriceService allPriceService;
	
	/**
	 *  스케줄러로 특정 시간에 자동실행(매일 9시부터 4시까지 정시에 실행). sign테이블의 가격데이터들로 
	 *  한시간당 시작가격, 종료가격, 최고가, 최저가를 뽑아 allPrice테이블에 입력해준다.
	 * 
	 * @since JDK1.8
	 */
	//@Scheduled(cron = "0 0/60 9-16 * * *" )
	//@Scheduled(fixedDelay = 5000)
	public void addAllPrice() {
		System.out.println("AllPriceController.addAllPrice()호출");
		allPriceService.addAllPrice();
	}
}
