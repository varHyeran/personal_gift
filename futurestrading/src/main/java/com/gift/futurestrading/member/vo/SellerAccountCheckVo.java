package com.gift.futurestrading.member.vo;

/**
 * @author 정진우
 * @ClassName : SellerAccountCheckVo
 * @Version : JDK1.8
 * @LatestUpdate : 2018-12-28
 * accountCheck ajax 처리 요청시 해당 데이터 바인딩하는 객체
 */
public class SellerAccountCheckVo { 
	private String sellerId ;
	private String sellerName ;
	private String sellerBirth ;
	private String accountBank ;
	private String accountNo ;
	public String getSellerId() {
		return sellerId;
	} 
	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}
	public String getSellerName() {
		return sellerName;
	} 
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	} 
	public String getSellerBirth() {
		return sellerBirth; 
	}
	public void setSellerBirth(String sellerBirth) {
		this.sellerBirth = sellerBirth; 
	}
	public String getAccountBank() {
		return accountBank;
	}
	public void setAccountBank(String accountBank) {
		this.accountBank = accountBank;
	} 
	public String getAccountNo() {
		return accountNo;  
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	
	
	
}
