package com.fsff.businessservices;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.fsff.entity.Film;
import com.fsff.entity.Login;
import com.fsff.entity.User;
import com.fsff.entity.Vote;
import com.fsff.sessionmanager.SessionManager;

public class FilmRatingService implements FilmRating {

	@Override
	public void rateFilm(int filmId, int userId, int starValue) {
		SessionManager.createSession();
		SessionManager.createEntityManager();
		EntityManager entityManager = SessionManager.getEntityManager();
		Query filmQuery = entityManager.createQuery("from Film where id='"
				+ filmId + "'");
		List filmList = filmQuery.getResultList();
		if (filmList == null || filmList.isEmpty()) {
			return;
		}
		Film film = (Film) filmList.get(0);
		Vote vote = film.getVote();
		Query userQuery = entityManager.createQuery(" from User where id='"
				+ userId + "'");
		List userList = userQuery.getResultList();
		if (userList == null || userList.isEmpty()) {
			return;
		}
		User user = (User) userList.get(0);
		Login login = user.getLoginDetails();
		int weight = login.getUserType().getUserWeight();
		long filmRate = calculateRating(vote, weight, starValue);
		vote.setScore(filmRate);
		film.setVote(vote);
		entityManager.getTransaction().begin();
		entityManager.persist(vote);
		entityManager.merge(film);
		entityManager.getTransaction().commit();
		SessionManager.closeEntityManager();

	}

	private long calculateRating(Vote vote, int userWeight, int starValue) {
		long score = 0;
		int value = 1;
		long numberOfVotes = vote.getNumberOfVotes();
		vote.setNumberOfVotes(++numberOfVotes);
		if (starValue == 1) {
			if (vote.getStarValue1() == 0) {

				vote.setStarValue1(1);
			} else {
				vote.setStarValue1(vote.getStarValue1() + 1);
			}
		} else if (starValue == 2) {
			if (vote.getStarValue2() == 0) {
				vote.setStarValue2(1);
			} else {
				vote.setStarValue2(vote.getStarValue2() + 1);
			}
		} else if (starValue == 3) {
			if (vote.getStarValue3() == 0) {
				vote.setStarValue3(1);
			} else {
				vote.setStarValue3(vote.getStarValue3() + 1);
			}
		} else if (starValue == 4) {
			if (vote.getStarValue4() == 0) {
				vote.setStarValue4(1);
			} else {
				vote.setStarValue4(vote.getStarValue4() + 1);
			}
		} else if (starValue == 5) {
			if (vote.getStarValue5() == 0) {
				vote.setStarValue5(1);
			} else {
				vote.setStarValue5(vote.getStarValue5() + 1);
			}
		}
		score = (vote.getStarValue1() * STAR_VALUE[0] + vote.getStarValue2()
				* STAR_VALUE[1] + vote.getStarValue3() * STAR_VALUE[2]
				+ vote.getStarValue4() * STAR_VALUE[3] + vote.getStarValue5()
				* STAR_VALUE[4]);
		score = score * userWeight;
		score = score / vote.getNumberOfVotes();
		return score;
	}
}
