package com.gift.futurestrading.sign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import com.gift.futurestrading.sign.service.SignService;

@Controller
public class SignController {
	@Autowired
	private SignService signService;
	
	/**
	 * 스프링 스케줄러 사용 & 설정
	 * Cron Expression (왼쪽에서 오른쪽으로 읽기)
	 * Seconds : 0 ~ 59
	 * Minutes : 0 ~ 59
	 * Hours : 0 ~ 23  
	 * Day of Month : 1 ~ 31
	 * Month : 1 ~ 12 
	 * Day of Week : 1 ~ 7 (1 => 일요일, 7=> 토요일 / MON, SUN...) 
	 * Years(optional) : 1970 ~ 2099
	 * 특수문자 (*) : 모든수를 의미, Minutes 위치에 사용될 경우 매분마다 라는 뜻 
	 * 
	 * 
	 */
	@Scheduled(cron = "0 0/1 9-16 * * *")
	public void sign() {
		System.out.println("SignController.sign() 호출 : 체결 시작 !");	
		/* service 계층의 체결 메서드 호출 */
		signService.sign();
	}

}
