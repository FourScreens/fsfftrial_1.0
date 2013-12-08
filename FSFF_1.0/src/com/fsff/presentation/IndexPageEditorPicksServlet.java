package com.fsff.presentation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fsff.businessservices.IndexService;
import com.fsff.ui.entity.FilmData;

public class IndexPageEditorPicksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String EDITOR_PICKS = "editorpicks";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IndexPageEditorPicksServlet() {
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
		String data = request.getParameter("part");
		PrintWriter out = response.getWriter();
		String reply = null;
		if (data != null) {
			reply = viewFilm(data);
		}
		out.write(reply);
	}

	protected String viewFilm(String data) {
		IndexService indexService = new IndexService();
		FilmData[] filmData = null;
		if (data.equals(EDITOR_PICKS)) {
			filmData = indexService.indexEditorPicks();
		}
		return (new FilmData()).toJson(filmData);
	}
}
