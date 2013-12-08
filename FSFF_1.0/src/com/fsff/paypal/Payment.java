package com.fsff.paypal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fsff.businessservices.FilmSubmissionService;
import com.fsff.businessservices.PaymentService;
import com.fsff.ui.entity.UserSession;

public class Payment extends HttpServlet {

	private static final String SUCCESS = "SUCCESS";
	private static String URL = "https://www.sandbox.paypal.com/cgi-bin/webscr";
	private static String AUTHENTICATION_TOKEN = "gvdXD70rSvWoVcf3-rQ8sOlgYil0QmWHqzNgsB4u7UWc-i8neElZYTfSGK4";

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Payment() {
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

		String paramName;
		String paramValue;
		BufferedReader in = null;
		String transactionId = request.getParameter("tx");
		StringBuilder sb = new StringBuilder();
		PrintWriter out = response.getWriter();
		try {

			URL u = new URL(URL);
			HttpURLConnection uc = (HttpURLConnection) u.openConnection();
			StringBuilder cmd = new StringBuilder("cmd=_notify-synch");
			paramName = "tx";
			paramValue = transactionId;
			cmd.append("&").append(paramName).append("=").append(paramValue);
			paramName = "at";
			paramValue = AUTHENTICATION_TOKEN;
			cmd.append("&").append(paramName).append("=").append(paramValue);
			uc.setDoOutput(true);
			uc.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");
			PrintWriter pw = new PrintWriter(uc.getOutputStream());
			pw.println(cmd.toString());
			pw.close();

			// 4. Read response from Paypal
			in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
			Map<String, String> result = new HashMap<String, String>();
			String status = in.readLine();
			String keyValues;

			if (status.equals(SUCCESS)) {
				while ((keyValues = in.readLine()) != null) {
					sb.append(keyValues);
					if (keyValues.contains("=")) {
						String[] temp = keyValues.split("=");
						if (temp.length < 1) {
							result.put(temp[0], "");
						} else {
							result.put(temp[0], temp[1]);
						}
					}
				}
				int userId = 0;
				if (request.getSession().getAttribute("JSESSIONID") != null) {
					UserSession userSession = (UserSession) request
							.getSession().getAttribute("JSESSIONID");
					userId = userSession.getId();
				}
				PaymentService payService = new PaymentService();
				payService.paymentSuccess(userId, result.get("item_name"));

			}
		} catch (Exception e) {
			out.write(e.getMessage().toString());
		} finally {
			if (in != null) {
				in.close();
			}
		}
		response.sendRedirect("/filmsubmission.jsp");
	}
}
