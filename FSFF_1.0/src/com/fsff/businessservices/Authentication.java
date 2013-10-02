package com.fsff.businessservices;

import com.fsff.ui.entity.UserSession;

public interface Authentication {
	
	public UserSession login(String login,String password);
	
	public boolean signUp(String firstName, String lastName, String login, String password, String confirmPassword, String forgotPasswordQuestion, String forgotPasswordAnswer, String userType);

}
