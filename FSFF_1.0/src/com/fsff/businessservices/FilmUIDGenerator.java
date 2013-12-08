package com.fsff.businessservices;

public class FilmUIDGenerator {

	public String generateFilmSubmissionID(int id, String year, String quarter) {
		String filmUID = "";
		StringBuilder sb = new StringBuilder();
		sb.append(year);
		String quartToAppend = quarter.substring(0, 3).toUpperCase();
		sb.append(quartToAppend);
		sb.append(id);
		filmUID = sb.toString();
		return filmUID;
	}

}
