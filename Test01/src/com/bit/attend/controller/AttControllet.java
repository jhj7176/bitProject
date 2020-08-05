package com.bit.attend.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.attend.model.AttendDao;

/**
 * Servlet implementation class AttControllet
 */
@WebServlet("/att.bit")
public class AttControllet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String param=null;
		int mnum = -1;
		try {
			mnum = Integer.parseInt(request.getParameter("mnum"));
			param = request.getParameter("ra").trim();
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			response.sendRedirect("attendance.jsp");
			return;
		} catch (NullPointerException e2) {
			e2.printStackTrace();
			response.sendRedirect("attendance.jsp");
			return;			
		}
		AttendDao dao = new AttendDao();
		dao.insertAtt(mnum, param);

		response.sendRedirect("list.bit");
	}

}
