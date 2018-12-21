package com.gift.futurestrading.member.vo;

public class AccountOfConsumerRequestVo {

	private String fkConsumerAccountConsumer;	// 구매자 아이디
	private String accountConsumerName;			// 구매자 이름
	private String accountConsumerBankName;		// 은행 이름
	private String accountConsumerAccountNo;	// 계좌번호
	public String getFkConsumerAccountConsumer() {
		return fkConsumerAccountConsumer;
	}
	public void setFkConsumerAccountConsumer(String fkConsumerAccountConsumer) {
		System.out.println(fkConsumerAccountConsumer+" <---AccountOfConsumerRequest.setFkConsumerAccountConsumer() 호출");
		this.fkConsumerAccountConsumer = fkConsumerAccountConsumer;
	}
	public String getAccountConsumerName() {
		return accountConsumerName;
	}
	public void setAccountConsumerName(String accountConsumerName) {
		System.out.println(accountConsumerName+" <---AccountOfConsumerRequest.setAccountConsumerName() 호출");
		this.accountConsumerName = accountConsumerName;
	}
	public String getAccountConsumerBankName() {
		return accountConsumerBankName;
	}
	public void setAccountConsumerBankName(String accountConsumerBankName) {
		System.out.println(accountConsumerBankName+" <---AccountOfConsumerRequest.setAccountConsumerBankName() 호출");
		this.accountConsumerBankName = accountConsumerBankName;
	}
	public String getAccountConsumerAccountNo() {
		return accountConsumerAccountNo;
	}
	public void setAccountConsumerAccountNo(String accountConsumerAccountNo) {
		System.out.println(accountConsumerAccountNo+" <---AccountOfConsumerRequest.setAccountConsumerAccountNo() 호출");
		this.accountConsumerAccountNo = accountConsumerAccountNo;
	}
	@Override
	public String toString() {
		return "AccountOfConsumerRequestVo [fkConsumerAccountConsumer=" + fkConsumerAccountConsumer
				+ ", accountConsumerName=" + accountConsumerName + ", accountConsumerBankName="
				+ accountConsumerBankName + ", accountConsumerAccountNo=" + accountConsumerAccountNo + "]";
	}
	
}
