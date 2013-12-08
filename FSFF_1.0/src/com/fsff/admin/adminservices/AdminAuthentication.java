package com.fsff.admin.adminservices;

import com.fsff.ui.entity.AdminSession;

public interface AdminAuthentication {
	public AdminSession login(String login, String password);
}
