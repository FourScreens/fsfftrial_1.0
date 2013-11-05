package com.fsff.presentation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fsff.businessservices.SearchFilmService;
import com.fsff.ui.entity.FilmData;

//import javax.servlet.annotation.WebServlet;

/**
 * Servlet implementation class SignUpServlet
 */
// @WebServlet("/SignUpServlet")

public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchServlet() {
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
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String dimension = request.getParameter("selector");
		String query = request.getParameter("search");
		PrintWriter out = response.getWriter();
		String reply = null;
		if (query != null) {
			reply = search(query, dimension, request, response);
		}

		request.setAttribute("filmData", reply);
		// request.setAttribute("count", count);
		RequestDispatcher counter = request
				.getRequestDispatcher("/SearchView.jsp");
		counter.forward(request, response);
	}

	protected String search(String qry, String par, HttpServletRequest request,
			HttpServletResponse response) {

		SearchFilmService searchFilm = new SearchFilmService();
		FilmData[] filmData = null;

		if (par.equals("film")) {
			filmData = searchFilm.searchFilmByName(qry);
		} else if (par.equals("cast")) {
			filmData = searchFilm.searchFilmByCase(qry);
		} else if (par.equals("director")) {
			filmData = searchFilm.searchFilmByDirector(qry);
		} else if (par.equals("writer")) {
			filmData = searchFilm.searchFilmByWriter(qry);
		} else if (par.equals("producer")) {
			filmData = searchFilm.searchFilmByProducer(qry);
		}
		return (new FilmData()).toJson(filmData);

	}
}
