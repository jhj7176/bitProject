package com.bit.lms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LmsController
 */
@WebServlet("/lms.bit")
public class LmsController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String param = request.getParameter("deptno");// lms 버튼누르르면 input hidden 값을 넘겨 받는다.

		if (param.equals("")||param==null) {
			System.out.println("로그인이 필요합니다!");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			return;
		}

		int deptno = -1;
		// 관리자 5레벨 ,, 철수 2레벨
		deptno = Integer.parseInt(param);

		if (deptno < 3) {
			System.out.println("권한이 부족해!!");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			return;
		}

		request.getRequestDispatcher("lms.jsp").forward(request, response);

	}

}
