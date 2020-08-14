package com.bitjeju.lms.sales.assign.contoller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lmssalesassingstudetail.bit")
public class AssginStuDetailController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

/*
 * 
 * 학생이름
 * 강좌이름
 * 교육기간
 * 학생 연락처
 * 이메일
 * 영업 
 * 
 * 수강생관리 강좌배정 수강생 눌렀을 때  디테일 페이지 컨트롤러 

강좌배정 리스트뜰 때

불러올때 sql >> 멤버테이블에 lercture가 not null이고 레벨이 3미만인 회원만 select하기. dao

 * */
 