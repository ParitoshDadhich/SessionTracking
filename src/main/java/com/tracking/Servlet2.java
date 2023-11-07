package com.tracking;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		String userName = null;
		
		// getting all the cookies
		Cookie cookies[] = request.getCookies();
		boolean flag = false;
		if(cookies == null) {
			writer.println("<h1>You are a new user, Go to home page and submit your name!</h1>");
		} else {
			for(Cookie cookie: cookies) {
				String cookieName = cookie.getName();
				if(cookieName.equals("user_name")) {
					flag = true;
					userName = cookie.getValue();
				}
			}
		}
		
		if(flag) {
			writer.print("<h1>Hello " + userName + " Welcome to page</h1>");
			writer.println("<h2>Thank you!</h2>");
		} else {
			writer.println("<h1>You are a new user, Go to home page and submit your name!</h1>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
