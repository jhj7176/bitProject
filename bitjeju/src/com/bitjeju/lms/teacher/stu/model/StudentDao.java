package com.bitjeju.lms.teacher.stu.model;


import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bitjeju.member.MemberDto;

public class StudentDao {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public StudentDao() throws SQLException {
		String driver="oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="scott";
		String password="tiger";
		
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		conn=DriverManager.getConnection(url, user, password);
	}
	
	public ArrayList<MemberDto> selectAll() throws SQLException{
		ArrayList<MemberDto> list=new ArrayList<MemberDto>();
		String sql="select * from member where lvl=2";
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {			
				list.add(new MemberDto(rs.getInt("num"),rs.getString("name")));
			}
		}finally {
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		}
		
		return list;
	}//selectAll

	
	public StudentDto stuSelectOne(int num) throws SQLException {
		
	//학생디테일페이지 
	//이름, 강좌명, 강사명, 강의실, 전화번호, 출석률, 성적, 교육기간
		StudentDto bean = new StudentDto();
		//String sql = "select * from member natural join grade where num =?";//이름 전화번호 강좌 등
		String sql ="select * from member full outer join grade on member.num=grade.num where member.num=?";
		pstmt = conn.prepareStatement(sql);
		System.out.println(sql);
		pstmt.setInt(1, num);
		rs = pstmt.executeQuery();
		if(rs.next()) {
			bean.setNum(rs.getInt("num"));//학생 회원번호
			bean.setPhone(rs.getString("phone"));//학생 전화번호
			bean.setLecture_name(rs.getString("lecture"));//듣는 강좌명
			bean.setName(rs.getString("name"));//학생이름
			bean.setExam1(rs.getInt("exam1"));
			bean.setExam2(rs.getInt("exam2"));//성적들
			bean.setExam3(rs.getInt("exam3"));
			bean.setId_email(rs.getString("id_email"));
			System.out.println(rs.getString("id_email"));
		}
		if(pstmt!=null)pstmt.close();
		
		
		String sql2 = "select lecture_name, lecture_num, lecture_room, name, start_day, end_day "
				+ "from lectures natural join member "
				+ "where lecture_name=(select lecture from member where num=?)";//강사 강의실
		pstmt = conn.prepareStatement(sql2);
		pstmt.setInt(1, num);	
		System.out.println(sql2);
		rs = pstmt.executeQuery();
		
		if(rs.next()) {
			bean.setStart_day(rs.getDate("start_day"));//개강일
			bean.setEnd_day(rs.getDate("end_day"));//종강일
			bean.setTeacher_name(rs.getString("name"));//강사이름
			bean.setLecture_room(rs.getInt("lecture_room"));//강의실
			bean.setLecture_num(rs.getInt("lecture_num"));//강좌 고유번호
		}
		if(pstmt!=null)pstmt.close();
		
		
		String sql3 = "select * from attendance where num = ?"; //출석과 날짜받기
		pstmt = conn.prepareStatement(sql3);
		System.out.println(sql3);
		pstmt.setInt(1, num);
		rs = pstmt.executeQuery();
		//날짜 + 출석상태를 저장해야함. 
		ArrayList<String> attList = new ArrayList<String>();
		ArrayList<Date> attNaljaList = new ArrayList<Date>();
		while(rs.next()) {
			attList.add(rs.getString("state"));
			attNaljaList.add(rs.getDate("nalja"));
		}
		bean.setAttList(attList);//컨트롤러에서 bean.attRate()메서드로 출석률 얻을 수 있다. 
		bean.setAttNaljaList(attNaljaList);

		
		if(pstmt!=null)pstmt.close();
		if(conn!=null)conn.close();
		
		return bean;
	}//stuselectONE
	
	public void studeleteOne(int num) throws SQLException {
		String sql ="delete from member where num = ?";
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, num);
		pstmt.executeQuery();
		System.out.println(sql);
		if(rs!=null)rs.close();
		if(pstmt!=null)pstmt.close();
		
	}
	
	
}