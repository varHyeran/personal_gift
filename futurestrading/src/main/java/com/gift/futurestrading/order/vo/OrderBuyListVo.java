package com.gift.futurestrading.order.vo;

public class OrderBuyListVo {
	 
	private String orderBuyPk;				/*주문no*/
	private String orderBuyFinalPayTime;	/*주문시간 TIME_FORMAT(order_buy_final_pay_date, '%H:%i:%s')시간만 빼와서 date 대신 time을 붙임 */ 
	private String orderBuyMethod;			/*매수방법*/	
	private int orderBuyPerPrice;			/*매수가격*/
	private int orderBuyAmount;				/*매수수량*/
	
	public String getOrderBuyPk() {
		return orderBuyPk;
	}
	public void setOrderBuyPk(String orderBuyPk) {
		System.out.println("OrderBuyVoRequest.setOrderBuyPk() 호출");
		this.orderBuyPk = orderBuyPk;
	}
	public String getOrderBuyFinalPayTime() {
		return orderBuyFinalPayTime;
	}
	public void setOrderBuyFinalPayTime(String orderBuyFinalPayTime) {
		System.out.println("OrderBuyVoRequest.setOrderBuyFinalPayTime() 호출");
		this.orderBuyFinalPayTime = orderBuyFinalPayTime;
	}
	public String getOrderBuyMethod() {
		return orderBuyMethod;
	}
	public void setOrderBuyMethod(String orderBuyMethod) {
		System.out.println("OrderBuyVoRequest.setOrderBuyMethod() 호출");
		this.orderBuyMethod = orderBuyMethod;
	}
	public int getOrderBuyPerPrice() {
		return orderBuyPerPrice;
	}
	public void setOrderBuyPerPrice(int orderBuyPerPrice) {
		System.out.println("OrderBuyVoRequest.setOrderBuyPerPrice() 호출");
		this.orderBuyPerPrice = orderBuyPerPrice;
	}
	public int getOrderBuyAmount() {
		return orderBuyAmount;
	}
	public void setOrderBuyAmount(int orderBuyAmount) {
		System.out.println("OrderBuyVoRequest.setOrderBuyAmount() 호출");
		this.orderBuyAmount = orderBuyAmount;
	}
}
