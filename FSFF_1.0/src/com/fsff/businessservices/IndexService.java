package com.fsff.businessservices;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.fsff.entity.Festival;
import com.fsff.entity.Film;
import com.fsff.sessionmanager.SessionManager;
import com.fsff.ui.entity.FilmData;
import com.fsff.util.FilmComparatorByVotes;
import com.fsff.util.FilmDataManipulation;

public class IndexService {

	public FilmData[] indexEditorPicks() {
		List<Film> films = null;
		FilmData[] filmData = null;
		SessionManager.createSession();
		SessionManager.createEntityManager();
		EntityManager entityManager = SessionManager.getEntityManager();

		Query filmQuery = entityManager
				.createQuery("from Film where editorPicks = '1'");
		List<Film> leaderBoardFilmList = filmQuery.getResultList();

		filmData = FilmDataManipulation.convertFilmToData(leaderBoardFilmList);
		return filmData;
	}

	public FilmData[] indexLeaderBoardFilms(int numberOfFilms) {
		// List<Film> films = null;
		FilmData[] filmData = null;
		SessionManager.createSession();
		SessionManager.createEntityManager();
		EntityManager entityManager = SessionManager.getEntityManager();

		Query festivalQuery = entityManager
				.createQuery("from Festival where active = 1");

		List festivalList = festivalQuery.getResultList();
		if (festivalList.isEmpty()) {
			return null;
		}
		Festival festival = (Festival) festivalList.get(0);
		Set<Film> films = festival.getFilms();
		Set<Film> orderedFilms = new TreeSet<Film>(new FilmComparatorByVotes());
		orderedFilms.addAll(films);
		List<Film> orderedFilmList = new ArrayList<Film>();
		orderedFilmList.addAll(orderedFilms);
		List<Film> leaders = null;
		if (orderedFilmList.size() < numberOfFilms) {
			leaders = orderedFilmList;
		} else {
			leaders = orderedFilmList.subList(0, numberOfFilms);
		}
		filmData = FilmDataManipulation.convertFilmToData(leaders);
		return filmData;
	}
}
