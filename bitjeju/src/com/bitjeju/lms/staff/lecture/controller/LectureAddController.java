package com.bitjeju.lms.staff.lecture.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bitjeju.lms.staff.lecture.model.LectureDao;

/**
 * Servlet implementation class LectureAddController
 */
@WebServlet("/lmsstafflectureadd.bit")
public class LectureAddController extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	/*		pstmt.setString(1, lecture_name);
		pstmt.setDate(2, start_day);
		pstmt.setDate(3, end_day);
		pstmt.setInt(4, num);
		pstmt.setInt(5, lecture_room);
	 * 
	 * */
		//**************�Է� ���ߴµ� ��ϴ����� nullpointer���ܹ߻��ϹǷ� ����ó��.
		String lecture_name=null;
		Date start_day =null;
		Date end_day =null;
		int num = -1;
		int lecture_room=-1;
		LectureDao dao = new LectureDao();		
		try {
			lecture_name = request.getParameter("lecture_name");
			start_day = Date.valueOf(request.getParameter("start_day").substring(0, 10));
			end_day = Date.valueOf(request.getParameter("end_day").substring(0, 10));
			num = Integer.parseInt(request.getParameter("num")); //������ ȸ����ȣ
			lecture_room = Integer.parseInt(request.getParameter("lecture_room"));
			
			dao.insertLecture(lecture_name, start_day, end_day, num, lecture_room);
			//�������̺� �Է¹��� ���� �߰�.
		}catch(NullPointerException e) {
			request.getRequestDispatcher("staffLectureAdd.jsp").forward(request, response);
			//�Է°��� �����ϸ� �ٽ� ���°��� �������̵�***************************
			//����ȭ�鿡�� �ڹٽ�ũ��Ʈ�� ���
			return;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.getRequestDispatcher("staffLectureAdd.jsp").forward(request, response);
			return;
		}
	//****************************������ �ȳ����� ���� �߰��Ǿ��� ����Ʈ�� ���ư�***********************
		request.getRequestDispatcher("staffLectureList.jsp").forward(request, response);//���¸�� �������̵�
	}

}
