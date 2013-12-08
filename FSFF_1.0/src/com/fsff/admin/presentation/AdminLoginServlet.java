package com.fsff.admin.presentation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fsff.admin.adminservices.AdminAuthenticationService;
import com.fsff.ui.entity.AdminSession;
import com.fsff.util.StringManipulation;

public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminLoginServlet() {
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

		response.setContentType("text/html");
		String userLogin = request.getParameter("username");
		String userPassword = request.getParameter("password");
		if (StringManipulation.isNullOrEmpty(userLogin)
				|| StringManipulation.isNullOrEmpty(userPassword)) {

		} else {
			AdminAuthenticationService adminAuthObject = new AdminAuthenticationService();
			if (request.getSession().getAttribute("ADMINJSESSIONID") != null) {
				request.getRequestDispatcher("/index.jsp").forward(request,
						response);
			} else {
				AdminSession adminSession = adminAuthObject.login(userLogin,
						userPassword);
				if (adminSession != null) {
					request.getSession().setAttribute("ADMINJSESSIONID", adminSession);
					request.getRequestDispatcher("adminindex.jsp").forward(
							request, response);

				} else {
					request.setAttribute("errorMessage", "Login failed!!!");
					request.getRequestDispatcher("/adminlogin.jsp").forward(
							request, response);
				}
			}
		}
	}
}
