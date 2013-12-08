package com.fsff.admin.presentation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fsff.admin.adminservices.AdminService;
import com.fsff.ui.entity.AdminFilmData;
import com.fsff.ui.entity.AdminFilmDataMsg;

public class AdminViewAllFilmsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminViewAllFilmsServlet() {
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
		AdminService adminService = new AdminService();
		String encodedResponse = "";
		String reply = "";
		String msg = "";
		AdminFilmDataMsg filmData = adminService.fetchAllFilms();
		reply = (new AdminFilmData()).toJson(filmData.getAdminFilmData());
		msg = filmData.getMessage();
		if (reply.equals("null") && msg.equals("")) {
			filmData.setMessage("No films submitted !!");
			msg = filmData.getMessage();
		}
		encodedResponse = "{\"data\":" + reply + ",\"message\":\"" + msg
				+ "\"}";
		PrintWriter out = response.getWriter();
		out.write(encodedResponse);
	}

}
