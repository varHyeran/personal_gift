package com.gift.futurestrading.member.vo;

public class SellerRequestVo {
	
	private String sellerIdPk;		// 아이디
	private String sellerPassword;	// 비밀번호
	private String sellerName;		// 이름
	private String sellerEmail;		// 이메일
	private String sellerJuminNo;		// 주민번호
	private String postcode;			// 우편번호
	private String roadAddress;			// 도로명주소
	private String detailAddress;		// 상세주소
	private String corporateName;		// 상세주소
	private String sellerPhone;			// 전화번호
	
	public String getSellerIdPk() {
		return sellerIdPk;
	}
	public void setSellerIdPk(String sellerIdPk) {
		this.sellerIdPk = sellerIdPk;
	}
	public String getSellerPassword() {
		return sellerPassword;
	}
	public void setSellerPassword(String sellerPassword) {
		this.sellerPassword = sellerPassword;
	}
	public String getSellerName() {
		return sellerName;
	}
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	public String getSellerEmail() {
		return sellerEmail;
	}
	public void setSellerEmail(String sellerEmail) {
		this.sellerEmail = sellerEmail;
	}
	public String getSellerJuminNo() {
		return sellerJuminNo;
	}
	public void setSellerJuminNo(String sellerJuminNo) {
		this.sellerJuminNo = sellerJuminNo;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getRoadAddress() {
		return roadAddress;
	}
	public void setRoadAddress(String roadAddress) {
		this.roadAddress = roadAddress;
	}
	public String getDetailAddress() {
		return detailAddress;
	}
	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}

	public String getCorporateName() {
		System.out.println(corporateName+"corporateName / getCorporateName");
		return corporateName;
	}
	public void setCorporateName(String corporateName) {
		System.out.println(corporateName+"corporateName / setCorporateName");
		this.corporateName = corporateName;
	}
	public String getSellerPhone() {
		return sellerPhone;
	}
	public void setSellerPhone(String sellerPhone) {
		this.sellerPhone = sellerPhone;
	}
	@Override
	public String toString() {
		return "SellerRequestVo [sellerIdPk=" + sellerIdPk + ", sellerPassword=" + sellerPassword + ", sellerName="
				+ sellerName + ", sellerEmail=" + sellerEmail + ", sellerJuminNo=" + sellerJuminNo + ", postcode="
				+ postcode + ", roadAddress=" + roadAddress + ", detailAddress=" + detailAddress + ", corporateName="
				+ corporateName + ", sellerPhone=" + sellerPhone + "]";
	}

	
}
	