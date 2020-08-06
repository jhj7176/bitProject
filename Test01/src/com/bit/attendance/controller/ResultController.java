package com.bit.attendance.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.attendance.model.AttendanceDao;
import com.bit.attendance.model.AttendanceDto;

@WebServlet("/result.bit")
public class ResultController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			AttendanceDao dao = new AttendanceDao();
			ArrayList<AttendanceDto> list = dao.selectAll();
			request.setAttribute("list", list);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.getRequestDispatcher("/result.jsp").forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Date nalja = null; // Date.valueOf(tempdate) ;
		int num = -1; // Integer.parseInt(req.getParameter("num"));
		String state = null; // req.getParameter("state").trim();

		Enumeration<String> en = req.getParameterNames();
		while (en.hasMoreElements()) {
			// System.out.println(en.nextElement());

			String pa1 = en.nextElement();
			String pa2 = en.nextElement();
			String pa3 = en.nextElement();

			num = Integer.parseInt(req.getParameter(pa1).trim());
			nalja = Date.valueOf(req.getParameter(pa2).trim());
			state = req.getParameter(pa3).trim();
			try {
				AttendanceDao dao = new AttendanceDao();
				dao.insertAll(nalja, num, state);

				dao = new AttendanceDao();
				ArrayList<AttendanceDto> list = dao.selectAll();
				req.setAttribute("list", list);
				req.setAttribute("att_end", 9);
				req.setAttribute("att_begin", 0);

			} catch (SQLException e) {
				e.printStackTrace();
			}

		} // while

//      System.out.println("resultControl"+num);
//      System.out.println();
//      
//      
//      
		req.getRequestDispatcher("result.jsp").forward(req, resp);
		// resp.sendRedirect("result.bit");
	}

}