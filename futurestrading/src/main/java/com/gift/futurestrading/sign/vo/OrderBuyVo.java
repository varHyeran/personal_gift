package com.gift.futurestrading.sign.vo;

public class OrderBuyVo {
	
	private String orderBuyPk;				// 매수주문번호(PK)
	private String fkConsumerOrderBuy;		// 구매자아이디
	private String fkItemDetailOrderBuy;	// 품목상세
	private String orderBuyConsumerName;	// 구매자 이름
	private String orderBuyMethod;			// 매수방법
	private int orderBuyPerPrice;			// 매수가격(1계약당)
	private int orderBuyAmount;				// 매수수량
	private String orderBuyDate;			// 매수주문날짜
	private String orderBuyStatus;			// 주문매수 상태
	private String orderBuyFinalPayDate;	// 최종결제일(예상수취일)
	
	public String getOrderBuyPk() {
		return orderBuyPk;
	}
	public void setOrderBuyPk(String orderBuyPk) {
		System.out.println(orderBuyPk + " <---OrderBuyVo.setOrderBuyPk() 호출");
		this.orderBuyPk = orderBuyPk;
	}
	public String getFkConsumerOrderBuy() {
		return fkConsumerOrderBuy;
	}
	public void setFkConsumerOrderBuy(String fkConsumerOrderBuy) {
		System.out.println(fkConsumerOrderBuy + " <---OrderBuyVo.setFkConsumerOrderBuy() 호출");
		this.fkConsumerOrderBuy = fkConsumerOrderBuy;
	}
	public String getFkItemDetailOrderBuy() {
		return fkItemDetailOrderBuy;
	}
	public void setFkItemDetailOrderBuy(String fkItemDetailOrderBuy) {
		System.out.println(fkItemDetailOrderBuy + " <---OrderBuyVo.setFkItemDetailOrderBuy() 호출");
		this.fkItemDetailOrderBuy = fkItemDetailOrderBuy;
	}
	public String getOrderBuyConsumerName() {
		return orderBuyConsumerName;
	}
	public void setOrderBuyConsumerName(String orderBuyConsumerName) {
		System.out.println(orderBuyConsumerName + " <---OrderBuyVo.setOrderBuyConsumerName() 호출");
		this.orderBuyConsumerName = orderBuyConsumerName;
	}
	public String getOrderBuyMethod() {
		return orderBuyMethod;
	}
	public void setOrderBuyMethod(String orderBuyMethod) {
		System.out.println(orderBuyMethod + " <---OrderBuyVo.setOrderBuyMethod() 호출");
		this.orderBuyMethod = orderBuyMethod;
	}
	public int getOrderBuyPerPrice() {
		return orderBuyPerPrice;
	}
	public void setOrderBuyPerPrice(int orderBuyPerPrice) {
		System.out.println(orderBuyPerPrice + " <---OrderBuyVo.setOrderBuyPerPrice() 호출");
		this.orderBuyPerPrice = orderBuyPerPrice;
	}
	public int getOrderBuyAmount() {
		return orderBuyAmount;
	}
	public void setOrderBuyAmount(int orderBuyAmount) {
		System.out.println(orderBuyAmount + " <---OrderBuyVo.setOrderBuyAmount() 호출");
		this.orderBuyAmount = orderBuyAmount;
	}
	public String getOrderBuyDate() {
		return orderBuyDate;
	}
	public void setOrderBuyDate(String orderBuyDate) {
		System.out.println(orderBuyDate + " <---OrderBuyVo.setOrderBuyDate() 호출");
		this.orderBuyDate = orderBuyDate;
	}
	public String getOrderBuyStatus() {
		return orderBuyStatus;
	}
	public void setOrderBuyStatus(String orderBuyStatus) {
		System.out.println(orderBuyStatus + " <---OrderBuyVo.setOrderBuyStatus() 호출");
		this.orderBuyStatus = orderBuyStatus;
	}
	public String getOrderBuyFinalPayDate() {
		return orderBuyFinalPayDate;
	}
	public void setOrderBuyFinalPayDate(String orderBuyFinalPayDate) {
		System.out.println(orderBuyFinalPayDate + " <---OrderBuyVo.setOrderBuyFinalPayDate() 호출");
		this.orderBuyFinalPayDate = orderBuyFinalPayDate;
	}
	

}
