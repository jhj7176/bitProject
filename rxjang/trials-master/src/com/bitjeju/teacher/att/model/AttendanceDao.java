package com.bitjeju.teacher.att.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AttendanceDao {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public AttendanceDao() throws SQLException {
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
	
	public ArrayList<AttendanceDto> selectAll() throws SQLException{
		ArrayList<AttendanceDto> list=new ArrayList<AttendanceDto>();
		String sql="select nalja, attendance.num,name,state from attendance,member where attendance.num=member.num order by nalja desc";
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				list.add(new AttendanceDto(rs.getDate("nalja"),rs.getInt("num"),rs.getString("name"),rs.getString("state")));
			}
		}finally {
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		}
		
		return list;
	}
	
	public ArrayList<AttendanceDto> selectDate(Date nalja1, Date nalja2) throws SQLException{
		ArrayList<AttendanceDto> list=new ArrayList<AttendanceDto>();
		String sql="select nalja, attendance.num,name,state from attendance,member where attendance.num=member.num"
				+ " and nalja between ? and ? order by nalja desc";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setDate(1, nalja1);
			pstmt.setDate(2, nalja2);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				list.add(new AttendanceDto(rs.getDate("nalja"),rs.getInt("num"),rs.getString("name"),rs.getString("state")));
			}
		}finally {
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		}
		
		return list;
	}
	
	public int insertAll(Date nalja,int num,String state) throws SQLException{
		String sql="insert into attendance values (?,?,?)";
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setDate(1, nalja);
			pstmt.setInt(2, num);
			pstmt.setString(3, state);
			return pstmt.executeUpdate();
		}finally{
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		}
	}
	
}