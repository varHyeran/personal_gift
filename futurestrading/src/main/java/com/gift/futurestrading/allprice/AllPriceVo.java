package com.gift.futurestrading.allprice;

public class AllPriceVo {
	private String allPriceNoPk;
	private String itemName;
	private int openingPrice;
	private int closingPrice;
	private int topPrice;
	private int bottomPrice;
	private String allPriceDate;
	public String getAllPriceNoPk() {
		return allPriceNoPk;
	}
	public void setAllPriceNoPk(String allPriceNoPk) {
		this.allPriceNoPk = allPriceNoPk;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getOpeningPrice() {
		return openingPrice;
	}
	public void setOpeningPrice(int openingPrice) {
		this.openingPrice = openingPrice;
	}
	public int getClosingPrice() {
		return closingPrice;
	}
	public void setClosingPrice(int closingPrice) {
		this.closingPrice = closingPrice;
	}
	public int getTopPrice() {
		return topPrice;
	}
	public void setTopPrice(int topPrice) {
		this.topPrice = topPrice;
	}
	public int getBottomPrice() {
		return bottomPrice;
	}
	public void setBottomPrice(int bottomPrice) {
		this.bottomPrice = bottomPrice;
	}
	public String getAllPriceDate() {
		return allPriceDate;
	}
	public void setAllPriceDate(String allPriceDate) {
		this.allPriceDate = allPriceDate;
	}
	@Override
	public String toString() {
		return "AllPriceVo [allPriceNoPk=" + allPriceNoPk + ", itemName=" + itemName + ", openingPrice=" + openingPrice
				+ ", closingPrice=" + closingPrice + ", topPrice=" + topPrice + ", bottomPrice=" + bottomPrice
				+ ", allPriceDate=" + allPriceDate + "]";
	}
}
