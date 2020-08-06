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

		String param = request.getParameter("deptno");// lms ��ư�������� input hidden ���� �Ѱ� �޴´�.

		if (param.equals("")||param==null) {
			System.out.println("�α����� �ʿ��մϴ�!");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			return;
		}

		int deptno = -1;
		// ������ 5���� ,, ö�� 2����
		deptno = Integer.parseInt(param);

		if (deptno < 3) {
			System.out.println("������ ������!!");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			return;
		}

		request.getRequestDispatcher("lms.jsp").forward(request, response);

	}

}
