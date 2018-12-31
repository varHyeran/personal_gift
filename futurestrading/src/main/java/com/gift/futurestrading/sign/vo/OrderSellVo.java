package com.gift.futurestrading.sign.vo;

public class OrderSellVo {
	
	private String orderSellPk;				// 매도주문번호(PK)
	private String fkSellerOrderSell;		// 판매자아이디
	private String fkItemDetailOrderSell;	// 품목상세(fk)
	private String orderSellSellerName;		// 판매자 이름
	private String orderSellMethod;			// 매도방법
	private int orderSellPerPrice;			// 매도가격(1계약당)
	private int orderSellAmount;			// 매도수량
	private String orderSellDate;			// 매도주문날짜
	private String orderSellStatus;			// 주문매도상태
	private String orderSellFinalPayDate;	// 최종결제일(예상배송일)
	
	public String getOrderSellPk() {
		return orderSellPk;
	}
	public void setOrderSellPk(String orderSellPk) {
		System.out.println(orderSellPk + " <---OrderSellVo.setOrderSellPk() 호출");
		this.orderSellPk = orderSellPk;
	}
	public String getFkSellerOrderSell() {
		return fkSellerOrderSell;
	}
	public void setFkSellerOrderSell(String fkSellerOrderSell) {
		System.out.println(fkSellerOrderSell + " <---OrderSellVo.setFkSellerOrderSell() 호출");
		this.fkSellerOrderSell = fkSellerOrderSell;
	}
	public String getFkItemDetailOrderSell() {
		return fkItemDetailOrderSell;
	}
	public void setFkItemDetailOrderSell(String fkItemDetailOrderSell) {
		System.out.println(fkItemDetailOrderSell + " <---OrderSellVo.setFkItemDetailOrderSell() 호출");
		this.fkItemDetailOrderSell = fkItemDetailOrderSell;
	}
	public String getOrderSellSellerName() {
		return orderSellSellerName;
	}
	public void setOrderSellSellerName(String orderSellSellerName) {
		System.out.println(orderSellSellerName + " <---OrderSellVo.setOrderSellSellerName() 호출");
		this.orderSellSellerName = orderSellSellerName;
	}
	public String getOrderSellMethod() {
		return orderSellMethod;
	}
	public void setOrderSellMethod(String orderSellMethod) {
		System.out.println(orderSellMethod + " <---OrderSellVo.setOrderSellMethod() 호출");
		this.orderSellMethod = orderSellMethod;
	}
	public int getOrderSellPerPrice() {
		return orderSellPerPrice;
	}
	public void setOrderSellPerPrice(int orderSellPerPrice) {
		System.out.println(orderSellPerPrice + " <---OrderSellVo.setOrderSellPerPrice() 호출");
		this.orderSellPerPrice = orderSellPerPrice;
	}
	public int getOrderSellAmount() {
		return orderSellAmount;
	}
	public void setOrderSellAmount(int orderSellAmount) {
		System.out.println(orderSellAmount + " <---OrderSellVo.setOrderSellAmount() 호출");
		this.orderSellAmount = orderSellAmount;
	}
	public String getOrderSellDate() {
		return orderSellDate;
	}
	public void setOrderSellDate(String orderSellDate) {
		System.out.println(orderSellDate + " <---OrderSellVo.setOrderSellDate() 호출");
		this.orderSellDate = orderSellDate;
	}
	public String getOrderSellStatus() {
		return orderSellStatus;
	}
	public void setOrderSellStatus(String orderSellStatus) {
		System.out.println(orderSellStatus + " <---OrderSellVo.setOrderSellStatus() 호출");
		this.orderSellStatus = orderSellStatus;
	}
	public String getOrderSellFinalPayDate() {
		return orderSellFinalPayDate;
	}
	public void setOrderSellFinalPayDate(String orderSellFinalPayDate) {
		System.out.println(orderSellFinalPayDate + " <---OrderSellVo.setOrderSellFinalPayDate() 호출");
		this.orderSellFinalPayDate = orderSellFinalPayDate;
	}
	

}
