package com.fsff.test;

import javax.persistence.EntityManager;

import com.fsff.entity.Address;
import com.fsff.sessionmanager.SessionManager;

public class BuildDB {

	public static void main(String[] args) {
		Address address = new Address();
//		EntityManagerFactory emfInstance = Persistence
//				.createEntityManagerFactory("com.fsff.festival");
		SessionManager.createSession();
		SessionManager.createEntityManager();
		EntityManager entityManager = SessionManager.getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(address);
		entityManager.getTransaction().commit();
		entityManager.close();

		// SessionManager.createSession();
		// SessionManager.createEntityManager();
		// EntityManager entityManager = SessionManager.getEntityManager();
		// AuthenticationService obj = new AuthenticationService();
		// obj.signUp("firstName", "lastName", "login", "password", "password",
		// "forgotPasswordQuestion", "forgotPasswordAnswer", "userType");
		// System.out.println(obj.login("login", "password"));
		// FilmSubmissionService films = new FilmSubmissionService();
		// films.submitFilm("filmName", "Comedy", "filmDescription",
		// "roundOneClip", "roundTwoClip", "roundThreeClip",1);

	}
}
