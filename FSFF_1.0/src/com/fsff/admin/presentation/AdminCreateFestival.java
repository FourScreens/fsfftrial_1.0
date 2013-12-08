package com.fsff.admin.presentation;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fsff.admin.adminservices.AdminService;

public class AdminCreateFestival extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminCreateFestival() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		try {
			doAction(request, response);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			doAction(request, response);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	protected void doAction(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		String festivalName = request.getParameter("festivalname");
		String year = request.getParameter("year");
		String quarter = request.getParameter("quarter");
		String msg = "Please check the dates for the festival !!";
		try {
			// Film submission
			String submissionStart = request.getParameter("from");
			Date submissionStartDate = dateFormat.parse(submissionStart);
			String submissionEnd = request.getParameter("to");
			Date submissionEndDate = dateFormat.parse(submissionEnd);
			// Round One
			String roundOneStart = request.getParameter("from1");
			Date roundOneStartDate = dateFormat.parse(roundOneStart);
			String roundOneEnd = request.getParameter("to1");
			Date roundOneEndDate = dateFormat.parse(roundOneEnd);
			// Round Two
			String roundTwoStart = request.getParameter("from2");
			Date roundTwoStartDate = dateFormat.parse(roundTwoStart);
			String roundTwoEnd = request.getParameter("to2");
			Date roundTwoEndDate = dateFormat.parse(roundTwoEnd);
			// Round Three
			String roundThreeStart = request.getParameter("from3");
			Date roundThreeStartDate = dateFormat.parse(roundThreeStart);
			String roundThreeEnd = request.getParameter("to3");
			Date roundThreeEndDate = dateFormat.parse(roundThreeEnd);

			AdminService adminService = new AdminService();
			msg = adminService.createFilmFestival(festivalName, year, quarter,
					submissionStartDate, submissionEndDate, roundOneStartDate,
					roundOneEndDate, roundTwoStartDate, roundTwoEndDate,
					roundThreeStartDate, roundThreeEndDate);
		} catch (ParseException e) {
		}

		request.setAttribute("message", msg);
		request.getRequestDispatcher("/createfestival.jsp").forward(request,
				response);

	}
}
