package com.fsff.util;

import java.util.List;
import java.util.Set;

import com.fsff.entity.Film;
import com.fsff.ui.entity.AdminFilmData;
import com.fsff.ui.entity.FilmData;

public class FilmDataManipulation {
	private static final String SUBMISSION = "Films Submission";
	private static final String ROUND_ONE = "Round One";
	private static final String ROUND_TWO = "Round Two";
	private static final String ROUND_THREE = "Round Three";

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
			double score = film.getVotes().getFinal_Rating();
			filmDataObject.setScore("" + score);
			filmData[iter++] = filmDataObject;
		}
		return filmData;
	}

	public static AdminFilmData[] convertFilmToAdminData(Set<Film> films,
			String round) {
		if (films == null || films.isEmpty()) {
			return null;
		}
		AdminFilmData[] filmData = new AdminFilmData[films.size()];
		int iter = 0;
		for (Film film : films) {
			AdminFilmData filmDataObject = new AdminFilmData();
			filmDataObject.setFilm(film.getFilmName());
			filmDataObject.setFilmId(film.getId());
			filmDataObject.setClipURL1(film.getRoundOneClip().getClipLink());
			filmDataObject.setClipURL2(film.getRoundTwoClip().getClipLink());
			filmDataObject.setClipURL3(film.getRoundThreeClip().getClipLink());
			filmDataObject.setCast(film.getCast());
			filmDataObject.setDirector(film.getDirector());
			filmDataObject.setProducer(film.getProducer());
			filmDataObject.setWriter(film.getWriter());
			filmDataObject.setEditorPicks(film.isEditorPicks());
			filmDataObject.setFeePaid(film.isPaid());
			if (round.equals(SUBMISSION)) {
				filmDataObject.setStatus(film.getStatus());
			} else if (round.equals(ROUND_ONE)) {
				filmDataObject.setStatus(film.getRoundOneStatus());
			} else if (round.equals(ROUND_TWO)) {
				filmDataObject.setStatus(film.getRoundTwoStatus());
			} else if (round.equals(ROUND_THREE)) {
				filmDataObject.setStatus(film.getRoundThreeStatus());
			}
			filmDataObject.setFilmUID(film.getFilmUID());
			filmDataObject.setFullMovieReceived(film.isFullMovieReceived());
			double score = film.getVotes().getFinal_Rating();
			filmDataObject.setScore("" + score);
			long numberOfVotes = film.getNumberOfVotes();
			filmDataObject.setNumberOfVotes("" + numberOfVotes);
			filmData[iter++] = filmDataObject;
		}
		return filmData;
	}
}
