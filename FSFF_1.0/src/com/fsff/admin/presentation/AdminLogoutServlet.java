package com.fsff.admin.presentation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminLogoutServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		doProcess(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		doProcess(request, response);
	}

	public void doProcess(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		System.out.println(request.getParameter("logout"));
		response.setContentType("text/html");
		if (request.getSession().getAttribute("ADMINJSESSIONID") != null) {
			request.getSession().invalidate();
			request.getRequestDispatcher("/adminindex.jsp").forward(request,
					response);
		}

	}
}