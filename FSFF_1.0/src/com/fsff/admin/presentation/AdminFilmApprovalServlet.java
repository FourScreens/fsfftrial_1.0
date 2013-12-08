package com.fsff.admin.presentation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fsff.admin.adminservices.AdminService;

public class AdminFilmApprovalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String REJECTED = "Rejected";
	private static final String APPROVED = "Approved";
	private static final String RECEIVED = "Received";
	private static final String PENDING = "Pending";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminFilmApprovalServlet() {
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
		String approval = request.getParameter("approval");
		String receivedfilmstatus = request.getParameter("receivedfilmstatus");

		String[] filmId = request.getParameterValues("selector");
		AdminService adminService = new AdminService();
		String msg = "";
		if (approval != null) {
			if (approval.equals(APPROVED)) {
				msg = adminService.approveFilms(filmId, APPROVED);
			} else {
				msg = adminService.approveFilms(filmId, REJECTED);
			}
		} else if (receivedfilmstatus != null) {
			if (receivedfilmstatus.equals(RECEIVED)) {
				msg = adminService.receivedFilms(filmId, RECEIVED);
			} else {
				msg = adminService.receivedFilms(filmId, PENDING);
			}
		}
		String encodedResponse = "";
		String reply = "null";
		encodedResponse = "{\"data\":" + reply + ",\"message\":\"" + msg
				+ "\"}";

		request.setAttribute("message", msg);
		request.getRequestDispatcher("/filmapproval.jsp").forward(request,
				response);
	}

}
