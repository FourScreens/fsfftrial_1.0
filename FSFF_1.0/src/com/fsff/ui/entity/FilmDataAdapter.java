package com.fsff.ui.entity;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class FilmDataAdapter implements JsonSerializer<FilmData> {

	@Override
	public JsonElement serialize(FilmData arg0, java.lang.reflect.Type arg1,
			JsonSerializationContext arg2) {
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("FilmId", arg0.getFilmId());
		jsonObject.addProperty("FilmName", arg0.getFilm());
		jsonObject.addProperty("url", arg0.getClipURL());
		jsonObject.addProperty("Cast", arg0.getCast());
		jsonObject.addProperty("Director", arg0.getDirector());
		jsonObject.addProperty("Producer", arg0.getProducer());
		jsonObject.addProperty("Writer", arg0.getWriter());
		jsonObject.addProperty("Score", arg0.getScore());
		return jsonObject;
	}

}