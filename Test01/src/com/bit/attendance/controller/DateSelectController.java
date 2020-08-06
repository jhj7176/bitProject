package com.bit.attendance.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.attendance.model.AttendanceDao;
import com.bit.attendance.model.AttendanceDto;

/**
 * Servlet implementation class DateSelectController
 */
@WebServlet("/dateselect.bit")
public class DateSelectController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		ArrayList<AttendanceDto> list = new ArrayList<AttendanceDto>();
		String tmp = request.getParameter("date");
		System.out.println(tmp);
		Date nalja = Date.valueOf(tmp.substring(0, 10));
			System.out.println(nalja);
		try {
			AttendanceDao dao = new AttendanceDao();
			list = dao.dateSelectAll(nalja);
			
			request.setAttribute("list", list);
			request.setAttribute("att_begin", 0);
			request.setAttribute("att_end", 9);
			// begin="${att_begin}" end="${att_end}"
			
			request.getRequestDispatcher("result.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
