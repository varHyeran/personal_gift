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
	 * 주식 자동매매 알고리즘을 벤치마킹한 '가격우선원칙 -> 시간우선원칙 -> 수량우선원칙'을 만족하는 데이터 한 줄을 조회하여 sign 테이블에 insert 시키는 mapper계층의 메서드 호출
	 * @since JDK1.8
	 */
	public void sign() {
		System.out.println("SignService.sign() 호출");
		/* Transaction ①
		 * order_buy, order_sell 테이블에서 각각 미체결 상태인 row 중 
		 * '가격우선원칙 -> 시간우선원칙 -> 수량우선원칙'을 만족하는 데이터를 조회하기위한 mapper계층의 select되는 메서드 호출 후, 리턴 데이터 받기
		 */	
		List<OrderBuyVo> OneRowOfOrderBuyForSign = new ArrayList<OrderBuyVo>();		// 리턴 데이터를 받기위한 변수 선언 및 생성
		List<OrderSellVo> OneRowOfOrderSellForSign = new ArrayList<OrderSellVo>();	// 리턴 데이터를 받기위한 변수 선언 및 생성
		OneRowOfOrderBuyForSign = signMapper.selectOneRowOfOrderBuyForSign();
		OneRowOfOrderSellForSign = signMapper.selectOneRowOfOrderSellForSign();
		System.out.println(OneRowOfOrderBuyForSign + " <---OneRowOfOrderBuyForSign");
		System.out.println(OneRowOfOrderSellForSign + " <---OneRowOfOrderSellForSign");
		
		/* OderBuyVO에 저장된 값들 가지고 오기 */
		String orderBuyPk = OneRowOfOrderBuyForSign.get(0).getOrderBuyPk();								// 매수주문번호
		String fkConsumerOrderBuy = OneRowOfOrderBuyForSign.get(0).getFkConsumerOrderBuy();				// 구매자아이디
		String fkItemDetailOrderBuy = OneRowOfOrderBuyForSign.get(0).getFkItemDetailOrderBuy();			// 품목상세
		String orderBuyConsumerName = OneRowOfOrderBuyForSign.get(0).getOrderBuyConsumerName();			// 구매자이름		
		int orderBuyPerPrice = OneRowOfOrderBuyForSign.get(0).getOrderBuyPerPrice();					// 매수가격(1계약당)
		int orderBuyVariableAmount = OneRowOfOrderBuyForSign.get(0).getOrderBuyVariableAmount();		// 체결에 의해 가변적으로 변하는 수량
		
		/* OderSellVO에 저장된 값들 가지고 오기 */
		String orderSellPk = OneRowOfOrderSellForSign.get(0).getOrderSellPk();							// 매도주문번호(PK)
		String fkSellerOrderSell = OneRowOfOrderSellForSign.get(0).getFkSellerOrderSell();				// 판매자아이디
		String orderSellSellerName = OneRowOfOrderSellForSign.get(0).getOrderSellSellerName();			// 판매자 이름
		int orderSellVariableAmount = OneRowOfOrderSellForSign.get(0).getOrderSellVariableAmount();		// 체결에 의해 가변적으로 변하는 수량
		String orderSellFinalPayDate = OneRowOfOrderSellForSign.get(0).getOrderSellFinalPayDate();		// 최종결제일(예상배송일)
		
		/* sign 테이블의 sign_pk 기본키 숫자값 자동증가 구현을 위한 변수 선언 및 생성 */
		int pkNoValue = 0;					// 기본키 값 중 숫자
		String pkStringValue = "sign_";		// 기본키 값 중 문자열
		String signPk = null;				// 문자열 + 숫자 
		
		/* Transaction ② : sign 테이블의 sign_no 기본키 숫자값이 자동증가 구현을 위해 mapper계층의 select되는 메서드 호출 */
		List<Integer> resultValue = new ArrayList<Integer>();		// 리턴 데이터를 받기위한 변수 선언 및 생성
		resultValue = signMapper.selectPkOfSign();
		pkNoValue = resultValue.get(0).intValue();
		pkNoValue++;	// select하여 리턴 된 최대값 + 1
		signPk = pkStringValue + pkNoValue;
		System.out.println(pkNoValue + " <---pkNoValue");
		System.out.println(signPk + " <---signPk");
		
		/* 체결 수량 구하기 */
		int signAmount = 0;
		
		/* update 메서드 호출 시, 전달할 파라미터 선언 및 생성 */
		HashMap<String, Object> mapForOrderBuy = new HashMap<String, Object>();
		HashMap<String, Object> mapForOrderSell = new HashMap<String, Object>();
		
		if(orderBuyVariableAmount == orderSellVariableAmount) {				// 매수수량 == 매도수량
			System.out.println("1. 매수수량 == 매도수량");
			/* 체결수량 : 매수, 매도수량이 같기 때문에 체결수량에 어떤 주문수량을 넣어도 상관 없다. */
			signAmount = orderBuyVariableAmount;		 
			
			/* order_buy 테이블을 update 시키기 위한 메서드를 호출하기 전, 전달할 파라미터
			 * 매수수량과 매도수량이 같기 때문에 '체결에 의한 가변적 수량'을 나타내는 orderBuyVariableAmount의 값은 0
			 */
			mapForOrderBuy.put("orderBuyVariableAmount", 0);
			mapForOrderBuy.put("orderBuyPk", orderBuyPk);
			
			/* order_sell 테이블을 update 시키기 위한 메서드를 호출하기 전, 전달할 파라미터
			 * 매수수량과 매도수량이 같기 때문에 '체결에 의한 가변적 수량'을 나타내는 orderSellVariableAmount의 값은 0
			 */
			mapForOrderSell.put("orderSellVariableAmount", 0);
			mapForOrderSell.put("orderSellPk", orderSellPk);
			
			/* Transaction ③ : order_buy, order_sell 테이블을 각각 update 시키기 위해 메서드를 호출 */
			signMapper.updateOrderBuy(mapForOrderBuy);
			signMapper.updateOrderSell(mapForOrderSell);
			
		} else if(orderBuyVariableAmount > orderSellVariableAmount) {		// 매수수량 > 매도수량
			System.out.println("2. 매수수량 > 매도수량");
			/* 체결수량 : 주문수량이 상대적으로 적은 매도수량이 체결수량이 된다. */
			signAmount = orderSellVariableAmount;
			
			/* 매수수량 : 주문 넣을 때 입력한 최초수량 - 체결된 수량, 매도수량 : 매수수량보다 적으므로 0 */
			orderBuyVariableAmount = (orderBuyVariableAmount - orderSellVariableAmount);		
			System.out.println(orderBuyVariableAmount + " <---orderBuyVariableAmount");
			
			/* order_buy 테이블을 update 시키기 위한 메서드를 호출하기 전, 전달할 파라미터 */
			mapForOrderBuy.put("orderBuyVariableAmount", orderBuyVariableAmount);
			mapForOrderBuy.put("orderBuyPk", orderBuyPk);
			
			/* order_sell 테이블을 update 시키기 위한 메서드를 호출하기 전, 전달할 파라미터 */
			mapForOrderSell.put("orderSellVariableAmount", 0);
			mapForOrderSell.put("orderSellPk", orderSellPk);
			
			/* order_buy, order_sell 테이블을 각각 update 시키기 위해 메서드를 호출 */
			signMapper.updateOrderBuy(mapForOrderBuy);
			signMapper.updateOrderSell(mapForOrderSell);
			
		} else if(orderBuyVariableAmount < orderSellVariableAmount) {		// 매수수량 < 매도수량
			System.out.println("3. 매수수량 < 매도수량");
			/* 체결수량 : 주문수량이 상대적으로 적은 매수수량이 체결수량이 된다. */
			signAmount = orderBuyVariableAmount;
			
			/* 매도수량 : 주문 넣을 때 입력한 최초수량 - 체결된 수량, 매수수량 : 매수수량보다 적으므로 0 */
			orderSellVariableAmount = (orderSellVariableAmount-orderBuyVariableAmount);			
			System.out.println(orderSellVariableAmount + " <---orderSellVariableAmount - orderBuyVariableAmount");
			
			/* order_buy 테이블을 update 시키기 위한 메서드를 호출하기 전, 전달할 파라미터 */
			mapForOrderBuy.put("orderBuyVariableAmount", 0);
			mapForOrderBuy.put("orderBuyPk", orderBuyPk);
			
			/* order_sell 테이블을 update 시키기 위한 메서드를 호출하기 전, 전달할 파라미터 */
			mapForOrderSell.put("orderSellVariableAmount", orderSellVariableAmount);
			mapForOrderSell.put("orderSellPk", orderSellPk);
			
			/* order_buy, order_sell 테이블을 각각 update 시키기 위해 메서드를 호출 */
			signMapper.updateOrderBuy(mapForOrderBuy);
			signMapper.updateOrderSell(mapForOrderSell);
			
		}
		System.out.println(signAmount + " <---signAmount");
		
		/* 전체체결가 구하기(체결가 = 구매자가 제시한 금액) */
		int totalSignPrice = orderBuyPerPrice * signAmount;
		System.out.println(totalSignPrice + " <---totalSignPrice");
		
		/* 체결증거금 구하기 */
		double initialMargin = (totalSignPrice * 0.1);
		System.out.println(initialMargin + " <---initialMargin");
		
		/* sign 테이블에 insert 시킬 때 전달할 param을 위해 해쉬맵에 데이터들 put 하기 */
		HashMap<String, Object> mapForSign = new HashMap<String, Object>();		
		String signItemName = "청양고추";
		String signStatus = "일일정산";
		mapForSign.put("sign_pk", signPk);											// 체결번호(PK)								
		mapForSign.put("fk_seller__sign", fkSellerOrderSell);						// 판매자아이디
		mapForSign.put("fk_order_sell__sign", orderSellPk);							// 매도주문번호
		mapForSign.put("fk_consumer__sign", fkConsumerOrderBuy);					// 구매자아이디
		mapForSign.put("fk_order_buy__sign", orderBuyPk);							// 매수주문번호
		mapForSign.put("fk_item_detail__sign", fkItemDetailOrderBuy);				// 품목상세
		mapForSign.put("sign_seller_name", orderSellSellerName);					// 판매자이름
		mapForSign.put("sign_consumer_name", orderBuyConsumerName);					// 구매자이름
		mapForSign.put("sign_item_name", signItemName);								// 품목이름
		mapForSign.put("sign_per_price", orderBuyPerPrice);							// 체결가격(1계약당)
		mapForSign.put("sign_amount", signAmount);									// 체결수량
		mapForSign.put("sign_total_price", totalSignPrice);							// 전체체결가
		mapForSign.put("sign_initial_margin", initialMargin);						// 체결증거금
		mapForSign.put("sign_futures_trade_end_date", orderSellFinalPayDate);		// 선물거래기간(만기일)
		mapForSign.put("sign_status", signStatus);									// 상태
		
		/* Transaction ④ : order_buy, order_sell 테이블에서 각각 select해 온 데이터를 sign 테이블에 insert */
		signMapper.insertSign(mapForSign);
					
	}
}
