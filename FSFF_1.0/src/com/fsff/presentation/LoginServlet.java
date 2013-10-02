package com.fsff.presentation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;


import com.fsff.businessservices.AuthenticationService;
import com.fsff.ui.entity.UserSession;
import com.fsff.util.StringManipulation;

/**
 * Servlet implementation class LoginServlet
 */

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
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
		response.setContentType("text/html");
		String userLogin = request.getParameter("username");
		String userPassword = request.getParameter("password");
		if (StringManipulation.isNullOrEmpty(userLogin)
				|| StringManipulation.isNullOrEmpty(userPassword)) {

		} else {
			AuthenticationService authObject = new AuthenticationService();
			if (request.getSession().getAttribute("JSESSIONID") != null) {
				request.getRequestDispatcher("/index.jsp").forward(request,
						response);
			} else {
				UserSession userSession = authObject.login(userLogin, userPassword);
				if (userSession != null) {
					request.getSession().setAttribute("JSESSION", userSession);
					request.getRequestDispatcher("index.jsp").forward(
							request, response);;
					
				} else {
					request.setAttribute("errorMessage", "Login failed!!!");
					request.getRequestDispatcher("/signin.jsp").forward(
							request, response);
				}
			}
		}
	}
	
	
}
