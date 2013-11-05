package com.fsff.util;

import java.util.List;
import java.util.Set;

import com.fsff.entity.Film;
import com.fsff.ui.entity.FilmData;

public class FilmDataManipulation {
	public static FilmData[] convertFilmToData(List<Film> films) {
		if (films == null || films.isEmpty()) {
			return null;
		}
 		FilmData[] filmData = new FilmData[films.size()];
		int iter = 0;
		for (Film film : films) {
			FilmData filmDataObject = new FilmData();
			filmDataObject.setFilm(film.getFilmName());
			filmDataObject.setFilmId(film.getId());
			filmDataObject.setClipURL(film.getRoundOneClip().getClipLink());
			filmDataObject.setCast(film.getCast());
			filmDataObject.setDirector(film.getDirector());
			filmDataObject.setProducer(film.getProducer());
			filmDataObject.setWriter(film.getWriter());
			long score = film.getVote().getScore();
			filmDataObject.setScore(""+score);
			filmData[iter++] = filmDataObject;
		}
		return filmData;
	}
}
