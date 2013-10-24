package com.fsff.businessservices;

import com.fsff.ui.entity.FilmData;

public interface SearchFilm {
	public FilmData[] searchFilmByName(String filmName);
	public FilmData[] searchFilmByDirector(String director);
	public FilmData[] searchFilmByCase(String cast);
	public FilmData[] searchFilmByProducer(String producer);
	public FilmData[] searchFilmByWriter(String writer);
	
}
