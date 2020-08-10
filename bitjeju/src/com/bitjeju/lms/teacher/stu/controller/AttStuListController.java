package com.bitjeju.lms.teacher.stu.controller;


import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bitjeju.lms.teacher.stu.model.StudentDao;
import com.bitjeju.member.MemberDto;

@WebServlet("/lmsteacherattendance.bit")
public class AttStuListController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			StudentDao dao=new StudentDao();
			ArrayList<MemberDto> list=dao.selectAll();
			request.setAttribute("list", list);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("teacherAttCheck.jsp").forward(request, response);
	}

}