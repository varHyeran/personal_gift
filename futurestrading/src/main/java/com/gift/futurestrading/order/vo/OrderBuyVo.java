package com.gift.futurestrading.order.vo;

public class OrderBuyVo {
	private String fkConsumerOrderBuy;		/*구매자아이디*/
	private String fkItemDetailOrderBuy;	/*품목상세코드*/
	private String orderBuyMethod;			/*매수방법*/
	private int orderBuyPerPrice;			/*매수가격*/
	private int orderBuyAmount;				/*매수수량*/

	public String getFkConsumerOrderBuy() {
		return fkConsumerOrderBuy;
	}
	public void setFkConsumerOrderBuy(String fkConsumerOrderBuy) {
		this.fkConsumerOrderBuy = fkConsumerOrderBuy;
	}
	public String getFkItemDetailOrderBuy() {
		return fkItemDetailOrderBuy;
	}
	public void setFkItemDetailOrderBuy(String fkItemDetailOrderBuy) {
		this.fkItemDetailOrderBuy = fkItemDetailOrderBuy;
	}
	public String getOrderBuyMethod() {
		return orderBuyMethod;
	}
	public void setOrderBuyMethod(String orderBuyMethod) {
		this.orderBuyMethod = orderBuyMethod;
	}
	public int getOrderBuyPerPrice() {
		return orderBuyPerPrice;
	}
	public void setOrderBuyPerPrice(int orderBuyPerPrice) {
		this.orderBuyPerPrice = orderBuyPerPrice;
	}
	public int getOrderBuyAmount() {
		return orderBuyAmount;
	}
	public void setOrderBuyAmount(int orderBuyAmount) {
		this.orderBuyAmount = orderBuyAmount;
	}
	@Override
	public String toString() {
		return "OrderBuyVo [fkConsumerOrderBuy=" + fkConsumerOrderBuy + ", fkItemDetailOrderBuy=" + fkItemDetailOrderBuy
				+ ", orderBuyMethod=" + orderBuyMethod + ", orderBuyPerPrice=" + orderBuyPerPrice + ", orderBuyAmount="
				+ orderBuyAmount + "]";
	}

}
