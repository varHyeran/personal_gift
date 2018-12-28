package com.gift.futurestrading.member.vo;

public class ConsumerSignDetailVo {
	private String signPk;
	private String fkOrderBuySign;
	private String fkSellerSign;
	private String signSellerName;
	private int signPerPrice;
	private int signAmount;
	private int signTotalPrice;
	private int signInitialMargin;
	private String signDate;
	private String signFuturesTradeBeginDate;
	private String signFuturesTradeEndDate;
	
	public String getSignPk() {
		return signPk;
	}
	public void setSignPk(String signPk) {
		this.signPk = signPk;
		System.out.println(signPk + "<----- setSignPk");
	}
	public String getFkOrderBuySign() {
		return fkOrderBuySign;
	}
	public void setFkOrderBuySign(String fkOrderBuySign) {
		this.fkOrderBuySign = fkOrderBuySign;
		System.out.println(fkOrderBuySign + "<----- setFkOrderBuySign");
	}
	public String getFkSellerSign() {
		return fkSellerSign;
	}
	public void setFkSellerSign(String fkSellerSign) {
		this.fkSellerSign = fkSellerSign;
		System.out.println(fkSellerSign + "<----- setFkSellerSign");
	}
	public String getSignSellerName() {
		return signSellerName;
	}
	public void setSignSellerName(String signSellerName) {
		this.signSellerName = signSellerName;
		System.out.println(signSellerName + "<----- setSignSellerName");
	}
	public int getSignPerPrice() {
		return signPerPrice;
	}
	public void setSignPerPrice(int signPerPrice) {
		this.signPerPrice = signPerPrice;
		System.out.println(signPerPrice + "<----- setSignPerPrice");
	}
	public int getSignAmount() {
		return signAmount;
	}
	public void setSignAmount(int signAmount) {
		this.signAmount = signAmount;
		System.out.println(signAmount + "<----- setSignAmount");
	}
	public int getSignTotalPrice() {
		return signTotalPrice;
	}
	public void setSignTotalPrice(int signTotalPrice) {
		this.signTotalPrice = signTotalPrice;
		System.out.println(signTotalPrice + "<----- setSignTotalPrice");
	}
	public int getSignInitialMargin() {
		return signInitialMargin;
	}
	public void setSignInitialMargin(int signInitialMargin) {
		this.signInitialMargin = signInitialMargin;
		System.out.println(signInitialMargin + "<----- setSignInitialMargin");
	}
	public String getSignDate() {
		return signDate;
	}
	public void setSignDate(String signDate) {
		this.signDate = signDate;
		System.out.println(signDate + "<----- setSignDate");
	}
	public String getSignFuturesTradeBeginDate() {
		return signFuturesTradeBeginDate;
	}
	public void setSignFuturesTradeBeginDate(String signFuturesTradeBeginDate) {
		this.signFuturesTradeBeginDate = signFuturesTradeBeginDate;
		System.out.println(signFuturesTradeBeginDate + "<----- setSignFuturesTradeBeginDate");
	}
	public String getSignFuturesTradeEndDate() {
		return signFuturesTradeEndDate;
	}
	public void setSignFuturesTradeEndDate(String signFuturesTradeEndDate) {
		this.signFuturesTradeEndDate = signFuturesTradeEndDate;
		System.out.println(signFuturesTradeEndDate + "<----- setSignFuturesTradeEndDate");
	}
	@Override
	public String toString() {
		return "ConsumerSignDetailVo [signPk=" + signPk + ", fkOrderBuySign=" + fkOrderBuySign + ", fkSellerSign="
				+ fkSellerSign + ", signSellerName=" + signSellerName + ", signPerPrice=" + signPerPrice
				+ ", signAmount=" + signAmount + ", signTotalPrice=" + signTotalPrice + ", signInitialMargin="
				+ signInitialMargin + ", signDate=" + signDate + ", signFuturesTradeBeginDate="
				+ signFuturesTradeBeginDate + ", signFuturesTradeEndDate=" + signFuturesTradeEndDate + "]";
	}
}
