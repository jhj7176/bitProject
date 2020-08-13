package com.bitjeju.lms.sales.recruit.controller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bitjeju.lms.sales.recruit.model.RecruitDao;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class RecruitFileController
 */			
@WebServlet("/lmssalesrecruitfile.bit")
public class RecruitFileController extends HttpServlet {



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//**********************************파일 선택 페이지**********************************
		request.getRequestDispatcher("salesRecruitFile.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	
		String path = request.getRealPath("recruit");
		File file = new File(path);
		if(!file.exists()) {
			file.mkdirs();
		}
		int fsize = 1*1024*1024*1024*50; //50메가바이트 제한.

		//****************************************파일 업로드****************************************
		//""+System.currentTimeMillis()
		//생성자 파라미터 (request, Directory, int maxPostSize)
		//생성자 파라미터 (request, Directory, int maxPostSize, File rename)
		//생성자 파라미터 (request, Directory, int maxPostSize, encoding , File rename)
		
				//1byte 1kb 1mb 1gb
	
		//String rename=""+System.currentTimeMillis();
		DefaultFileRenamePolicy frp = new DefaultFileRenamePolicy();//파일명이 같으면 rename해준다.	
		
		MultipartRequest mpReq = new MultipartRequest(request, path, fsize, "utf-8" ,frp);// 업로드하는 파일 받는 객체	
													//서블릿 요청, 경로, 파일크기, 엔코딩 설정, rename객체
		System.out.println(request.getParameter("sabun"));
		System.out.println(mpReq.getParameter("sabun"));
		System.out.println("Rename"+mpReq.getFilesystemName("file1"));
		//form tag 내의 file type input의 name
		System.out.println("원래이름"+mpReq.getOriginalFileName("file1"));
		
		request.setAttribute("rename",mpReq.getFilesystemName("file1")); //폴더에 저장된 바뀐이름
		request.setAttribute("origin",mpReq.getOriginalFileName("file1")); //업로드할 때 당시 원래 이름
		//Returns the original filesystem name of the specified file 
		//(before any renaming policy was applied), or null if the file was not included in the upload.
		
		
		String recruit_name = request.getParameter("recruit_name");//모집공고이름
		String recruit_state = request.getParameter("recruit_state");//모집상태
		String file_name = mpReq.getFilesystemName("recruitfile");//저장된파일명
		RecruitDao dao = new RecruitDao();
		
		try {
		//*************************DB에 모집공고 정보 저장********************************
			dao.recruitUpload(recruit_name, file_name, recruit_state);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		request.getRequestDispatcher("lmssalesrecruitlist.bit").forward(request, response);//모집공고강좌정보메뉴로 이동.
		
	}

}
