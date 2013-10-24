package com.fsff.businessservices;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.fsff.entity.Film;
import com.fsff.sessionmanager.SessionManager;
import com.fsff.ui.entity.FilmData;
import com.fsff.util.FilmDataManipulation;

public class SearchFilmService implements SearchFilm {

	Map<String, String> searchFilmQuery = null;
	private static final String DIRECTOR = "director";
	private static final String PRODUCER = "producer";
	private static final String CAST = "cast";
	private static final String WRITER = "writer";
	private static final String FILM_NAME = "filmName";

	public SearchFilmService() {
		searchFilmQuery = new HashMap<String, String>();
		searchFilmQuery.put(FILM_NAME, " from Film where filmName like ");
		searchFilmQuery.put(DIRECTOR, " from Film where director like ");
		searchFilmQuery.put(CAST, " from Film where cast like ");
		searchFilmQuery.put(PRODUCER, " from Film where producer like ");
		searchFilmQuery.put(WRITER, " from Film where writer like ");
	}

	private FilmData[] searchFilms(String searchCriteria, String searchString) {
		FilmRatingService serObj = new FilmRatingService();
		serObj.rateFilm(1, 1,1);
		FilmData[] filmData = null;
		SessionManager.createSession();
		SessionManager.createEntityManager();
		EntityManager entityManager = SessionManager.getEntityManager();
		Query searchFilms = entityManager.createQuery(searchFilmQuery
				.get(searchCriteria) + "'%" + searchString + "%'");
		List<Film> filmList = searchFilms.getResultList();
		if (filmList == null || filmList.isEmpty()) {
			return null;
		}
		filmData = FilmDataManipulation.convertFilmToData(filmList);
		return filmData;
	}

	@Override
	public FilmData[] searchFilmByName(String filmName) {
		FilmData[] films = searchFilms(FILM_NAME, filmName);
		return films;
	}

	@Override
	public FilmData[] searchFilmByDirector(String director) {
		FilmData[] films = searchFilms(DIRECTOR, director);
		return films;
	}

	@Override
	public FilmData[] searchFilmByProducer(String producer) {
		FilmData[] films = searchFilms(PRODUCER, producer);
		return films;
	}

	@Override
	public FilmData[] searchFilmByWriter(String writer) {
		FilmData[] films = searchFilms(WRITER, writer);
		return films;
	}

	@Override
	public FilmData[] searchFilmByCase(String cast) {
		FilmData[] films = searchFilms(CAST, cast);
		return films;
	}

}
