package com.fsff.businessservices;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.fsff.entity.Film;
import com.fsff.entity.Genre;
import com.fsff.sessionmanager.SessionManager;
import com.fsff.ui.entity.FilmData;

public class ViewFilmService implements ViewFilm {

	@Override
	public FilmData[] viewFilms(String genre) {
		Set<Film> films = null;
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
		films = new HashSet<Film>(filmList);
		filmData = convertFilmToData(films);
		return filmData;
	}
	
	private FilmData[] convertFilmToData(Set<Film> films){
		if(films==null || films.isEmpty()){
			return null;
		}
		FilmData[] filmData = new FilmData[films.size()];
		int iter = 0;
		for(Film film: films){
			FilmData filmDataObject = new FilmData();
			filmDataObject.setFilm(film.getFilmName());
			filmDataObject.setClipURL(film.getRoundOneClip().getClipLink());
			filmDataObject.setCast(film.getCast());
			filmDataObject.setDirector(film.getDirector());
			filmDataObject.setProducer(film.getProducer());
			filmDataObject.setWriter(film.getWriter());
			filmDataObject.setRating("5");
			filmData[iter++]= filmDataObject;
		}
		return filmData;
	}

}
