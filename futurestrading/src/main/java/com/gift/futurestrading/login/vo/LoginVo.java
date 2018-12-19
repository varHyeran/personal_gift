package com.gift.futurestrading.login.vo;

public class LoginVo {
	private String sessionId;			/*아이디*/
	private String sessionPassword;	/*비밀번호*/
	private String sessionRight;		/*권한*/
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public String getSessionPassword() {
		return sessionPassword;
	}
	public void setSessionPassword(String sessionPassword) {
		this.sessionPassword = sessionPassword;
	}
	public String getSessionRight() {
		return sessionRight;
	}
	public void setSessionRight(String sessionRight) {
		this.sessionRight = sessionRight;
	}
	@Override
	public String toString() {
		return "LoginVo [sessionId=" + sessionId + ", sessionPassword=" + sessionPassword + ", sessionRight="
				+ sessionRight + "]";
	}
	
}
