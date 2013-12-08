package com.fsff.util;

import java.util.Comparator;

import com.fsff.entity.Film;

public class SubmittedFilmComparator implements Comparator<Film> {

	@Override
	public int compare(Film film1, Film film2) {
		int comp = film1.getStatus().compareTo(film2.getStatus());
		if (comp == 0) {
			return film1.getFilmName().compareTo(film2.getFilmName());
		} else
			return comp;

	}
}
