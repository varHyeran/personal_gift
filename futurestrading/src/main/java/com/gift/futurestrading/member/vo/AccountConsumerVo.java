package com.gift.futurestrading.member.vo;

public class AccountConsumerVo {
	private String accountNoPk;
	private String fkConsumerAccountConsumer;
	private String accountConsumerName;
	private int accountConsumerAccountNo;
	private String accountConsumerBankName;
	private String accountConsumerSignUpDate;
	public String getAccountNoPk() {
		return accountNoPk;
	}
	public void setAccountNoPk(String accountNoPk) {
		this.accountNoPk = accountNoPk;
	}
	public String getFkConsumerAccountConsumer() {
		return fkConsumerAccountConsumer;
	}
	public void setFkConsumerAccountConsumer(String fkConsumerAccountConsumer) {
		this.fkConsumerAccountConsumer = fkConsumerAccountConsumer;
	}
	public String getAccountConsumerName() {
		return accountConsumerName;
	}
	public void setAccountConsumerName(String accountConsumerName) {
		this.accountConsumerName = accountConsumerName;
	}
	public int getAccountConsumerAccountNo() {
		return accountConsumerAccountNo;
	}
	public void setAccountConsumerAccountNo(int accountConsumerAccountNo) {
		this.accountConsumerAccountNo = accountConsumerAccountNo;
	}
	public String getAccountConsumerBankName() {
		return accountConsumerBankName;
	}
	public void setAccountConsumerBankName(String accountConsumerBankName) {
		this.accountConsumerBankName = accountConsumerBankName;
	}
	public String getAccountConsumerSignUpDate() {
		return accountConsumerSignUpDate;
	}
	public void setAccountConsumerSignUpDate(String accountConsumerSignUpDate) {
		this.accountConsumerSignUpDate = accountConsumerSignUpDate;
	}
	@Override
	public String toString() {
		return "AccountConsumerVo [accountNoPk=" + accountNoPk + ", fkConsumerAccountConsumer="
				+ fkConsumerAccountConsumer + ", accountConsumerName=" + accountConsumerName
				+ ", accountConsumerAccountNo=" + accountConsumerAccountNo + ", accountConsumerBankName="
				+ accountConsumerBankName + ", accountConsumerSignUpDate=" + accountConsumerSignUpDate + "]";
	}
	
	
}
