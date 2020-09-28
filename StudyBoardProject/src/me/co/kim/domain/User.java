package me.co.kim.domain;

// user 도메인을 정의합니다.
public class User {
	
	// 유저의 인덱스 값입니다. 데이터베이스에서 primary key 입니다.
	private int user_idx; 
	
	// 유저 이름입니다.
	private String user_name;
	
	// 유저 아이디 입니다.
	private String user_id;
	
	// 유저 패스워드입니다.
	private String user_pw;
	
	// 유저 핸드폰 번호입니다. 
    private String user_phone;
    
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
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
    
    
}
