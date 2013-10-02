package com.fsff.businessservices;

public interface FilmSubmission {
	public boolean submitFilm(String filmName, String genre,
			String filmDescription, String roundOneClip, String roundTwoClip,
			String roundThreeClip,int userId);
}
