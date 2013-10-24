package com.fsff.businessservices;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.fsff.entity.Film;
import com.fsff.entity.Genre;
import com.fsff.sessionmanager.SessionManager;
import com.fsff.ui.entity.FilmData;
import com.fsff.util.FilmDataManipulation;

public class ViewFilmService implements ViewFilm {

	@Override
	public FilmData[] viewFilms(String genre) {
		List<Film> films = null;
		FilmData[] filmData = null;
		SessionManager.createSession();
		SessionManager.createEntityManager();
		EntityManager entityManager = SessionManager.getEntityManager();
		Query genreQuery = entityManager
				.createQuery(" from Genre where genre='" + genre + "'");
		List genreList = genreQuery.getResultList();
		if (genreList == null || genreList.isEmpty()) {
			return null;
		}
		Genre genreFromDB = (Genre) genreList.get(0);
		Query filmQuery = entityManager.createQuery("from Film where genre='"
				+ genreFromDB.getId() + "'");
		List filmList = filmQuery.getResultList();
		if (filmList == null || filmList.isEmpty()) {
			return null;
		}
		filmData = FilmDataManipulation.convertFilmToData(filmList);
		return filmData;
	}

}
