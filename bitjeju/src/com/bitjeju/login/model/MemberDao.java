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
		//id�� pw ��ġ�ϴ� ȸ���� ������ ��� �����´�.
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
			return new MemberDto("fail"); //��ü������ id_email�� ���ж�� �����ϰ� ��ȯ.
		}
		if(pstmt!=null) pstmt.close();
		if(conn!=null) conn.close();
		//if
		return bean; //�α��� �����ϸ� ȸ�������� ���� bean�� ��ȯ
	}// login����
	
	public ArrayList<MemberDto> selectAll() throws SQLException{
		ArrayList<MemberDto> list = new ArrayList<MemberDto>();
		String sql ="select * from member";
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
			bean.setPassword(rs.getString("password"));
			bean.setPhone(rs.getInt("phone"));
			bean.setLecture(rs.getString("lecture"));
			list.add(bean);
		}//while
		
		if(pstmt!=null) pstmt.close();
		if(conn!=null) conn.close();
		
		return list;
	}

}
