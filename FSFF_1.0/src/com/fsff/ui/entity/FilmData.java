package com.fsff.ui.entity;

import java.io.Serializable;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class FilmData implements Serializable {

	private static final long serialVersionUID = 1L;

	public String film;

	public int filmId;

	public String clipURL;

	public String cast;

	public String director;

	public String producer;

	public String writer;

	public String score;

	public String getFilm() {
		return film;
	}

	public void setFilm(String film) {
		this.film = film;
	}

	public int getFilmId() {
		return filmId;
	}

	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}

	public String getClipURL() {
		return clipURL;
	}

	public void setClipURL(String clipURL) {
		this.clipURL = clipURL;
	}

	public String getCast() {
		return cast;
	}

	public void setCast(String cast) {
		this.cast = cast;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String toJson(FilmData[] films) {
		GsonBuilder gsonBuilder = new GsonBuilder();
		Gson gson = gsonBuilder.disableHtmlEscaping()
				.registerTypeAdapter(FilmData.class, new FilmDataAdapter())
				.create();
		return gson.toJson(films);
	}

}
