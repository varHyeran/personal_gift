package com.gift.futurestrading.member.vo;

public class SellerVo {
	private String sellerIdPk;
	private String sellerPassword;
	private String sellerEmail;
	private String sellerName;
	private String sellerJuminNo;
	private String sellerSignUpDate;
	private String sellerAddress;
	private String sellerCorporateName;
	private String sellerPhone;
	private String sellerRight;
	private String sellerAdmitAdmin;
	private String sellerAdmitDate;
	public String getSellerIdPk() {
		System.out.println("SellerVo.getSellerIdPk() 호출");
		return sellerIdPk;
	}
	public void setSellerIdPk(String sellerIdPk) {
		System.out.println("SellerVo.setSellerIdPk() 호출");
		this.sellerIdPk = sellerIdPk;
	}
	public String getSellerPassword() {
		System.out.println("SellerVo.getSellerPassword() 호출");
		return sellerPassword;
	}
	public void setSellerPassword(String sellerPassword) {
		System.out.println("SellerVo.setSellerPassword() 호출");
		this.sellerPassword = sellerPassword;
	}
	public String getSellerEmail() {
		System.out.println("SellerVo.getSellerEmail() 호출");
		return sellerEmail;
	}
	public void setSellerEmail(String sellerEmail) {
		System.out.println("SellerVo.setSellerEmail() 호출");
		this.sellerEmail = sellerEmail;
	}
	public String getSellerName() {
		System.out.println("SellerVo.getSellerName() 호출");
		return sellerName;
	}
	public void setSellerName(String sellerName) {
		System.out.println("SellerVo.setSellerName() 호출");
		this.sellerName = sellerName;
	}
	public String getSellerJuminNo() {
		System.out.println("SellerVo.getSellerJuminNo() 호출");
		return sellerJuminNo;
	}
	public void setSellerJuminNo(String sellerJuminNo) {
		System.out.println("SellerVo.setSellerJuminNo() 호출");
		this.sellerJuminNo = sellerJuminNo;
	}
	public String getSellerSignUpDate() {
		System.out.println("SellerVo.getSellerSignUpDate() 호출");
		return sellerSignUpDate;
	}
	public void setSellerSignUpDate(String sellerSignUpDate) {
		System.out.println("SellerVo.setSellerSignUpDate() 호출");
		this.sellerSignUpDate = sellerSignUpDate;
	}
	public String getSellerAddress() {
		System.out.println("SellerVo.getSellerAddress() 호출");
		return sellerAddress;
	}
	public void setSellerAddress(String sellerAddress) {
		System.out.println("SellerVo.setSellerAddress() 호출");
		this.sellerAddress = sellerAddress;
	}
	public String getSellerCorporateName() {
		System.out.println("SellerVo.getSellerCorporateName() 호출");
		return sellerCorporateName;
	}
	public void setSellerCorporateName(String sellerCorporateName) {
		System.out.println("SellerVo.setSellerCorporateName() 호출");
		this.sellerCorporateName = sellerCorporateName;
	}
	public String getSellerPhone() {
		System.out.println("SellerVo.getSellerPhone() 호출");
		return sellerPhone;
	}
	public void setSellerPhone(String sellerPhone) {
		System.out.println("SellerVo.setSellerPhone() 호출");
		this.sellerPhone = sellerPhone;
	}
	public String getSellerRight() {
		System.out.println("SellerVo.getSellerRight() 호출");
		return sellerRight;
	}
	public void setSellerRight(String sellerRight) {
		System.out.println("SellerVo.setSellerRight() 호출");
		this.sellerRight = sellerRight;
	}
	public String getSellerAdmitAdmin() {
		System.out.println("SellerVo.getSellerAdmitAdmin() 호출");
		return sellerAdmitAdmin;
	}
	public void setSellerAdmitAdmin(String sellerAdmitAdmin) {
		System.out.println("SellerVo.setSellerAdmitAdmin() 호출");
		this.sellerAdmitAdmin = sellerAdmitAdmin;
	}
	public String getSellerAdmitDate() {
		System.out.println("SellerVo.getSellerAdmitDate() 호출");
		return sellerAdmitDate;
	}
	public void setSellerAdmitDate(String sellerAdmitDate) {
		System.out.println("SellerVo.setSellerAdmitDate() 호출");
		this.sellerAdmitDate = sellerAdmitDate;
	}
	@Override
	public String toString() {
		return "SellerVo [sellerIdPk=" + sellerIdPk + ", sellerPassword=" + sellerPassword + ", sellerEmail="
				+ sellerEmail + ", sellerName=" + sellerName + ", sellerJuminNo=" + sellerJuminNo
				+ ", sellerSignUpDate=" + sellerSignUpDate + ", sellerAddress=" + sellerAddress
				+ ", sellerCorporateName=" + sellerCorporateName + ", sellerPhone=" + sellerPhone + ", sellerRight="
				+ sellerRight + ", sellerAdmitAdmin=" + sellerAdmitAdmin + ", sellerAdmitDate=" + sellerAdmitDate + "]";
	}
}
