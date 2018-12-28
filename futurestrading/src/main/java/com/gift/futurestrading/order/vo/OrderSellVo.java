package com.gift.futurestrading.order.vo;

/**
 * @author 정진우
 * @ClassName : OrderSellVo
 * @Version : JDK1.8
 * @LatestUpdate : 2018-12-28
 * 주문의 데이터를 담아 acion으로 넘길시 바인딩 되는 객체
 */

public class OrderSellVo {
	private String fkSellerOrderSell;
	private String fkItemDetailOrderSell;
	//private String orderSellSellerName;
	private String orderSellMethod;
	private int orderSellPerPrice;
	private int orderSellAmount;
	
	public int getOrderSellPerPrice() {
		return orderSellPerPrice;
	}
	public void setOrderSellPerPrice(int orderSellPerPrice) {
		this.orderSellPerPrice = orderSellPerPrice;
	}

	public String getFkSellerOrderSell() {
		return fkSellerOrderSell;
	}
	public void setFkSellerOrderSell(String fkSellerOrderSell) {
		this.fkSellerOrderSell = fkSellerOrderSell;
	}
	public String getFkItemDetailOrderSell() {
		return fkItemDetailOrderSell;
	}
	public void setFkItemDetailOrderSell(String fkItemDetailOrderSell) {
		this.fkItemDetailOrderSell = fkItemDetailOrderSell;
	}
/*	public String getOrderSellSellerName() {
		return orderSellSellerName;
	}
	public void setOrderSellSellerName(String orderSellSellerName) {
		this.orderSellSellerName = orderSellSellerName;
	}*/
	public String getOrderSellMethod() {
		return orderSellMethod;
	}
	public void setOrderSellMethod(String orderSellMethod) {
		this.orderSellMethod = orderSellMethod;
	}
	public int getOrderSellAmount() {
		return orderSellAmount;
	} 
	public void setOrderSellAmount(int orderSellAmount) {
		this.orderSellAmount = orderSellAmount;
	}
	@Override
	public String toString() {
		return "OrderSellVo [fkSellerOrderSell=" + fkSellerOrderSell + ", fkItemDetailOrderSell="
				+ fkItemDetailOrderSell + ", orderSellMethod=" + orderSellMethod + ", orderSellPerPrice="
				+ orderSellPerPrice + ", orderSellAmount=" + orderSellAmount + "]";
	}

	
	
}
