package com.gift.futurestrading.member.vo;
/**
 * 이 클래스는 구매자 회원가입 폼(addConsumer.html)에서 받아온 데이터들을 저장하는 인스턴스를 생성하는 클래스다.
 * 
 * @author	jsyangdev
 * @see		com.gift.futurestrading.member.vo.ConsumerRequestVo
 * @since	JDK1.8
 */
public class ConsumerRequestVo {
	
	private String consumerIdPk;		// 아이디
	private String consumerPassword;	// 비밀번호
	private String consumerName;		// 이름
	private String consumerEmail;		// 이메일
	private String consumerJuminNo;		// 주민번호
	private String postcode;			// 우편번호
	private String roadAddress;			// 도로명주소
	private String detailAddress;		// 상세주소
	private String consumerPhone;		// 전화번호
	public String getConsumerIdPk() {
		return consumerIdPk;
	}
	public void setConsumerIdPk(String consumerIdPk) {
		System.out.println(consumerIdPk+" <---ConsumerRequestVo.setConsumerIdPk() 호출");
		this.consumerIdPk = consumerIdPk;
	}
	public String getConsumerPassword() {
		return consumerPassword;
	}
	public void setConsumerPassword(String consumerPassword) {
		System.out.println(consumerPassword+" <---ConsumerRequestVo.setConsumerPassword() 호출");
		this.consumerPassword = consumerPassword;
	}
	public String getConsumerName() {
		return consumerName;
	}
	public void setConsumerName(String consumerName) {
		System.out.println(consumerName+" <---ConsumerRequestVo.setConsumerName() 호출");
		this.consumerName = consumerName;
	}
	public String getConsumerEmail() {
		return consumerEmail;
	}
	public void setConsumerEmail(String consumerEmail) {
		System.out.println(consumerEmail+" <---ConsumerRequestVo.setConsumerEmail() 호출");
		this.consumerEmail = consumerEmail;
	}
	public String getConsumerJuminNo() {
		return consumerJuminNo;
	}
	public void setConsumerJuminNo(String consumerJuminNo) {
		System.out.println(consumerJuminNo+" <---ConsumerRequestVo.setConsumerJuminNo() 호출");
		this.consumerJuminNo = consumerJuminNo;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		System.out.println(postcode+" <---ConsumerRequestVo.setPostcode() 호출");
		this.postcode = postcode;
	}
	public String getRoadAddress() {
		return roadAddress;
	}
	public void setRoadAddress(String roadAddress) {
		System.out.println(roadAddress+" <---ConsumerRequestVo.setRoadAddress() 호출");
		this.roadAddress = roadAddress;
	}
	public String getDetailAddress() {
		return detailAddress;
	}
	public void setDetailAddress(String detailAddress) {
		System.out.println(detailAddress+" <---ConsumerRequestVo.setDetailAddress() 호출");
		this.detailAddress = detailAddress;
	}
	public String getConsumerPhone() {
		return consumerPhone;
	}
	public void setConsumerPhone(String consumerPhone) {
		System.out.println(consumerPhone+" <---ConsumerRequestVo.setConsumerPhone() 호출");
		this.consumerPhone = consumerPhone;
	}
	
	@Override
	public String toString() {
		return "ConsumerRequestVo [consumerIdPk=" + consumerIdPk + ", consumerPassword=" + consumerPassword
				+ ", consumerName=" + consumerName + ", consumerEmail=" + consumerEmail + ", consumerJuminNo="
				+ consumerJuminNo + ", postcode=" + postcode + ", roadAddress=" + roadAddress + ", detailAddress="
				+ detailAddress + ", consumerPhone=" + consumerPhone + "]";
	}

}
