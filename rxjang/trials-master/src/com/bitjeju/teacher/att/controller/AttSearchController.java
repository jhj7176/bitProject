package com.bitjeju.teacher.att.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bitjeju.teacher.att.model.AttendanceDao;
import com.bitjeju.teacher.att.model.AttendanceDto;

@WebServlet("/lmsteacherattsearch.bit")
public class AttSearchController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Date nalja1=null;
		Date nalja2=null;
		request.setCharacterEncoding("utf-8");
		try {
			nalja1 = Date.valueOf(request.getParameter("nalja1").trim());
			nalja2 = Date.valueOf(request.getParameter("nalja2").trim());
			AttendanceDao dao=new AttendanceDao();
			ArrayList<AttendanceDto> list=dao.selectDate(nalja1, nalja2);
			request.setAttribute("list", list);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("teacherAttList.jsp").forward(request, response);
		
	}

}
