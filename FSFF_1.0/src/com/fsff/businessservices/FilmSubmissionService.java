package com.fsff.businessservices;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.fsff.entity.Clip1;
import com.fsff.entity.Clip2;
import com.fsff.entity.Clip3;
import com.fsff.entity.Festival;
import com.fsff.entity.Film;
import com.fsff.entity.Genre;
import com.fsff.entity.User;
import com.fsff.sessionmanager.SessionManager;
import com.fsff.util.StringManipulation;

public class FilmSubmissionService implements FilmSubmission {

	@Override
	public boolean submitFilm(String filmName, String genre,
			String filmDescription, String cast, String director,
			String producer, String writer, String roundOneClip,
			String roundTwoClip, String roundThreeClip, int userId) {
		//TODO: Validate the strings
		if (StringManipulation.isNullOrEmpty(filmName)
				// || StringManipulation.isNullOrEmpty(filmDescription)
				|| StringManipulation.isNullOrEmpty(roundOneClip)
				|| StringManipulation.isNullOrEmpty(roundTwoClip)
				|| StringManipulation.isNullOrEmpty(roundThreeClip)) {
			return false;
		}
		SessionManager.createSession();
		SessionManager.createEntityManager();
		EntityManager entityManager = SessionManager.getEntityManager();
		Festival addToFestival;
		User addFilmToUser;
		Query userQuery = entityManager.createQuery("from User where id = '"
				+ userId + "'");
		List userList = userQuery.getResultList();
		if (userList == null || userList.isEmpty()) {
			return false;
		}
		addFilmToUser = (User) userList.get(0);
		Set<Film> userFilms = addFilmToUser.getFilms();

		// boolean activeStatus = true;
		Query festivalQuery = entityManager
				.createQuery("from Festival where active = 1");
		List festivalList = festivalQuery.getResultList();
		if (festivalList == null || festivalList.isEmpty()) {
			return false;
		}
		addToFestival = (Festival) festivalList.get(0);
		Set<Film> films = addToFestival.getFilms();
		Query genreQuery = entityManager
				.createQuery("from Genre where genre = '" + genre + "'");
		List genreType = genreQuery.getResultList();
		if (genreType == null || genreType.isEmpty()) {
			return false;
		}
		Genre filmGenre = (Genre) genreType.get(0);
		Film newFilm = new Film();
		newFilm.setFilmName(filmName);
		newFilm.setGenre(filmGenre);
		newFilm.setFilmDescription(filmDescription);
		newFilm.setCast(cast);
		newFilm.setDirector(director);
		newFilm.setProducer(producer);
		newFilm.setWriter(writer);
		Clip1 clip1Link = new Clip1();
		clip1Link.setClipLink(roundOneClip);
		clip1Link.setQualified(false);
		clip1Link.setVoteCount(0);
		clip1Link.setFilm(newFilm);
		Clip2 clip2Link = new Clip2();
		clip2Link.setClipLink(roundTwoClip);
		clip2Link.setQualified(false);
		clip2Link.setVoteCount(0);
		clip2Link.setFilm(newFilm);
		Clip3 clip3Link = new Clip3();
		clip3Link.setClipLink(roundThreeClip);
		clip3Link.setQualified(false);
		clip3Link.setVoteCount(0);
		clip3Link.setFilm(newFilm);
		newFilm.setRoundOneClip(clip1Link);
		newFilm.setRoundTwoClip(clip2Link);
		newFilm.setRoundThreeClip(clip3Link);
		newFilm.setFullMovieReceived(false);
		newFilm.setFestivalId(addToFestival);
		// TODO: Use a table for status
		newFilm.setStatus("Submitted");
		Calendar cal = java.util.Calendar.getInstance();
		Date timeNow = new Date(cal.getTimeInMillis());
		System.out.println(timeNow);
		newFilm.setSubmissionDate(timeNow);
		newFilm.setLastStatusUpdateDate(timeNow);

		userFilms.add(newFilm);
		addFilmToUser.setFilms(userFilms);
		films.add(newFilm);
		addToFestival.setFilms(films);
		entityManager.getTransaction().begin();
		entityManager.persist(newFilm);
		entityManager.persist(filmGenre);
		entityManager.persist(clip1Link);
		entityManager.persist(clip2Link);
		entityManager.persist(clip3Link);

		entityManager.merge(addToFestival);
		entityManager.merge(addFilmToUser);
		entityManager.getTransaction().commit();
		return false;
	}

}
