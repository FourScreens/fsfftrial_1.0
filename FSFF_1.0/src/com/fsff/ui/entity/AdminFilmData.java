package com.fsff.ui.entity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class AdminFilmData {
	private String film;

	private int filmId;

	private String numberOfVotes;

	private String clipURL1;

	private String clipURL2;

	private String clipURL3;

	private String cast;

	private String director;

	private String producer;

	private String writer;

	private String score;

	private String status;

	private String filmUID;

	private boolean fullMovieReceived;

	private boolean feePaid;

	private boolean editorPicks;

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

	public String getNumberOfVotes() {
		return numberOfVotes;
	}

	public void setNumberOfVotes(String numberOfVotes) {
		this.numberOfVotes = numberOfVotes;
	}

	public String getClipURL1() {
		return clipURL1;
	}

	public void setClipURL1(String clipURL1) {
		this.clipURL1 = clipURL1;
	}

	public String getClipURL2() {
		return clipURL2;
	}

	public void setClipURL2(String clipURL2) {
		this.clipURL2 = clipURL2;
	}

	public String getClipURL3() {
		return clipURL3;
	}

	public void setClipURL3(String clipURL3) {
		this.clipURL3 = clipURL3;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFilmUID() {
		return filmUID;
	}

	public void setFilmUID(String filmUID) {
		this.filmUID = filmUID;
	}

	public boolean isFullMovieReceived() {
		return fullMovieReceived;
	}

	public void setFullMovieReceived(boolean fullMovieReceived) {
		this.fullMovieReceived = fullMovieReceived;
	}

	public boolean isFeePaid() {
		return feePaid;
	}

	public void setFeePaid(boolean feePaid) {
		this.feePaid = feePaid;
	}

	public boolean isEditorPicks() {
		return editorPicks;
	}

	public void setEditorPicks(boolean editorPicks) {
		this.editorPicks = editorPicks;
	}

	public String toJson(AdminFilmData[] films) {
		GsonBuilder gsonBuilder = new GsonBuilder();
		Gson gson = gsonBuilder
				.disableHtmlEscaping()
				.registerTypeAdapter(AdminFilmData.class,
						new AdminFilmDataAdapter()).create();
		return gson.toJson(films);
	}
}
