package com.bitjeju.lms.staff.lecture.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bitjeju.lms.staff.lecture.model.LectureDao;
import com.bitjeju.member.MemberDao;

/**
 * Servlet implementation class StartingLectureController
 */
@WebServlet("/lmsteacherlecupdate.bit")
public class StartingLectureController extends HttpServlet {




	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String lecture = request.getParameter("lecture");
		String name = request.getParameter("name");
		
		System.out.println();
		System.out.println(lecture);
		System.out.println(name);
		System.out.println();
		
		LectureDao dao = new LectureDao();
		dao.updateLecture(lecture, name);//멤버테이블에 강사의 과목컬럼에 과목 입력. 개강

		response.setContentType("application/xml;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<result>starting</result>");
		out.close();
	
	
	}

}
