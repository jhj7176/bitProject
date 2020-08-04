package com.bit.attend.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.attend.model.AttendDao;
import com.bit.attend.model.AttendDto;

/**
 * Servlet implementation class ListController
 */
@WebServlet("/list.bit")
public class ListController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		AttendDao dao = new AttendDao();
		ArrayList<AttendDto> list = null;
		try {
			list = dao.selectAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("alist", list);
		
		request.getRequestDispatcher("result.jsp").forward(request, response);
	}

}
