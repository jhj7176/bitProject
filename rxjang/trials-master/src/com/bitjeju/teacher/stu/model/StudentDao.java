package com.bitjeju.teacher.stu.model;

import java.sql.Connection;
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
	}
}