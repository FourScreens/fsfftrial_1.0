package com.fsff.ui.entity;

import java.lang.reflect.Type;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class AdminFilmDataAdapter implements JsonSerializer<AdminFilmData> {

	@Override
	public JsonElement serialize(AdminFilmData arg0, Type arg1,
			JsonSerializationContext arg2) {
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("FilmId", arg0.getFilmId());
		jsonObject.addProperty("FilmName", arg0.getFilm());
		jsonObject.addProperty("url1", arg0.getClipURL1());
		jsonObject.addProperty("url2", arg0.getClipURL2());
		jsonObject.addProperty("url3", arg0.getClipURL3());
		jsonObject.addProperty("Cast", arg0.getCast());
		jsonObject.addProperty("Director", arg0.getDirector());
		jsonObject.addProperty("Producer", arg0.getProducer());
		jsonObject.addProperty("Writer", arg0.getWriter());
		jsonObject.addProperty("score", arg0.getScore());
		jsonObject.addProperty("numberOfVotes", arg0.getNumberOfVotes());
		jsonObject.addProperty("status", arg0.getStatus());
		jsonObject.addProperty("filmUID", arg0.getFilmUID());
		if (arg0.isFullMovieReceived()) {
			jsonObject.addProperty("fullMovieReceived", "Yes");
		} else {
			jsonObject.addProperty("fullMovieReceived", "No");
		}
		if (arg0.isFeePaid()) {
			jsonObject.addProperty("feePaid", "Yes");
		} else {
			jsonObject.addProperty("feePaid", "No");
		}
		if (arg0.isEditorPicks()) {
			jsonObject.addProperty("editorPicks", "Yes");
		} else {
			jsonObject.addProperty("editorPicks", "No");
		}
		return jsonObject;
	}
}
