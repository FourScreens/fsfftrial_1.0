package com.fsff.presentation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fsff.businessservices.FilmSubmissionService;
import com.fsff.ui.entity.UserSession;

/**
 * Servlet implementation class SubmitFilmServlet
 */
@WebServlet("/SubmitFilmServlet")
public class SubmitFilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public SubmitFilmServlet() {
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

		response.setContentType("text/html");
		String filmName = request.getParameter("filmName");
		String genre = request.getParameter("genre");
		String filmDescription = request.getParameter("filmDescription");
		String cast = request.getParameter("cast");
		String director = request.getParameter("director");
		String producer = request.getParameter("producer");
		String writer = request.getParameter("writer");
		String roundOneClip = request.getParameter("roundOneClip");
		String roundTwoClip = request.getParameter("roundTwoClip");
		String roundThreeClip = request.getParameter("roundThreeClip");
		int userId = 0;
		if (request.getSession().getAttribute("JSESSION") != null) {
			FilmSubmissionService filmSubmissionObject = new FilmSubmissionService();
			UserSession userSession = (UserSession) request.getSession()
					.getAttribute("JSESSION");
			userId = userSession.getId();
			filmSubmissionObject.submitFilm(filmName, genre, filmDescription,
					cast, director, producer, writer, roundOneClip,
					roundTwoClip, roundThreeClip, userId);
			request.getRequestDispatcher("/index.jsp").forward(request,
					response);
		} else {
			request.getRequestDispatcher("signin.jsp").forward(request,
					response);

		}

		String title = "Film Submission!";

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 "
				+ "Transitional//EN\">\n";

		out.println(docType
				+ "<HTML>\n"
				+ "<HEAD><TITLE>"
				+ title
				+ "</TITLE></HEAD>\n"
				+ "<H3 ALIGN=CENTER> Congratulations! You have successfully submitted your film clips!</H3>\n"
				+ "<H3 ALIGN=CENTER> You will be notified on the status of your film entering the competition in a week!</H3>\n"
				+ "<H3 ALIGN=CENTER> Please visit the <a href=\"index.jsp\"> View film page </a> after a week to view your film in the competition, if you are selected/notified!</H3>\n"
				+ "<H3 ALIGN=CENTER> Go back to the <a href=\"index.jsp\">Home page</a> </H3>\n");
	}
}