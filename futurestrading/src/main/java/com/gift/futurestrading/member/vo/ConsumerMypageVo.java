package com.gift.futurestrading.member.vo;

public class ConsumerMypageVo {
	private String consumerIdPk;			// 아이디
	private String consumerPassword;		// 비밀번호
	private String consumerName;			// 이름
	private String consumerEmail;			// 이메일
	private String consumerJuminNo;			// 주민번호
	private String consumerAddressPostCode;	// 우편번호
	private String consumerAddressRoad;		// 도로명주소
	private String consumerAddressDetail;	// 상세주소
	private String consumerPhone;			// 전화번호
	private String consumerSignUpDate;		// 가입날짜
	private String consumerStatus;			// 회원상태(정상,블랙리스트)
	private String consumerAdmitCheckFlag;	// 계좌인증여부
	private String consumerAdmitDate;		// 계좌인증날짜
	public String getConsumerIdPk() {
		return consumerIdPk;
	}
	public void setConsumerIdPk(String consumerIdPk) {
		this.consumerIdPk = consumerIdPk;
	}
	public String getConsumerPassword() {
		return consumerPassword;
	}
	public void setConsumerPassword(String consumerPassword) {
		this.consumerPassword = consumerPassword;
	}
	public String getConsumerName() {
		return consumerName;
	}
	public void setConsumerName(String consumerName) {
		this.consumerName = consumerName;
	}
	public String getConsumerEmail() {
		return consumerEmail;
	}
	public void setConsumerEmail(String consumerEmail) {
		this.consumerEmail = consumerEmail;
	}
	public String getConsumerJuminNo() {
		return consumerJuminNo;
	}
	public void setConsumerJuminNo(String consumerJuminNo) {
		this.consumerJuminNo = consumerJuminNo;
	}
	public String getConsumerAddressPostCode() {
		return consumerAddressPostCode;
	}
	public void setConsumerAddressPostCode(String consumerAddressPostCode) {
		this.consumerAddressPostCode = consumerAddressPostCode;
	}
	public String getConsumerAddressRoad() {
		return consumerAddressRoad;
	}
	public void setConsumerAddressRoad(String consumerAddressRoad) {
		this.consumerAddressRoad = consumerAddressRoad;
	}
	public String getConsumerAddressDetail() {
		return consumerAddressDetail;
	}
	public void setConsumerAddressDetail(String consumerAddressDetail) {
		this.consumerAddressDetail = consumerAddressDetail;
	}
	public String getConsumerPhone() {
		return consumerPhone;
	}
	public void setConsumerPhone(String consumerPhone) {
		this.consumerPhone = consumerPhone;
	}
	public String getConsumerSignUpDate() {
		return consumerSignUpDate;
	}
	public void setConsumerSignUpDate(String consumerSignUpDate) {
		this.consumerSignUpDate = consumerSignUpDate;
	}
	public String getConsumerStatus() {
		return consumerStatus;
	}
	public void setConsumerStatus(String consumerStatus) {
		this.consumerStatus = consumerStatus;
	}
	public String getConsumerAdmitCheckFlag() {
		return consumerAdmitCheckFlag;
	}
	public void setConsumerAdmitCheckFlag(String consumerAdmitCheckFlag) {
		this.consumerAdmitCheckFlag = consumerAdmitCheckFlag;
	}
	public String getConsumerAdmitDate() {
		return consumerAdmitDate;
	}
	public void setConsumerAdmitDate(String consumerAdmitDate) {
		this.consumerAdmitDate = consumerAdmitDate;
	}
	@Override
	public String toString() {
		return "ConsumerMypageVo [consumerIdPk=" + consumerIdPk + ", consumerPassword=" + consumerPassword
				+ ", consumerName=" + consumerName + ", consumerEmail=" + consumerEmail + ", consumerJuminNo="
				+ consumerJuminNo + ", consumerAddressPostCode=" + consumerAddressPostCode + ", consumerAddressRoad="
				+ consumerAddressRoad + ", consumerAddressDetail=" + consumerAddressDetail + ", consumerPhone="
				+ consumerPhone + ", consumerSignUpDate=" + consumerSignUpDate + ", consumerStatus=" + consumerStatus
				+ ", consumerAdmitCheckFlag=" + consumerAdmitCheckFlag + ", consumerAdmitDate=" + consumerAdmitDate
				+ "]";
	}

}
