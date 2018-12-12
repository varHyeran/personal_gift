package com.gift.futurestrading.member.vo;

public class ConsumerVo {
	
	private String consumerIdPk;		// 아이디
	private String consumerPassword;	// 비밀번호
	private String consumerName;		// 이름
	private String consumerEmail;		// 이메일
	private String consumerJuminNo;		// 주민번호
	private String consumerAddress;		// 주소
	private String consumerPhone;		// 전화번호
	public String getConsumerIdPk() {
		return consumerIdPk;
	}
	public void setConsumerIdPk(String consumerIdPk) {
		System.out.println(consumerIdPk+" <---ConsumerVo.setConsumerIdPk() 호출");
		this.consumerIdPk = consumerIdPk;
	}
	public String getConsumerPassword() {
		return consumerPassword;
	}
	public void setConsumerPassword(String consumerPassword) {
		System.out.println(consumerPassword+" <---ConsumerVo.setConsumerIdPk() 호출");
		this.consumerPassword = consumerPassword;
	}
	public String getConsumerName() {
		return consumerName;
	}
	public void setConsumerName(String consumerName) {
		System.out.println(consumerName+" <---ConsumerVo.setConsumerIdPk() 호출");
		this.consumerName = consumerName;
	}
	public String getConsumerEmail() {
		return consumerEmail;
	}
	public void setConsumerEmail(String consumerEmail) {
		System.out.println(consumerEmail+" <---ConsumerVo.setConsumerIdPk() 호출");
		this.consumerEmail = consumerEmail;
	}
	public String getConsumerJuminNo() {
		return consumerJuminNo;
	}
	public void setConsumerJuminNo(String consumerJuminNo) {
		System.out.println(consumerJuminNo+" <---ConsumerVo.setConsumerJuminNo() 호출");
		this.consumerJuminNo = consumerJuminNo;
	}
	public String getConsumerAddress() {
		return consumerAddress;
	}
	public void setConsumerAddress(String consumerAddress) {
		System.out.println(consumerAddress+" <---ConsumerVo.setConsumerAddress() 호출");
		this.consumerAddress = consumerAddress;
	}
	public String getConsumerPhone() {
		return consumerPhone;
	}
	public void setConsumerPhone(String consumerPhone) {
		System.out.println(consumerPhone+" <---ConsumerVo.setConsumerPhone() 호출");
		this.consumerPhone = consumerPhone;
	}

}
