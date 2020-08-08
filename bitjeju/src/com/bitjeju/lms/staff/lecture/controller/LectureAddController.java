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
		//**************입력 덜했는데 등록누르면 nullpointer예외발생하므로 예외처리.
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
			num = Integer.parseInt(request.getParameter("num")); //강사의 회원번호
			lecture_room = Integer.parseInt(request.getParameter("lecture_room"));
			
			dao.insertLecture(lecture_name, start_day, end_day, num, lecture_room);
			//강좌테이블에 입력받은 값을 추가.
		}catch(NullPointerException e) {
			request.getRequestDispatcher("staffLectureAdd.jsp").forward(request, response);
			//입력값이 부족하면 다시 강좌개설 페이지이동***************************
			//그쪽화면에서 자바스크립트로 경고
			return;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.getRequestDispatcher("staffLectureAdd.jsp").forward(request, response);
			return;
		}
	//****************************에러가 안났으면 정상 추가되었고 리스트로 돌아감***********************
		request.getRequestDispatcher("staffLectureList.jsp").forward(request, response);//강좌목록 페이지이동
	}

}
