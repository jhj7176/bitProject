package com.bit.attendance.model;

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
		String sql="select * from attendance";
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				
				list.add(new AttendanceDto(rs.getDate("nalja"),rs.getInt("num"),rs.getString("state")));
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
	}//insertAll
	
	public ArrayList<AttendanceDto> dateSelectAll(Date nalja) throws SQLException {
		String sql="select * from attendance where nalja=?";
		AttendanceDto bean = null;
		ArrayList<AttendanceDto> list = new ArrayList<AttendanceDto>();
		try{
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setDate(1, nalja);			
			rs = pstmt.executeQuery();
			System.out.println(sql);
			while(rs.next()) {
				bean = new AttendanceDto();
				bean.setNalja(rs.getDate("nalja"));
				bean.setNum(rs.getInt("num"));
				bean.setState(rs.getString("state"));
				list.add(bean);
			}//while
			System.out.println(list.toString());
			
		}finally{
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		}
		return list;
	}
	
}