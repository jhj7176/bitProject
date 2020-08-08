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
 * Servlet implementation class ListController
 */
@WebServlet("/lmsstaffaccountlist.bit")
public class AccountListController extends HttpServlet {

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

		String key = request.getParameter("key");
		String word = request.getParameter("word");
		if (key == null || key.trim() == "")
			key = "name";
		if (word == null || word.trim() == "")
			word = "";
		int pageNum;
		int totalMember=-1;
		if (request.getParameter("pageNum") != null) {
			System.out.println(request.getParameter("pageNum"));
			pageNum = Integer.parseInt(request.getParameter("pageNum").trim());
		}else {
			pageNum=1;
		}
		MemberDao dao = new MemberDao();
		ArrayList<MemberDto> list = null;
		try {
			list = dao.selectAll(pageNum,key,word); //회원테이블의 정보를 모두 가져온다.
			dao = new MemberDao();
			totalMember = dao.totalMember();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("list", list); //리퀘스트스코프에 list = ArrayList<MemberDto> list를 저장.
		request.setAttribute("totalMember", totalMember); //member 테이블의 총 row 수 
		request.getRequestDispatcher("staffAccountList.jsp").forward(request, response);//회원정보 페이지이동
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
