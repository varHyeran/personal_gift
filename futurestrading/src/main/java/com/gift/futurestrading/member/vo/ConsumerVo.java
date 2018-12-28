package com.gift.futurestrading.member.vo;
/**
 * 관리자 권한으로 구매자리스트를 조회할때 사용하는 VO
 * 
 * @see		com.gift.futurestrading.member.vo.ConsumerVo
 * @since	JDK1.8
 */
public class ConsumerVo {
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
	public String getConsumerIdPk() {
		return consumerIdPk;
	}
	public void setConsumerIdPk(String consumerIdPk) {
		System.out.println("ConsumerVo.setConsumerIdPk() 호출");
		this.consumerIdPk = consumerIdPk;
	}
	public String getConsumerPassword() {
		return consumerPassword;
	}
	public void setConsumerPassword(String consumerPassword) {
		System.out.println("ConsumerVo.setConsumerPassword() 호출");
		this.consumerPassword = consumerPassword;
	}
	public String getConsumerName() {
		return consumerName;
	}
	public void setConsumerName(String consumerName) {
		System.out.println("ConsumerVo.setConsumerName() 호출");
		this.consumerName = consumerName;
	}
	public String getConsumerEmail() {
		return consumerEmail;
	}
	public void setConsumerEmail(String consumerEmail) {
		System.out.println("ConsumerVo.setConsumerEmail() 호출");
		this.consumerEmail = consumerEmail;
	}
	public String getConsumerJuminNo() {
		return consumerJuminNo;
	}
	public void setConsumerJuminNo(String consumerJuminNo) {
		System.out.println("ConsumerVo.setConsumerJuminNo() 호출");
		this.consumerJuminNo = consumerJuminNo;
	}
	public String getConsumerAddressPostCode() {
		return consumerAddressPostCode;
	}
	public void setConsumerAddressPostCode(String consumerAddressPostCode) {
		System.out.println("ConsumerVo.setConsumerAddressPostCode() 호출");
		this.consumerAddressPostCode = consumerAddressPostCode;
	}
	public String getConsumerAddressRoad() {
		return consumerAddressRoad;
	}
	public void setConsumerAddressRoad(String consumerAddressRoad) {
		System.out.println("ConsumerVo.setConsumerAddressRoad() 호출");
		this.consumerAddressRoad = consumerAddressRoad;
	}
	public String getConsumerAddressDetail() {
		return consumerAddressDetail;
	}
	public void setConsumerAddressDetail(String consumerAddressDetail) {
		System.out.println("ConsumerVo.setConsumerAddressDetail() 호출");
		this.consumerAddressDetail = consumerAddressDetail;
	}
	public String getConsumerPhone() {
		return consumerPhone;
	}
	public void setConsumerPhone(String consumerPhone) {
		System.out.println("ConsumerVo.setConsumerPhone() 호출");
		this.consumerPhone = consumerPhone;
	}
	public String getConsumerSignUpDate() {
		return consumerSignUpDate;
	}
	public void setConsumerSignUpDate(String consumerSignUpDate) {
		System.out.println("ConsumerVo.setConsumerSignUpDate() 호출");
		this.consumerSignUpDate = consumerSignUpDate;
	}
	public String getConsumerStatus() {
		return consumerStatus;
	}
	public void setConsumerStatus(String consumerStatus) {
		System.out.println("ConsumerVo.setConsumerStatus() 호출");
		this.consumerStatus = consumerStatus;
	}
	public String getConsumerAdmitCheckFlag() {
		return consumerAdmitCheckFlag;
	}
	public void setConsumerAdmitCheckFlag(String consumerAdmitCheckFlag) {
		System.out.println("ConsumerVo.setConsumerAdmitCheckFlag() 호출");
		this.consumerAdmitCheckFlag = consumerAdmitCheckFlag;
	}
	@Override
	public String toString() {
		return "ConsumerVo [consumerIdPk=" + consumerIdPk + ", consumerPassword=" + consumerPassword + ", consumerName="
				+ consumerName + ", consumerEmail=" + consumerEmail + ", consumerJuminNo=" + consumerJuminNo
				+ ", consumerAddressPostCode=" + consumerAddressPostCode + ", consumerAddressRoad="
				+ consumerAddressRoad + ", consumerAddressDetail=" + consumerAddressDetail + ", consumerPhone="
				+ consumerPhone + ", consumerSignUpDate=" + consumerSignUpDate + ", consumerStatus=" + consumerStatus
				+ ", consumerAdmitCheckFlag=" + consumerAdmitCheckFlag + "]";
	}
	
}
