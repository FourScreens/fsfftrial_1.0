package com.fsff.businessservices;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.fsff.entity.Login;
import com.fsff.entity.User;
import com.fsff.sessionmanager.SessionManager;
import com.fsff.ui.entity.UserSession;
import com.fsff.util.StringManipulation;

public class AuthenticationService implements Authentication {

	/**
	 * Default constructor
	 */
	public AuthenticationService() {
	}

	/**
	 * login method authenticates the user with the given login and password
	 * 
	 * @param login
	 *            - login id(usually email)
	 * @param password
	 *            - password required to login
	 * @return boolean - returns true if the user is authenticated else returns
	 *         false
	 */
	@Override
	public UserSession login(String login, String password) {
		//int userId = -1;
		UserSession userSession = null;
		if (StringManipulation.isNullOrEmpty(login)
				&& StringManipulation.isNullOrEmpty(password)) {
			return userSession;
		}

		SessionManager.createSession();
		SessionManager.createEntityManager();
		EntityManager entityManager = SessionManager.getEntityManager();
		Query loginQuery = entityManager.createQuery("from Login where login = '"
				+ login+"'");
		List allLogin = loginQuery.getResultList();
		if (allLogin != null && (!allLogin.isEmpty())) {
			Login checkLogin = (Login) allLogin.get(0);
			if (password.equals(checkLogin.getPassword())) {
				userSession = new UserSession();
				userSession.setId(checkLogin.getId());
				userSession.setFirstName(checkLogin.getLogin());
			}
		}
		return userSession;
	}

	/**
	 * signup method to create new user. Creates a new user and stores the login
	 * details.
	 * 
	 * @param firstName
	 *            - fist name of the user
	 * @param lastName
	 *            - last name of the user
	 * @param login
	 *            - login id of the user(email id by default to have uniqueness
	 *            in login id)
	 * @param password
	 *            - password for the login
	 * @param confirmPassword
	 *            - password confirmation
	 * @param forgotPasswordQuestion
	 *            - question provided by the user to revoke forgot password
	 * @param forgotPasswordAnswer
	 *            - answer for the previous question
	 * @param userType
	 *            - type of user( viewer, film maker)
	 * @return boolean - true if the user registration succeeds
	 */
	@Override
	public boolean signUp(String firstName, String lastName, String login,
			String password, String confirmPassword,
			String forgotPasswordQuestion, String forgotPasswordAnswer,
			String userType) {

		if (StringManipulation.isNullOrEmpty(firstName)
				|| StringManipulation.isNullOrEmpty(lastName)
				|| StringManipulation.isNullOrEmpty(login)
				|| StringManipulation.isNullOrEmpty(password)
				|| StringManipulation.isNullOrEmpty(confirmPassword)
				|| StringManipulation.isNullOrEmpty(userType)) {
			return false;
		}

		if (!password.equals(confirmPassword)) {
			return false;
		}
		User newUser = new User();
		newUser.setFirstName(firstName);
		newUser.setLastName(lastName);
		Login createLogin = new Login();
		createLogin.setLogin(login);
		createLogin.setPassword(password);
		createLogin.setForgotPasswordQuestion(forgotPasswordQuestion);
		createLogin.setForgotPasswordAnswer(forgotPasswordAnswer);
		createLogin.setUserType(userType);	
		createLogin.setUser(newUser);
		newUser.setLoginDetails(createLogin);
		SessionManager.createSession();
		SessionManager.createEntityManager();
		EntityManager entityManager = SessionManager.getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(newUser);
		entityManager.persist(createLogin);
		entityManager.flush();
		System.out.println(newUser.getId());
		entityManager.getTransaction().commit();
		SessionManager.closeEntityManager();
		return true;
	}
}
