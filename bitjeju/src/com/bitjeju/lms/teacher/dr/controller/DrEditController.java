package com.bitjeju.lms.teacher.dr.controller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bitjeju.lms.teacher.dr.model.DrDao;
import com.bitjeju.lms.teacher.dr.model.DrDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/lmsteacherdredit.bit")
public class DrEditController extends HttpServlet {
	HttpSession session;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session=request.getSession(false);
		request.setCharacterEncoding("utf-8");
		int drNum=Integer.parseInt(request.getParameter("drNum").trim());
		System.out.println("DrEdittController, drNum: "+drNum);
		try {
			DrDao dao=new DrDao();
			DrDto bean=dao.selectOne(drNum);
			request.setAttribute("bean", bean);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("teacherDataroomEdit.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session=request.getSession(false);
		request.setCharacterEncoding("utf-8");
		
		String directory = request.getSession().getServletContext().getRealPath("/upload/");
		File file = new File(directory);
		
		if(!file.exists()) {
			file.mkdirs();
		}
		int maxSize=1024*1024*100;
		DefaultFileRenamePolicy frp = new DefaultFileRenamePolicy();
		
		MultipartRequest mpReq = new MultipartRequest(request, directory, maxSize, "utf-8" ,frp);

		int drNum=Integer.parseInt(mpReq.getParameter("drNum").trim());
		String drTitle=mpReq.getParameter("drTitle");
		String fileName = mpReq.getFilesystemName("fileName");
		String drContent=mpReq.getParameter("drContent");
		try {
			DrDao dao=new DrDao();
			dao.updateDr(drNum, drTitle, fileName, drContent);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("lmsteacherdrdetail.bit?drNum="+drNum);
	}

}