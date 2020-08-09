package com.bitjeju.login.model;

import java.sql.*;
import java.util.ArrayList;

public class MemberDao {

	Connection conn;
	ResultSet rs;
	PreparedStatement pstmt;

	public MemberDao() {
		// TODO Auto-generated constructor stub
		String driver = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott";
		String password = "tiger";

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}//tryCatch

	}//constructor

	public MemberDto loginValidation(String id, String password) throws SQLException {
	
		String sql = "select * from member where id_email=? and password=?"; 
		//id와 pw 일치하는 회원의 정보를 모두 가져온다.
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, password);
		System.out.println(sql);
		rs = pstmt.executeQuery();
		
		MemberDto bean =null;
		if(rs.next()) {
			bean = new MemberDto();
			bean.setnum(rs.getInt("num"));
			bean.setId_email(rs.getString("id_email"));
			bean.setName(rs.getString("name"));
			bean.setDept(rs.getString("dept"));
			bean.setLvl(rs.getInt("lvl"));
			bean.setPassword(rs.getString("password"));
			bean.setPhone(rs.getInt("phone"));
			bean.setLecture(rs.getString("lecture"));
			
		}else {
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
			return new MemberDto("fail"); //객체생성후 id_email에 실패라고 저장하고 반환.
		}
		if(pstmt!=null) pstmt.close();
		if(conn!=null) conn.close();
		//if
		return bean; //로그인 성공하면 회원정보를 담은 bean을 반환
	}// login검증
	
	public ArrayList<MemberDto> selectAll(int pageNum, String key, String word) throws SQLException{
		ArrayList<MemberDto> list = new ArrayList<MemberDto>();
	

		int startNum = 1 + (pageNum - 1) * 5;
		int endNum = 5 + (pageNum - 1) * 5;// 페이지당 게시글 수
		// 게시글 컬럼명 제목 or 글쓴이
		// 게시글 검색어
//		if (key == null)
//			key = "title";
//		if (word == null)
//			word = "";
		
		String sql = "select * from (select num,id_email, name, dept, lvl, phone, lecture, rownum as rwn from ";
		sql += "(select * from member where " + key + " like '%" + word + "%')) ";
		sql += "where rwn between " + startNum + " and " + endNum;
		System.out.println(sql);

		MemberDto bean=null;
		
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			bean = new MemberDto();
			bean.setnum(rs.getInt("num"));
			bean.setId_email(rs.getString("id_email"));
			bean.setName(rs.getString("name"));
			bean.setDept(rs.getString("dept"));
			bean.setLvl(rs.getInt("lvl"));
			bean.setPhone(rs.getInt("phone"));
			bean.setLecture(rs.getString("lecture"));
			list.add(bean);
		}//while
		
		if(pstmt!=null) pstmt.close();
		if(conn!=null) conn.close();
		
		return list;
	}//selectAll
	
	public int totalMember() throws SQLException {
		String sql ="select count(*) as total from member";
		int totalMember = -1;
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		if(rs.next())
			totalMember = rs.getInt("total");
		
		if(pstmt!=null) pstmt.close();
		if(conn!=null) conn.close();
		return totalMember;
	}
	
	public int totalStudent() throws SQLException {
		String sql ="select count(*) as total from member where dept='수강생'";
		int totalStudent = -1;
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		if(rs.next())
			totalStudent = rs.getInt("total");
		
		if(pstmt!=null) pstmt.close();
		if(conn!=null) conn.close();
		return totalStudent;
	}
	
	public ArrayList<MemberDto> stuSelectAll(int pageNum, String key, String word) throws SQLException{
		ArrayList<MemberDto> list = new ArrayList<MemberDto>();
		//String sql ="select * from member where dept='수강생'";
		MemberDto bean=null;
		
		int startNum = 1 + (pageNum - 1) * 5;
		int endNum = 5 + (pageNum - 1) * 5;// 페이지당 게시글 수

		String sql = "select * from (select num,id_email, name, dept, lvl, phone, lecture, rownum as rwn from ";
		sql += "(select * from member where " + key + " like '%" + word + "%' and dept ='수강생')) ";
		sql += "where rwn between " + startNum + " and " + endNum;
		
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			bean = new MemberDto();
			bean.setnum(rs.getInt("num"));
			bean.setId_email(rs.getString("id_email"));
			bean.setName(rs.getString("name"));
			bean.setDept(rs.getString("dept"));
			bean.setLvl(rs.getInt("lvl"));
			bean.setPhone(rs.getInt("phone"));
			bean.setLecture(rs.getString("lecture"));
			list.add(bean);
		}//while

		
		if(pstmt!=null) pstmt.close();
		if(conn!=null) conn.close();
		
		return list;
	}//stselectAll()
	
	public MemberDto selectOne(int num) throws SQLException {
		String sql = "select * from member where num=?";
		MemberDto bean=null;
		
		pstmt= conn.prepareStatement(sql);
		pstmt.setInt(1, num);
		rs = pstmt.executeQuery();
		if(rs.next()) {
			bean = new MemberDto();
			bean.setnum(rs.getInt("num"));
			bean.setId_email(rs.getString("id_email"));
			bean.setName(rs.getString("name"));
			bean.setDept(rs.getString("dept"));
			bean.setLvl(rs.getInt("lvl"));
			bean.setPhone(rs.getInt("phone"));
			bean.setLecture(rs.getString("lecture"));
		}

		if(pstmt!=null) pstmt.close();
		if(conn!=null) conn.close();
		
		return bean;
	}//selectOne
	
	public void deleteOne(int num, String email) throws SQLException {
		String sql = "delete from member where num=? and id_email=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, num);
		pstmt.setString(2, email);
		System.out.println(sql);
		pstmt.executeQuery();
		if(pstmt!=null) pstmt.close();
		if(conn!=null) conn.close();
	}//delete
}
