package com.bitjeju.lms.staff.student;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bitjeju.login.model.MemberDao;
import com.bitjeju.login.model.MemberDto;

/**
 * Servlet implementation class StudentListController
 */
@WebServlet("/lmsstaffstudentlist.bit")
public class StudentListController extends HttpServlet {


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		MemberDao dao = new com.bitjeju.login.model.MemberDao();
		ArrayList<MemberDto> list = null;
		try {
			list = dao.stuSelectAll(); //ȸ�����̺��� ������ ��� �����´�.
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("list", list); //������Ʈ�������� list = ArrayList<MemberDto> list�� ����.
		request.getRequestDispatcher("staffStudentList.jsp").forward(request, response);//ȸ������ �������̵�
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
