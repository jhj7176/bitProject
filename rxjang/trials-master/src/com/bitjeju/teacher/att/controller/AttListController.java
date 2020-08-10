package com.bitjeju.teacher.att.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bitjeju.teacher.att.model.AttendanceDao;
import com.bitjeju.teacher.att.model.AttendanceDto;

@WebServlet("/lmsteacherattlist.bit")
public class AttListController extends HttpServlet {

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   request.setCharacterEncoding("utf-8");
	   try {
         AttendanceDao dao=new AttendanceDao();
         ArrayList<AttendanceDto> list=dao.selectAll();
         request.setAttribute("list", list);
      } catch (SQLException e) {
         e.printStackTrace();
      }
      
      request.getRequestDispatcher("teacherAttList.jsp").forward(request, response);
      
   }
   
   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      Date nalja =null;
      int num=-1;
      String state=null;
      req.setCharacterEncoding("utf-8");
      
      Enumeration<String> en = req.getParameterNames();   
      while(en.hasMoreElements()) {
         
         String pa1 = en.nextElement();
         String pa2 = en.nextElement();
         String pa3 = en.nextElement();
      
         num = Integer.parseInt(req.getParameter(pa1).trim());
         nalja = Date.valueOf(req.getParameter(pa2).trim());
         state = req.getParameter(pa3).trim();
         try {
            AttendanceDao dao=new AttendanceDao();
            dao.insertAll(nalja, num, state);
         } catch (SQLException e) {
            e.printStackTrace();
         }
         
      }//while
    
      resp.sendRedirect("lmsteacherattlist.bit");   
   }

}