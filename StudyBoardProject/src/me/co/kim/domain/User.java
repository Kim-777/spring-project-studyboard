package me.co.kim.domain;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

// user 도메인을 정의합니다.
public class User {
	
	// 유저의 인덱스 값입니다. 데이터베이스에서 primary key 입니다.
	private int user_idx; 
	
	// 유저 이름입니다.
	//2~6글자만 받을 수 있습니다.
	@Size(min=2, max=6)
	//한글만 받을수 있는 정규식입니다.
	@Pattern(regexp="[가-힣]*")
	private String user_name;
	
	// 유저 아이디 입니다.
	@Size(min=4, max=20)
	@Pattern(regexp = "[a-zA-Z0-9]*")
	private String user_id;
	
	// 유저 패스워드입니다.
	@Size(min=8, max=20)
	@Pattern(regexp = "[a-zA-Z0-9]*")
	private String user_pw;
	
	// 유저 패스워드 확인 입니다.
	@Size(min=8, max=20)
	@Pattern(regexp = "[a-zA-Z0-9]*")
	private String user_pw_chk;
	
	// 기존에 존재하는 id인지 확인해주는 변수입니다.
	private boolean userIdExist;
	
	// 로그인한 상태인지 확인해주는 변수입니다.
	private boolean userLogin;
	
	public User() {
		this.userIdExist = false;
		this.userLogin = false;
	}
    
    // getter, setter 메서드를 정의합니다.
	public int getUser_idx() {
		return user_idx;
	}
	public void setUser_idx(int user_idx) {
		this.user_idx = user_idx;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	
	public String getUser_pw_chk() {
		return user_pw_chk;
	}
	public void setUser_pw_chk(String user_pw_chk) {
		this.user_pw_chk = user_pw_chk;
	}

	public boolean isUserIdExist() {
		return userIdExist;
	}

	public void setUserIdExist(boolean userIdExist) {
		this.userIdExist = userIdExist;
	}

	public boolean isUserLogin() {
		return userLogin;
	}

	public void setUserLogin(boolean userLogin) {
		this.userLogin = userLogin;
	}
	

    
}
