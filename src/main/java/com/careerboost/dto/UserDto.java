//package com.careerboost.dto;
//
//public class UserDto {
//	
//	private Long userId;
//	
//	private String emailId;
//	
//
//	public Long getUserId() {
//		return userId;
//	}
//
//	public void setUserId(Long userId) {
//		this.userId = userId;
//	}
//
//	public String getEmailId() {
//		return emailId;
//	}
//
//	public void setEmailId(String emailId) {
//		this.emailId = emailId;
//	}
//}

package com.careerboost.dto;

public class UserDto {
	
	private Long userId;
	private String emailId;
	private String userName;
	private String message;

	public UserDto() {
	}

	public UserDto(Long userId, String userName, String emailId, String message) {
		this.userId = userId;
		this.emailId = emailId;
		this.userName = userName;
		this.message = message;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	

	public String getMessage() {
		return message;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
