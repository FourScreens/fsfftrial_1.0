package com.fsff.businessservices;

public interface FilmSubmission {
	public boolean submitFilm(String filmName, String genre,
			String filmDescription, String cast, String director,
			String producer, String writer, String roundOneClip,
			String roundTwoClip, String roundThreeClip, int userId);

}
