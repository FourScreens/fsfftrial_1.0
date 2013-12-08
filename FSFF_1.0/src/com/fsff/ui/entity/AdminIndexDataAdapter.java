package com.fsff.ui.entity;

import java.lang.reflect.Type;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class AdminIndexDataAdapter implements JsonSerializer<AdminIndexData> {

	@Override
	public JsonElement serialize(AdminIndexData arg0, Type arg1,
			JsonSerializationContext arg2) {
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("festivalName", arg0.getFestivalName());
		jsonObject
				.addProperty("festivalStartDate", arg0.getFestivalStartDate());
		jsonObject
				.addProperty("roundOneStartDate", arg0.getRoundOneStartDate());
		jsonObject
				.addProperty("roundTwoStartDate", arg0.getRoundTwoStartDate());
		jsonObject.addProperty("roundThreeStartDate",
				arg0.getRoundThreeStartDate());
		jsonObject.addProperty("festivalEndDate", arg0.getFestivalEndDate());
		jsonObject.addProperty("festivalRound", arg0.getFestivalRound());
		jsonObject.addProperty("noOfFilmsPendingApproval",
				arg0.getNoOfFilmsPendingApproval());
		jsonObject
				.addProperty("noOfFilmsApproved", arg0.getNoOfFilmsApproved());
		jsonObject
				.addProperty("noOfFilmsRejected", arg0.getNoOfFilmsRejected());
		jsonObject.addProperty("approveURL", arg0.getApproveURL());
		// jsonObject.addProperty("noOfUsers", arg0.getNoOfUsers());

		return jsonObject;
	}
}
