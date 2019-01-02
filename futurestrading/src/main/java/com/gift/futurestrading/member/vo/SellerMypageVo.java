package com.gift.futurestrading.member.vo;

public class SellerMypageVo {
	
	private String sellerIdPk;				// 판매자아이디*
	private String sellerPassword;			// 비밀번호-
	private String sellerName;				// 판매자 이름*
	private String sellerEmail;				// 이메일*
	private String sellerJuminNo;			// 주민번호(뒷자리 1자리 포함)*
	private String sellerSignUpDate;		// 가입 날짜-
	private String sellerAddressPostCode;	// 우편번호*
	private String sellerAddressRoad;		// 도로명주소 *
	private String sellerAddressDetail;		// 상세주소*
	private String sellerCorporateName;		// 회사이름
	private String sellerPhone;				// 판매자 연락처*
	private String sellerRight;				// 권한
	private String sellerAdmitAdmin;		// 가입승인관리자-
	private String sellerAdmitDate;			// 인증날짜
	public String getSellerIdPk() {
		return sellerIdPk;
	}
	public void setSellerIdPk(String sellerIdPk) {
		System.out.println(sellerIdPk + " <---SellerMypageVo.setSellerIdPk() 호출");
		this.sellerIdPk = sellerIdPk;
	}
	public String getSellerPassword() {
		return sellerPassword;
	}
	public void setSellerPassword(String sellerPassword) {
		System.out.println(sellerPassword + " <---SellerMypageVo.setSellerPassword() 호출");
		this.sellerPassword = sellerPassword;
	}
	public String getSellerName() {
		return sellerName;
	}
	public void setSellerName(String sellerName) {
		System.out.println(sellerName + " <---SellerMypageVo.setSellerName() 호출");
		this.sellerName = sellerName;
	}
	public String getSellerEmail() {
		return sellerEmail;
	}
	public void setSellerEmail(String sellerEmail) {
		System.out.println(sellerEmail + " <---SellerMypageVo.setSellerEmail() 호출");
		this.sellerEmail = sellerEmail;
	}
	public String getSellerJuminNo() {
		return sellerJuminNo;
	}
	public void setSellerJuminNo(String sellerJuminNo) {
		System.out.println(sellerJuminNo + " <---SellerMypageVo.setSellerJuminNo() 호출");
		this.sellerJuminNo = sellerJuminNo;
	}
	public String getSellerSignUpDate() {
		return sellerSignUpDate;
	}
	public void setSellerSignUpDate(String sellerSignUpDate) {
		System.out.println(sellerSignUpDate + " <---SellerMypageVo.setSellerSignUpDate() 호출");
		this.sellerSignUpDate = sellerSignUpDate;
	}
	public String getSellerAddressPostCode() {
		return sellerAddressPostCode;
	}
	public void setSellerAddressPostCode(String sellerAddressPostCode) {
		System.out.println(sellerAddressPostCode + " <---SellerMypageVo.setSellerAddressPostCode() 호출");
		this.sellerAddressPostCode = sellerAddressPostCode;
	}
	public String getSellerAddressRoad() {
		return sellerAddressRoad;
	}
	public void setSellerAddressRoad(String sellerAddressRoad) {
		System.out.println(sellerAddressRoad + " <---SellerMypageVo.setSellerAddressRoad() 호출");
		this.sellerAddressRoad = sellerAddressRoad;
	}
	public String getSellerAddressDetail() {
		return sellerAddressDetail;
	}
	public void setSellerAddressDetail(String sellerAddressDetail) {
		System.out.println(sellerAddressDetail + " <---SellerMypageVo.setSellerAddressDetail() 호출");
		this.sellerAddressDetail = sellerAddressDetail;
	}
	public String getSellerCorporateName() {
		return sellerCorporateName;
	}
	public void setSellerCorporateName(String sellerCorporateName) {
		System.out.println(sellerCorporateName + " <---SellerMypageVo.setSellerCorporateName() 호출");
		this.sellerCorporateName = sellerCorporateName;
	}
	public String getSellerPhone() {
		return sellerPhone;
	}
	public void setSellerPhone(String sellerPhone) {
		System.out.println(sellerPhone + " <---SellerMypageVo.setSellerPhone() 호출");
		this.sellerPhone = sellerPhone;
	}
	public String getSellerRight() {
		return sellerRight;
	}
	public void setSellerRight(String sellerRight) {
		System.out.println(sellerRight + " <---SellerMypageVo.setSellerRight() 호출");
		this.sellerRight = sellerRight;
	}
	public String getSellerAdmitAdmin() {
		return sellerAdmitAdmin;
	}
	public void setSellerAdmitAdmin(String sellerAdmitAdmin) {
		System.out.println(sellerAdmitAdmin + " <---SellerMypageVo.setSellerAdmitAdmin() 호출");
		this.sellerAdmitAdmin = sellerAdmitAdmin;
	}
	public String getSellerAdmitDate() {
		return sellerAdmitDate;
	}
	public void setSellerAdmitDate(String sellerAdmitDate) {
		System.out.println(sellerAdmitDate + " <---SellerMypageVo.setSellerAdmitDate() 호출");
		this.sellerAdmitDate = sellerAdmitDate;
	}
	@Override
	public String toString() {
		return "SellerMypageVo [sellerIdPk=" + sellerIdPk + ", sellerPassword=" + sellerPassword + ", sellerName="
				+ sellerName + ", sellerEmail=" + sellerEmail + ", sellerJuminNo=" + sellerJuminNo
				+ ", sellerSignUpDate=" + sellerSignUpDate + ", sellerAddressPostCode=" + sellerAddressPostCode
				+ ", sellerAddressRoad=" + sellerAddressRoad + ", sellerAddressDetail=" + sellerAddressDetail
				+ ", sellerCorporateName=" + sellerCorporateName + ", sellerPhone=" + sellerPhone + ", sellerRight="
				+ sellerRight + ", sellerAdmitAdmin=" + sellerAdmitAdmin + ", sellerAdmitDate=" + sellerAdmitDate + "]";
	}
	
	
}
