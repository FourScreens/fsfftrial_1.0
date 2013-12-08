package com.fsff.admin.adminservices;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.fsff.entity.Admin;
import com.fsff.sessionmanager.SessionManager;
import com.fsff.ui.entity.AdminSession;
import com.fsff.util.StringManipulation;

public class AdminAuthenticationService implements AdminAuthentication {

	@Override
	public AdminSession login(String login, String password) {
		// int userId = -1;
		AdminSession adminSession = null;
		if (StringManipulation.isNullOrEmpty(login)
				&& StringManipulation.isNullOrEmpty(password)) {
			return adminSession;
		}

		SessionManager.createSession();
		SessionManager.createEntityManager();
		EntityManager entityManager = SessionManager.getEntityManager();
		Query loginQuery = entityManager
				.createQuery("from Admin where login = '" + login + "'");
		List allLogin = loginQuery.getResultList();
		if (allLogin != null && (!allLogin.isEmpty())) {
			Admin checkLogin = (Admin) allLogin.get(0);
			if (password.equals(checkLogin.getPassword())) {
				adminSession  = new AdminSession();
				adminSession .setId(checkLogin.getId());
				adminSession .setFirstName(checkLogin.getLogin());
			}
		}
		return adminSession ;
	}

}
