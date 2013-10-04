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

import com.fsff.businessservices.ViewFilmService;
import com.fsff.entity.Film;
import com.fsff.ui.entity.FilmData;

/**
 * Servlet implementation class SignUpServlet
 */
// @WebServlet("/SignUpServlet")

public class ViewFilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewFilmServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String genre = request.getParameter("genre");
		PrintWriter out = 	response.getWriter();
		String reply = null;
		if (genre != null) {
			reply = viewFilm(genre);
		}
	
		out.write(reply);
	}

	protected String viewFilm(String genre) {
		ViewFilmService viewFilmService = new ViewFilmService();
		FilmData[] filmData = viewFilmService.viewFilms(genre);
		return (new FilmData()).toJson(filmData);
	}
}
