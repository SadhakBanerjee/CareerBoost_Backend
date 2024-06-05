//package com.careerboost.dto;
//
//public class ApiResponseDto {
//
//	private String successMessage="User Registered Succesfully";
//
//	public String getSuccessMessage() {
//		return successMessage;
//	}
//
//	public void setSuccessMessage(String successMessage) {
//		this.successMessage = successMessage;
//	}
//	
//}

package com.careerboost.dto;


public class ApiResponseDto {
    private UserDto user;
    private String message;

    public ApiResponseDto(UserDto user, String message) {
        this.user = user;
        this.message = message;
    }

    // Getters and Setters
    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
