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
		//**********************************���� ���� ������**********************************
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
		int fsize = 1*1024*1024*1024*50; //50�ް�����Ʈ ����.

		//****************************************���� ���ε�****************************************
		//""+System.currentTimeMillis()
		//������ �Ķ���� (request, Directory, int maxPostSize)
		//������ �Ķ���� (request, Directory, int maxPostSize, File rename)
		//������ �Ķ���� (request, Directory, int maxPostSize, encoding , File rename)
		
				//1byte 1kb 1mb 1gb
	
		//String rename=""+System.currentTimeMillis();
		DefaultFileRenamePolicy frp = new DefaultFileRenamePolicy();//���ϸ��� ������ rename���ش�.	
		
		MultipartRequest mpReq = new MultipartRequest(request, path, fsize, "utf-8" ,frp);// ���ε��ϴ� ���� �޴� ��ü	
													//���� ��û, ���, ����ũ��, ���ڵ� ����, rename��ü
		System.out.println(request.getParameter("sabun"));
		System.out.println(mpReq.getParameter("sabun"));
		System.out.println("Rename"+mpReq.getFilesystemName("file1"));
		//form tag ���� file type input�� name
		System.out.println("�����̸�"+mpReq.getOriginalFileName("file1"));
		
		request.setAttribute("rename",mpReq.getFilesystemName("file1")); //������ ����� �ٲ��̸�
		request.setAttribute("origin",mpReq.getOriginalFileName("file1")); //���ε��� �� ��� ���� �̸�
		//Returns the original filesystem name of the specified file 
		//(before any renaming policy was applied), or null if the file was not included in the upload.
		
		
		String recruit_name = request.getParameter("recruit_name");//���������̸�
		String recruit_state = request.getParameter("recruit_state");//��������
		String file_name = mpReq.getFilesystemName("recruitfile");//��������ϸ�
		RecruitDao dao = new RecruitDao();
		
		try {
		//*************************DB�� �������� ���� ����********************************
			dao.recruitUpload(recruit_name, file_name, recruit_state);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		request.getRequestDispatcher("lmssalesrecruitlist.bit").forward(request, response);//���������������޴��� �̵�.
		
	}

}
