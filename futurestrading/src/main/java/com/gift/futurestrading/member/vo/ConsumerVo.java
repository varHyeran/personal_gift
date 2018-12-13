package com.gift.futurestrading.member.vo;

public class ConsumerVo {
	private String consumerIdPk;
	private String consumerPassword;
	private String consumerName;
	private String consumerEmail;
	private String consumerJuminNo;
	private String consumerAddress;
	private String consumerPhone;
	private String consumerSignUpDate;
	private String consumerStatus;
	private String consumerAdmitCheckFlag;
	private String consumerAdmitAdmin;
	private String consumerAdmitDate;
	public String getConsumerIdPk() {
		System.out.println("ConsumerVo.getConsumerIdPk() 호출");
		return consumerIdPk;
	}
	
	public void setConsumerIdPk(String consumerIdPk) {
		System.out.println("ConsumerVo.setConsumerIdPk() 호출");
		this.consumerIdPk = consumerIdPk;
	}
	public String getConsumerPassword() {
		System.out.println("ConsumerVo.getConsumerPassword() 호출");
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
	public String getConsumerAddress() {
		return consumerAddress;
	}
	public void setConsumerAddress(String consumerAddress) {
		System.out.println("ConsumerVo.setConsumerAddress() 호출");
		this.consumerAddress = consumerAddress;
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
	public String getConsumerAdmitAdmin() {
		return consumerAdmitAdmin;
	}
	public void setConsumerAdmitAdmin(String consumerAdmitAdmin) {
		System.out.println("ConsumerVo.setConsumerAdmitAdmin() 호출");
		this.consumerAdmitAdmin = consumerAdmitAdmin;
	}
	public String getConsumerAdmitDate() {
		return consumerAdmitDate;
	}
	public void setConsumerAdmitDate(String consumerAdmitDate) {
		System.out.println("ConsumerVo.setConsumerAdmitDate() 호출");
		this.consumerAdmitDate = consumerAdmitDate;
	}
	
	@Override
	public String toString() {
		return "ConsumerVo [consumerIdPk=" + consumerIdPk + ", consumerPassword=" + consumerPassword + ", consumerName="
				+ consumerName + ", consumerEmail=" + consumerEmail + ", consumerJuminNo=" + consumerJuminNo
				+ ", consumerAddress=" + consumerAddress + ", consumerPhone=" + consumerPhone + ", consumerSignUpDate="
				+ consumerSignUpDate + ", consumerStatus=" + consumerStatus + ", consumerAdmitCheckFlag="
				+ consumerAdmitCheckFlag + ", consumerAdmitAdmin=" + consumerAdmitAdmin + ", consumerAdmitDate="
				+ consumerAdmitDate + "]";
	}
	
}
