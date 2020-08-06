package com.bit.attendance.controller;

import java.io.IOException;
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
 * Servlet implementation class PageController
 */
@WebServlet("/page.bit")
public class PageController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String param = request.getParameter("p");
		int begin = Integer.parseInt(request.getParameter("begin"));
		int end = Integer.parseInt(request.getParameter("end"));

		ArrayList<AttendanceDto> list;
		try {
			AttendanceDao dao = new AttendanceDao();
			list = dao.selectAll();
			request.setAttribute("list", list);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (param.equals("prev")) {
			if (begin - 10 < 0) {
				request.setAttribute("att_begin", 0);
				request.setAttribute("att_end", 9);
			} else {
				request.setAttribute("att_begin", begin - 10);
				request.setAttribute("att_end", end - 10);
			}
		} else if (param.equals("next")) {
			request.setAttribute("att_begin", begin + 10);
			request.setAttribute("att_end", end + 10);

		}
		request.getRequestDispatcher("result.jsp").forward(request, response);

	}// doget

}
