package com.gift.futurestrading.allprice;

public class SignAddAllPriceVo {
	private String signPk;
	private String signItemName;
	private int signPerPrice;
	private String signDate;
	public String getSignDate() {
		return signDate;
	}
	public void setSignDate(String signDate) {
		this.signDate = signDate;
	}
	public String getSignPk() {
		return signPk;
	}
	public void setSignPk(String signPk) {
		System.out.println("SignAddAllPriceVo.setSignPk() 호출");
		this.signPk = signPk;
	}
	public String getSignItemName() {
		return signItemName;
	}
	public void setSignItemName(String signItemName) {
		System.out.println("SignAddAllPriceVo.setSignItemName() 호출");
		this.signItemName = signItemName;
	}
	public int getSignPerPrice() {
		return signPerPrice;
	}
	public void setSignPerPrice(int signPerPrice) {
		System.out.println("SignAddAllPriceVo.setSignPerPrice() 호출");
		this.signPerPrice = signPerPrice;
	}
	@Override
	public String toString() {
		return "SignAddAllPriceVo [signPk=" + signPk + ", signItemName=" + signItemName + ", signPerPrice="
				+ signPerPrice + ", signDate=" + signDate + "]";
	}	
}
