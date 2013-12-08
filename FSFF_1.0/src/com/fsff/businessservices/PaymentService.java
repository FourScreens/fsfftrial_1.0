package com.fsff.businessservices;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.fsff.entity.Film;
import com.fsff.sessionmanager.SessionManager;

public class PaymentService {

	public void paymentSuccess(int userId, String uFilmID) {
		if (userId > 0 && (uFilmID.equals(""))) {
			return;
		}
		String[] filmIdName = uFilmID.split("-");
		SessionManager.createSession();
		SessionManager.createEntityManager();
		EntityManager entityManager = SessionManager.getEntityManager();
		Query filmQuery = entityManager
				.createQuery("from Film where filmName = '" + filmIdName[1]
						+ "' ");
		List filmList = filmQuery.getResultList();
		if (filmList == null || filmList.isEmpty()) {
			return;
		}
		Film film = (Film) filmList.get(0);
		entityManager.getTransaction().begin();
		film.setPaid(true);
		entityManager.getTransaction().commit();
	}
}
