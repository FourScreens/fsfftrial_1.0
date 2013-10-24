package com.fsff.presentation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fsff.businessservices.AuthenticationService;
import com.fsff.util.StringManipulation;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	public void doProcess(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String eMail = request.getParameter("email");
		String password = request.getParameter("password");
		String passwordConfirmation = request.getParameter("confirmation");
		String userType = request.getParameter("userType");
		String forgotPasswordQuestion = "";
		String forgotPasswordAnswer = "";
		if (StringManipulation.isNullOrEmpty(firstName)
				|| StringManipulation.isNullOrEmpty(lastName)
				|| StringManipulation.isNullOrEmpty(eMail)
				|| StringManipulation.isNullOrEmpty(password)
				|| StringManipulation.isNullOrEmpty(passwordConfirmation)) {

		} else {

			AuthenticationService authenticationObject = new AuthenticationService();
			boolean signUp = authenticationObject.signUp(firstName, lastName,
					eMail, password, passwordConfirmation,
					forgotPasswordQuestion, forgotPasswordAnswer, userType);
			if (signUp) {
				request.getRequestDispatcher("/signin.jsp").forward(request,
						response);
			} else {
				request.setAttribute("errorMessage", "Registration failed!!!");
				request.getRequestDispatcher("/signup.jsp").forward(request,
						response);
			}
		}

	}
}
