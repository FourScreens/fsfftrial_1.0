package com.fsff.ui.entity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class AdminIndexData {

	private String festivalName;

	private String festivalStartDate;

	private String roundOneStartDate;

	private String roundTwoStartDate;

	private String roundThreeStartDate;

	private String festivalEndDate;

	private String festivalRound;

	private String noOfFilmsPendingApproval;

	private String noOfFilmsApproved;

	private String noOfFilmsRejected;

	private String approveURL;

	private String noOfUsers;

	public String getFestivalName() {
		return festivalName;
	}

	public void setFestivalName(String festivalName) {
		this.festivalName = festivalName;
	}

	public String getFestivalStartDate() {
		return festivalStartDate;
	}

	public void setFestivalStartDate(String festivalStartDate) {
		this.festivalStartDate = festivalStartDate;
	}

	public String getRoundOneStartDate() {
		return roundOneStartDate;
	}

	public void setRoundOneStartDate(String roundOneStartDate) {
		this.roundOneStartDate = roundOneStartDate;
	}

	public String getRoundTwoStartDate() {
		return roundTwoStartDate;
	}

	public void setRoundTwoStartDate(String roundTwoStartDate) {
		this.roundTwoStartDate = roundTwoStartDate;
	}

	public String getRoundThreeStartDate() {
		return roundThreeStartDate;
	}

	public void setRoundThreeStartDate(String roundThreeStartDate) {
		this.roundThreeStartDate = roundThreeStartDate;
	}

	public String getFestivalEndDate() {
		return festivalEndDate;
	}

	public void setFestivalEndDate(String festivalEndDate) {
		this.festivalEndDate = festivalEndDate;
	}

	public String getFestivalRound() {
		return festivalRound;
	}

	public void setFestivalRound(String festivalround) {
		this.festivalRound = festivalround;
	}

	public String getNoOfFilmsPendingApproval() {
		return noOfFilmsPendingApproval;
	}

	public void setNoOfFilmsPendingApproval(String noOfFilmsPendingApproval) {
		this.noOfFilmsPendingApproval = noOfFilmsPendingApproval;
	}

	public String getNoOfFilmsApproved() {
		return noOfFilmsApproved;
	}

	public void setNoOfFilmsApproved(String noOfFilmsApproved) {
		this.noOfFilmsApproved = noOfFilmsApproved;
	}

	public String getNoOfFilmsRejected() {
		return noOfFilmsRejected;
	}

	public void setNoOfFilmsRejected(String noOfFilmsRejected) {
		this.noOfFilmsRejected = noOfFilmsRejected;
	}

	public String getApproveURL() {
		return approveURL;
	}

	public void setApproveURL(String approveURL) {
		this.approveURL = approveURL;
	}

	public String getNoOfUsers() {
		return noOfUsers;
	}

	public void setNoOfUsers(String noOfUsers) {
		this.noOfUsers = noOfUsers;
	}

	public String toJson(AdminIndexData films) {
		GsonBuilder gsonBuilder = new GsonBuilder();
		Gson gson = gsonBuilder
				.disableHtmlEscaping()
				.registerTypeAdapter(AdminIndexData.class,
						new AdminIndexDataAdapter()).create();
		return gson.toJson(films);
	}

}
