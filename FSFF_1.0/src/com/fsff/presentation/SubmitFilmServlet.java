package com.fsff.presentation;

import java.io.IOException;

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
		if (request.getSession().getAttribute("JSESSIONID") != null) {
			FilmSubmissionService filmSubmissionObject = new FilmSubmissionService();
			UserSession userSession = (UserSession) request.getSession()
					.getAttribute("JSESSIONID");
			userId = userSession.getId();
			String message = filmSubmissionObject.submitFilm(filmName, genre,
					filmDescription, cast, director, producer, writer,
					roundOneClip, roundTwoClip, roundThreeClip, userId);
			if (message.contains(":")) {
				String msg = message.substring(message.indexOf(":"));
				request.getSession().setAttribute("Msg", msg);
				request.getRequestDispatcher("/uploadfilm.jsp").forward(
						request, response);
			} else {
				request.getSession().setAttribute("UFILMID", message);
				request.getSession().setAttribute("FILMNAME", filmName);
				request.getRequestDispatcher("/payment.jsp").forward(request,
						response);
			}
			// request.getRequestDispatcher("/index.jsp").forward(request,
			// response);
		} else {
			request.getRequestDispatcher("signin.jsp").forward(request,
					response);

		}
	}
}