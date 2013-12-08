package com.fsff.businessservices;

public interface FilmSubmission {
	public String submitFilm(String filmName, String genre,
			String filmDescription, String cast, String director,
			String producer, String writer, String roundOneClip,
			String roundTwoClip, String roundThreeClip, int userId);

}
