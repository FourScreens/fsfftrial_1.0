package com.fsff.businessservices;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.fsff.entity.Festival;
import com.fsff.entity.Film;
import com.fsff.entity.Genre;
import com.fsff.sessionmanager.SessionManager;
import com.fsff.ui.entity.FilmData;
import com.fsff.util.FilmDataManipulation;

public class ViewFilmService implements ViewFilm {

	private static final String SUBMISSION = "Films Submission";
	private static final String ROUND_ONE = "Round One";
	private static final String ROUND_TWO = "Round Two";
	private static final String ROUND_THREE = "Round Three";
	private static final String NO_FESTIVAL = "noFestival";
	private static final String REJECTED = "Rejected";
	private static final String APPROVED = "Approved";

	@Override
	public FilmData[] viewFilms(String genre) {
		List<Film> films = null;
		FilmData[] filmData = null;
		SessionManager.createSession();
		SessionManager.createEntityManager();
		EntityManager entityManager = SessionManager.getEntityManager();
		Query festivalQuery = entityManager
				.createQuery("from Festival where active = 1");
		List festivalList = festivalQuery.getResultList();
		if (festivalList == null || (festivalList.isEmpty())) {
			// TODO: Handle this case
		}
		Festival festival = (Festival) festivalList.get(0);
		Query genreQuery = entityManager
				.createQuery(" from Genre where genre='" + genre + "'");
		List genreList = genreQuery.getResultList();
		if (genreList == null || genreList.isEmpty()) {
			return null;
		}
		Genre genreFromDB = (Genre) genreList.get(0);
		Query filmQuery = entityManager.createQuery("from Film where genre='"
				+ genreFromDB.getId() + "'");
		List<Film> filmList = filmQuery.getResultList();
		if (filmList == null || filmList.isEmpty()) {
			return null;
		}
		String msg = checkDateRangeApproveFilms(festival);
		if (msg.equals(SUBMISSION)) {
			filmList = filterApprovedSubmittedFilm(filmList);
		} else if (msg.equals(ROUND_ONE)) {
			filmList = filterApprovedRoundOneFilm(filmList);
		} else if (msg.equals(ROUND_TWO)) {
			filmList = filterApprovedRoundTwoFilm(filmList);
		} else if (msg.equals(ROUND_THREE)) {
			filmList = filterApprovedRoundThreeFilm(filmList);
		}
		filmData = FilmDataManipulation.convertFilmToData(filmList);
		return filmData;
	}

	public List<Film> filterApprovedSubmittedFilm(List<Film> filmList) {
		List<Film> tempList = new ArrayList<Film>();
		for (Film film : filmList) {
			if (film.getStatus().equals(APPROVED)) {
				tempList.add(film);
			}
		}
		return tempList;
	}

	public List<Film> filterApprovedRoundOneFilm(List<Film> filmList) {
		List<Film> tempList = new ArrayList<Film>();
		for (Film film : filmList) {
			if (film.getRoundOneStatus().equals(APPROVED)) {
				tempList.add(film);
			}
		}
		return tempList;
	}

	public List<Film> filterApprovedRoundTwoFilm(List<Film> filmList) {
		List<Film> tempList = new ArrayList<Film>();
		for (Film film : filmList) {
			if (film.getRoundTwoStatus().equals(APPROVED)) {
				tempList.add(film);
			}
		}
		return tempList;
	}

	public List<Film> filterApprovedRoundThreeFilm(List<Film> filmList) {
		List<Film> tempList = new ArrayList<Film>();
		for (Film film : filmList) {
			if (film.getRoundThreeStatus().equals(APPROVED)) {
				tempList.add(film);
			}
		}
		return tempList;
	}

	public String checkDateRangeApproveFilms(Festival festival) {
		String msg = "";
		Date now = new Date();
		if ((now.after(festival.getSubmissionStartDate()) && now
				.before(festival.getSubmissionEndDate()))
				|| (now.after(festival.getSubmissionEndDate()) && now
						.before(festival.getRoundOneStartDate()))) {
			msg = SUBMISSION;
		} else if ((now.after(festival.getRoundOneStartDate()) && now
				.before(festival.getRoundOneEndDate()))
				|| (now.after(festival.getRoundOneEndDate()) && now
						.before(festival.getRoundTwoStartDate()))) {
			msg = ROUND_ONE;
		} else if ((now.after(festival.getRoundTwoStartDate()) && now
				.before(festival.getRoundTwoEndDate()))
				|| (now.after(festival.getRoundTwoEndDate()) && now
						.before(festival.getRoundThreeStartDate()))) {
			msg = ROUND_TWO;
		} else if (now.after(festival.getRoundThreeStartDate())
				&& now.before(festival.getRoundThreeEndDate())) {
			msg = ROUND_THREE;
		} else {
			msg = NO_FESTIVAL;
		}
		return msg;
	}

}
