package com.fsff.ui.entity;

import java.io.Serializable;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class FilmData implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String film;

	public String clipURL;
	
	public String cast;
	
	public String director;
	
	public String producer;
	
	public String writer;
	
	public String rating;

	public String getFilm() {
		return film;
	}

	public void setFilm(String film) {
		this.film = film;
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

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}
	

	public String toJson(FilmData[] films) {  
	    GsonBuilder gsonBuilder = new GsonBuilder();
	    Gson gson = gsonBuilder.registerTypeAdapter(FilmData.class, new FilmDataAdapter()).create();
	    return gson.toJson(films);
	}  

	
}
