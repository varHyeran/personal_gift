package com.gift.futurestrading.allprice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@EnableScheduling
@SpringBootApplication
@Controller
public class AllPriceController {
	
	@Autowired
	AllPriceService allPriceService;
	
	@Scheduled(cron = "0 0/60 9-16 * * *" )
	@GetMapping("/testsh")
	public void testshaduling() {
		System.out.println("AllPriceController.testshaduling();");
	}
	
	//@Scheduled(cron = "0 0/60 9-16 * * *" )
	//@Scheduled(fixedDelay = 5000)
	@GetMapping("/testall")
	public void addAllPrice() {
		System.out.println("AllPriceController.addAllPrice()호출");
		allPriceService.addAllPrice();
	}
}
