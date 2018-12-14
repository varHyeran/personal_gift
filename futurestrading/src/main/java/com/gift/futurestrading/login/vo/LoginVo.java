package com.gift.futurestrading.login.vo;

public class LoginVo {
	private String totalId;			/*아이디*/
	private String totalPassword;	/*비밀번호*/
	private String totalRight;		/*권한*/
	public String getTotalId() {
		return totalId;
	}
	public void setTotalId(String totalId) {
		this.totalId = totalId;
	}
	public String getTotalPassword() {
		return totalPassword;
	}
	public void setTotalPassword(String totalPassword) {
		this.totalPassword = totalPassword;
	}
	public String getTotalRight() {
		return totalRight;
	}
	public void setTotalRight(String totalRight) {
		this.totalRight = totalRight;
	}
	@Override
	public String toString() {
		return "LoginVo [totalId=" + totalId + ", totalPassword=" + totalPassword + ", totalRight=" + totalRight + "]";
	}
	
}
