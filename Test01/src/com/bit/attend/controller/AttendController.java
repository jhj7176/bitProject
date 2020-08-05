package com.bit.attend.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.attend.model.AttendDao;

/**
 * Servlet implementation class AttendController
 */
@WebServlet("/attendance.bit")
public class AttendController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// TODO Auto-generated method stu

		int num = -1;
		try {
			num = Integer.parseInt(request.getParameter("num"));
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			response.sendRedirect("attendance.jsp");
			return;
		}
		int att = 0;
		int late = 0;
		int absent = 0;

		String param1 = request.getParameter("ra");

		if (param1.equals("att")) {
			att = 1;
		} else if (param1.equals("late")) {
			late = 1;
		} else if (param1.equals("absent")) {
			absent = 1;
		}

		AttendDao dao = new AttendDao();
		try {
			dao.updateAttend(num, att, late, absent);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("list.bit");
		// request.getRequestDispatcher("result.jsp").forward(request, response);

	}// post

}
