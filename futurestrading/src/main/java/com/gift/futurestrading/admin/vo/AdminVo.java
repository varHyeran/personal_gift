package com.gift.futurestrading.admin.vo;

public class AdminVo {
	private String adminId;				/*관리자아이디*/
	private String adminPw;				/*관리자비밀번호*/
	private String adminName;			/*관리자이름*/
	private String adminRight;			/*권한*/
	private String adminRegisterDate;	/*등록날짜*/
	
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
		System.out.println(adminId + "<-- setAdminId");
	}
	public String getAdminPw() {
		return adminPw;
	}
	public void setAdminPw(String adminPw) {
		this.adminPw = adminPw;
		System.out.println(adminPw + "<-- setAdminPw");
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
		System.out.println(adminName + "<-- setAdminName");
	}
	public String getAdminRight() {
		return adminRight;
	}
	public void setAdminRight(String adminRight) {
		this.adminRight = adminRight;
		System.out.println(adminRight + "<-- setAdminRight");
	}
	public String getAdminRegisterDate() {
		return adminRegisterDate;
	}
	public void setAdminRegisterDate(String adminRegisterDate) {
		this.adminRegisterDate = adminRegisterDate;
		System.out.println(adminRegisterDate + "<-- setAdminRegisterDate");
	}
	@Override
	public String toString() {
		return "AdminVo [adminId=" + adminId + ", adminPw=" + adminPw + ", adminName=" + adminName + ", adminRight="
				+ adminRight + ", adminRegisterDate=" + adminRegisterDate + "]";
	}
}
