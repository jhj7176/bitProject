package com.bitjeju.lms.staff.account.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bitjeju.login.model.MemberDao;
import com.bitjeju.login.model.MemberDto;

/**
 * Servlet implementation class AccountDetailController
 */
@WebServlet("/lmsstaffaccountdetail.bit")
public class AccountDetailController extends HttpServlet {

	HttpSession session;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		session = request.getSession(false);
		if(session==null) {
			response.sendRedirect("main.bit");
			return;
		}
		int num = Integer.parseInt(request.getParameter("num"));
		MemberDao dao = new com.bitjeju.login.model.MemberDao();
		MemberDto bean = null;
		try {
			bean = dao.selectOne(num); //ȸ�����̺��� ������ 1�� ������
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("bean", bean); //������Ʈ�������� list = ArrayList<MemberDto> list�� ����.
		request.getRequestDispatcher("staffAccountDetail.jsp").forward(request, response);//ȸ������ �������̵�
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	

	
	}

	
}