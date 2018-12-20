package com.gift.futurestrading.order.vo;

public class OrderBuyVo {
	private String orderBuyPk;				/*매수주문번호(PK)*/
	private String fkConsumerOrderBuy;		/*구매자아이디*/
	private String fkItemDetailOrderBuy;	/*품목상세코드*/
	private String orderBuyConsumerName;	/*구매자 이름*/
	private String orderBuyMethod;			/*매수방법*/
	private int orderBuyPerPrice;			/*매수가격*/
	private int orderBuyAmount;				/*매수수량*/
	private String orderBuyDate;			/*매수주문날짜*/
	private String orderBuyStatus;			/*주문매수 상태*/
	private String orderBuyFinalPayDate;	/*최종결제일*/
	public String getOrderBuyPk() {
		return orderBuyPk;
	}
	public void setOrderBuyPk(String orderBuyPk) {
		this.orderBuyPk = orderBuyPk;
	}
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
	public String getOrderBuyConsumerName() {
		return orderBuyConsumerName;
	}
	public void setOrderBuyConsumerName(String orderBuyConsumerName) {
		this.orderBuyConsumerName = orderBuyConsumerName;
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
	public String getOrderBuyDate() {
		return orderBuyDate;
	}
	public void setOrderBuyDate(String orderBuyDate) {
		this.orderBuyDate = orderBuyDate;
	}
	public String getOrderBuyStatus() {
		return orderBuyStatus;
	}
	public void setOrderBuyStatus(String orderBuyStatus) {
		this.orderBuyStatus = orderBuyStatus;
	}
	public String getOrderBuyFinalPayDate() {
		return orderBuyFinalPayDate;
	}
	public void setOrderBuyFinalPayDate(String orderBuyFinalPayDate) {
		this.orderBuyFinalPayDate = orderBuyFinalPayDate;
	}
	@Override
	public String toString() {
		return "OrderBuyVo [orderBuyPk=" + orderBuyPk + ", fkConsumerOrderBuy=" + fkConsumerOrderBuy
				+ ", fkItemDetailOrderBuy=" + fkItemDetailOrderBuy + ", orderBuyConsumerName=" + orderBuyConsumerName
				+ ", orderBuyMethod=" + orderBuyMethod + ", orderBuyPerPrice=" + orderBuyPerPrice + ", orderBuyAmount="
				+ orderBuyAmount + ", orderBuyDate=" + orderBuyDate + ", orderBuyStatus=" + orderBuyStatus
				+ ", orderBuyFinalPayDate=" + orderBuyFinalPayDate + "]";
	}
}
