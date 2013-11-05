package com.fsff.presentation;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fsff.businessservices.FilmRatingService;
import com.fsff.businessservices.ViewFilmService;
import com.fsff.entity.Film;
import com.fsff.ui.entity.FilmData;
import com.fsff.ui.entity.UserSession;

/**
 * Servlet implementation class SignUpServlet
 */
// @WebServlet("/SignUpServlet")

public class VotingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VotingServlet() {
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
		UserSession userSession = (UserSession) request.getSession()
				.getAttribute("JSESSION");

		if (userSession != null) {
			userId = userSession.getId();
		}

		FilmRatingService rater = new FilmRatingService();
		rater.rateFilm(filmId, userId, ratingId);
	}
}
