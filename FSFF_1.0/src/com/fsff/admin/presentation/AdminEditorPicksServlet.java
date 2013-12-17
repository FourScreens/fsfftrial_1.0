package com.fsff.admin.presentation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fsff.admin.adminservices.AdminService;

public class AdminEditorPicksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminEditorPicksServlet() {
		super();
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
		String selected = request.getParameter("select");

		String[] filmId = request.getParameterValues("selector");
		AdminService adminService = new AdminService();
		String msg = "";
		if (selected != null) {
			adminService.setEditorsPick(filmId, selected);
		}

		request.setAttribute("message", msg);
		request.getRequestDispatcher("/editorpicks.jsp").forward(request,
				response);
	}

}
