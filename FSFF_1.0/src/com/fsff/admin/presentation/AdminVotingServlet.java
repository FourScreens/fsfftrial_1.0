package com.fsff.admin.presentation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fsff.admin.adminservices.AdminRatingService;
import com.fsff.ui.entity.AdminSession;

public class AdminVotingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminVotingServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doAction(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String sFilmId = request.getParameter("filmId");
		int filmId = Integer.parseInt(sFilmId);
		String sRating = request.getParameter("rating");
		int ratingId = Integer.parseInt(sRating);
		int userId = 1;
		AdminSession adminSession = (AdminSession) request.getSession()
				.getAttribute("ADMINJSESSIONID");

		if (adminSession != null) {
			userId = adminSession.getId();
		}

		AdminRatingService rater = new AdminRatingService();
		rater.rateFilm(filmId, userId, ratingId);
	}
}
