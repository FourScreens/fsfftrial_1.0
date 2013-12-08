package com.fsff.admin.adminservices;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.fsff.entity.Admin;
import com.fsff.entity.Film;
import com.fsff.entity.Login;
import com.fsff.entity.User;
import com.fsff.entity.Vote;
import com.fsff.entity.Votes;
import com.fsff.sessionmanager.SessionManager;

public class AdminRatingService {
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
		Votes votes = film.getVotes();
		Query userQuery = entityManager.createQuery(" from Admin where id='"
				+ userId + "'");
		List adminList = userQuery.getResultList();
		if (adminList == null || adminList.isEmpty()) {
			return;
		}
		Admin admin = (Admin) adminList.get(0);
		int weight = admin.getWeight();
		VoteRating voteRate = calculateRating(votes, weight, starValue);
		if (voteRate != null) {
			votes.setFinal_Rating(voteRate.rate);
			film.setNumberOfVotes(voteRate.numberOfVotes);
		}
		film.setVotes(votes);
		entityManager.getTransaction().begin();
		entityManager.persist(votes);
		entityManager.merge(film);
		entityManager.getTransaction().commit();
		SessionManager.closeEntityManager();

	}

	// TODO: Check this code
	private VoteRating calculateRating(Votes votes, int userWeight,
			int starValue) {
		if (votes == null)
			return null;
		Vote vote = null;
		for (Vote tempVote : votes.getVotes()) {
			if (tempVote.getStarWeight() == userWeight) {
				vote = tempVote;
			}
		}
		// vote = votes.getKeyValue(userWeight);
		VoteRating voteRating = new VoteRating();
		double mean = 0;
		long numberOfVotes = 0;
		switch (starValue) {
		case 1:
			vote.setStarValue1();
			break;
		case 2:
			vote.setStarValue2();
			break;
		case 3:
			vote.setStarValue3();
			break;
		case 4:
			vote.setStarValue4();
			break;
		case 5:
			vote.setStarValue5();
			break;
		}

		for (Vote each_vote : votes.getVotes()) {
			double numerator = each_vote.getWeightedSum();
			numberOfVotes += each_vote.getNumberOfVotes();
			double denominator = each_vote.getNumberOfVotes() * starValue;
			double div = 0.0;
			if (numerator != 0.0 && denominator != 0.0) {
				div = numerator / denominator;
			}
			div = div * starValue;
			mean = mean + div;
		}

		voteRating.rate = mean;
		voteRating.numberOfVotes = numberOfVotes;
		return voteRating;
	}
}

class VoteRating {
	double rate;
	long numberOfVotes;
}