package com.bitjeju.lms.staff.lecture.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bitjeju.lms.staff.lecture.model.LectureDao;
import com.bitjeju.lms.staff.lecture.model.LectureDto;
import com.bitjeju.login.model.MemberDao;
import com.bitjeju.login.model.MemberDto;

/**
 * Servlet implementation class LectureListController
 */
@WebServlet("/lmsstafflecturelist.bit")
public class LectureListController extends HttpServlet {
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		LectureDao dao = new LectureDao();
		ArrayList<LectureDto> list = null;
		try {
			list = dao.selectAll(); //ȸ�����̺��� ������ ��� �����´�.
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("list", list); //������Ʈ�������� list = ArrayList<MemberDto> list�� ����.
		request.getRequestDispatcher("staffLectureList.jsp").forward(request, response);//ȸ������ �������̵�
	}
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

}
