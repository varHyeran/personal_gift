package com.gift.futurestrading.sign.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gift.futurestrading.sign.mapper.SignMapper;
import com.gift.futurestrading.sign.vo.OrderBuyVo;
import com.gift.futurestrading.sign.vo.OrderSellVo;

@Service
@Transactional
public class SignService {
	@Autowired
	private SignMapper signMapper;
	
	/**
	 * 주식 자동매매 알고리즘을 벤치마킹한 '가격우선원칙 -> 시간우선원칙 -> 수량우선원칙'을 만족하는 데이터 한 줄을 조회하는 메서드 호출
	 * 
	 * 
	 */
	public void sign() {
		System.out.println("SignService.sign() 호출");
		/* Transaction(1)
		 * order_buy, order_sell 테이블에서 각각 미체결 상태인 row 중 
		 * '가격우선원칙 -> 시간우선원칙 -> 수량우선원칙'을 만족하는 데이터를 조회하기위한 mapper계층의 메서드 호출 
		 */	
		List<OrderBuyVo> OneRowOfOrderBuyForSign = new ArrayList<OrderBuyVo>();
		List<OrderSellVo> OneRowOfOrderSellForSign = new ArrayList<OrderSellVo>();
		OneRowOfOrderBuyForSign = signMapper.selectOneRowOfOrderBuyForSign();
		OneRowOfOrderSellForSign = signMapper.selectOneRowOfOrderSellForSign();
		System.out.println(OneRowOfOrderBuyForSign + " <---OneRowOfOrderBuyForSign");
		System.out.println(OneRowOfOrderSellForSign + " <---OneRowOfOrderSellForSign");
		
		/* VO에 저장된 값들 가지고 오기 */
		String orderBuyPk = OneRowOfOrderBuyForSign.get(0).getOrderBuyPk();								// 매수주문번호
		String fkConsumerOrderBuy = OneRowOfOrderBuyForSign.get(0).getFkConsumerOrderBuy();				// 구매자아이디
		String fkItemDetailOrderBuy = OneRowOfOrderBuyForSign.get(0).getFkItemDetailOrderBuy();			// 품목상세
		String orderBuyConsumerName = OneRowOfOrderBuyForSign.get(0).getOrderBuyConsumerName();			// 구매자이름		
		int orderBuyPerPrice = OneRowOfOrderBuyForSign.get(0).getOrderBuyPerPrice();					// 매수가격(1계약당)
		int orderBuyAmount = OneRowOfOrderBuyForSign.get(0).getOrderBuyAmount();						// 매수수량
		
		String orderSellPk = OneRowOfOrderSellForSign.get(0).getOrderSellPk();							// 매도주문번호(PK)
		String fkSellerOrderSell = OneRowOfOrderSellForSign.get(0).getFkSellerOrderSell();				// 판매자아이디
		String orderSellSellerName = OneRowOfOrderSellForSign.get(0).getOrderSellSellerName();			// 판매자 이름
		int orderSellAmount = OneRowOfOrderSellForSign.get(0).getOrderSellAmount();						// 매도수량
		String orderSellFinalPayDate = OneRowOfOrderSellForSign.get(0).getOrderSellFinalPayDate();		// 최종결제일(예상배송일)
		
		/* 체결 수량 구하기 */
		int signAmount = 0;
		
		if(orderBuyAmount == orderSellAmount) {				// 매수수량 == 매도수량
			signAmount = orderSellAmount;
			signMapper.updateStatusOfOrderBuy(orderBuyPk);
			signMapper.updateStatusOfOrderSell(orderSellPk);
		} else if(orderBuyAmount > orderSellAmount) {		// 매수수량 > 매도수량
			signAmount = orderSellAmount;
			signMapper.updateStatusOfOrderSell(orderSellPk);
		} else if(orderBuyAmount < orderSellAmount) {		// 매수수량 < 매도수량
			signMapper.updateStatusOfOrderBuy(orderBuyPk);
			signAmount = orderBuyAmount;
		}
		System.out.println(signAmount + " <---signAmount");
		
		/* 전체체결가 구하기 */
		int totalSignPrice = orderBuyPerPrice * signAmount;
		System.out.println(totalSignPrice + " <---totalSignPrice");
		
		/* 체결증거금 구하기 */
		double initialMargin = (totalSignPrice * 0.1);
		System.out.println(initialMargin + " <---initialMargin");
		
		/* sign 테이블의 sign_no 기본키 숫자값 자동증가 구현을 위한 변수 선언 */
		int pkNoValue;			// 기본키 값 중 숫자
		String pkStringValue;	// 기본키 값 중 문자열
		String signPk;			// 문자열 + 숫자
		
		pkStringValue = "sign_";
		
		/* Transaction(2) : sign 테이블의 sign_no 기본키 숫자값이 자동증가 되도록 구현 */
		List<Integer> resultValue = new ArrayList<Integer>();
		resultValue = signMapper.selectPkOfSign();
		pkNoValue = resultValue.get(0).intValue();
		pkNoValue++;	// 최대값 + 1
		signPk = pkStringValue + pkNoValue;
		System.out.println(pkNoValue + " <---pkNoValue");
		System.out.println(signPk + " <---signPk");
	
		/* sign 테이블에 insert 시킬 때 전달할 param을 위해 해쉬맵에 데이터들 put 하기 */
		HashMap<String, Object> map = new HashMap<String, Object>();		
		String signItemName = "청양고추";
		String signStatus = "일일정산";
		map.put("sign_pk", signPk);											// 체결번호(PK)								
		map.put("fk_seller__sign", fkSellerOrderSell);						// 판매자아이디
		map.put("fk_order_sell__sign", orderSellPk);						// 매도주문번호
		map.put("fk_consumer__sign", fkConsumerOrderBuy);					// 구매자아이디
		map.put("fk_order_buy__sign", orderBuyPk);							// 매수주문번호
		map.put("fk_item_detail__sign", fkItemDetailOrderBuy);				// 품목상세
		map.put("sign_seller_name", orderSellSellerName);					// 판매자이름
		map.put("sign_consumer_name", orderBuyConsumerName);				// 구매자이름
		map.put("sign_item_name", signItemName);							// 품목이름
		map.put("sign_per_price", orderBuyPerPrice);						// 체결가격(1계약당)
		map.put("sign_amount", signAmount);									// 체결수량
		map.put("sign_total_price", totalSignPrice);						// 전체체결가
		map.put("sign_initial_margin", initialMargin);						// 체결증거금
		map.put("sign_futures_trade_end_date", orderSellFinalPayDate);		// 선물거래기간(만기일)
		map.put("sign_status", signStatus);									// 상태
		
		/* Transaction(3) : order_buy, order_sell 테이블에서 각각 select해 온 데이터를 sign 테이블에 insert */		
		signMapper.insertSign(map);
		
		/* order_buy, order_sell 각각의 테이블에 상태 컬럼 '미체결 -> 체결' */
		
		//signMapper.updateStatusOfOrderBuy(orderBuyPk);
		//signMapper.updateStatusOfOrderSell(orderSellPk);					
	}
}
