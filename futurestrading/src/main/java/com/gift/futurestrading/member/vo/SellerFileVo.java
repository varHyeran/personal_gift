package com.gift.futurestrading.member.vo;

/**
 * @author 정진우
 * @ClassName : SellerFileVo
 * @since : JDK1.8
 * @LatestUpdate : 2018-12-28
 * 상세정보 입력 중 파일 업로드시 바인딩 되는 객체
 */
public class SellerFileVo {
	private String sellerNoPk; 
	private String sellerId; 
	private String sellerName;
	private String sellerPath; // 전체 경로
	private String sellerPathFolder; //폴더의 경로
	private String sellerLicence; // 사업자 등록증
	private String sellerBankCopy; // 통장 사본
	private String sellerCertification; // 개인인감 증명서
	private String sellerCommunicationSales; // 통신판매업신고증 사본
	private String sellerProductGrade; // 상품등급확인서

	
	public String getSellerNoPk() {
		return sellerNoPk;
	}
	public void setSellerNoPk(String sellerNoPk) {
		this.sellerNoPk = sellerNoPk;
	}
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
	public String getSellerPath() {
		return sellerPath;
	}
	public void setSellerPath(String sellerPath) {
		this.sellerPath = sellerPath;
	}
	
	
	public String getSellerPathFolder() {
		return sellerPathFolder;
	}
	public void setSellerPathFolder(String sellerPathFolder) {
		this.sellerPathFolder = sellerPathFolder;
	}
	public String getSellerLicence() {
		return sellerLicence;
	}
	public void setSellerLicence(String sellerLicence) {
		this.sellerLicence = sellerLicence;
	}
	public String getSellerBankCopy() {
		return sellerBankCopy;
	}
	public void setSellerBankCopy(String sellerBankCopy) {
		this.sellerBankCopy = sellerBankCopy;
	}
	public String getSellerCertification() {
		return sellerCertification;
	}
	public void setSellerCertification(String sellerCertification) {
		this.sellerCertification = sellerCertification;
	}
	public String getSellerCommunicationSales() {
		return sellerCommunicationSales;
	}
	public void setSellerCommunicationSales(String sellerCommunicationSales) {
		this.sellerCommunicationSales = sellerCommunicationSales;
	}
	public String getSellerProductGrade() {
		return sellerProductGrade;
	}
	public void setSellerProductGrade(String sellerProductGrade) {
		this.sellerProductGrade = sellerProductGrade;
	}
	
	
}

