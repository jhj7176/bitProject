package com.bitjeju.lms.teacher.grade.controller;


import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bitjeju.lms.teacher.grade.model.GradeDao;
import com.bitjeju.lms.teacher.grade.model.GradeDto;
import com.bitjeju.member.MemberDto;

@WebServlet("/lmsteacherstugrade.bit")
public class GradeController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		 
		HttpSession session = request.getSession(false);
		MemberDto bean = (MemberDto)session.getAttribute("login");

		try {
	         GradeDao dao=new GradeDao();
	         ArrayList<GradeDto> list=dao.selectAll(bean.getNum());
	         request.setAttribute("list", list);
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	      
	      request.getRequestDispatcher("teacherStuGrade.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		int grade1,grade2,grade3=-1;
		String exam=null;
		int num=Integer.parseInt(req.getParameter("num").trim());
		System.out.println(num+"num:");
		try {
			GradeDao dao;
			if(req.getParameter("grade1") != null){
				grade1=Integer.parseInt(req.getParameter("grade1").trim());
				exam="exam1";
				dao=new GradeDao();
				dao.updateOne(num, exam, grade1);
			}
			if(req.getParameter("grade2") != null){
				grade2=Integer.parseInt(req.getParameter("grade2").trim());
				exam="exam2";
				 dao=new GradeDao();
				dao.updateOne(num, exam, grade2);
			}
			if(req.getParameter("grade3") != null){
				grade3=Integer.parseInt(req.getParameter("grade3").trim());
				exam="exam3";
				dao=new GradeDao();
				dao.updateOne(num, exam, grade3);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		resp.sendRedirect("lmsteacherstugrade.bit");
		
		
	}
}
