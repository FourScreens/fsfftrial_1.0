package com.fsff.businessservices;

import java.util.HashMap;
import java.util.Map;

public interface FilmRating {

	public static final int[] STAR_VALUE = { -1, 0, 1, 2, 3 };

	public static enum USER_TYPE {
		VIEWER, REGISTERED, JURY
	}

	public static final int[] USER_WEIGHT = { 1, 5, 10 };
	public static final int[] USER_TYPE = null;

	public void rateFilm(int filmId, int userId, int starValue);
}
