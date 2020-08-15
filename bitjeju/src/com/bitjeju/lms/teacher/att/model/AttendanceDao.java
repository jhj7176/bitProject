package com.bitjeju.lms.teacher.att.model;

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
	public ArrayList<AttendanceDto> selectAll(int num) throws SQLException{
		ArrayList<AttendanceDto> list=new ArrayList<AttendanceDto>();
		String sql="select nalja, attendance.num,name,state from attendance,member where attendance.num=member.num "
				+ "and lecture=(select lecture from member where num=?) order by nalja desc, num asc";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
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

	public ArrayList<AttendanceDto> selectDate(Date nalja1, Date nalja2, int num) throws SQLException{
		ArrayList<AttendanceDto> list=new ArrayList<AttendanceDto>();
		String sql="select nalja, attendance.num,name,state from attendance,member where attendance.num=member.num "
				+ "and nalja between ? and ? and lecture=(select lecture from member where num=?) "
				+ "order by nalja desc, num asc";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setDate(1, nalja1);
			pstmt.setDate(2, nalja2);
			pstmt.setInt(3, num);
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
	
	public ArrayList<AttendanceDto> selectName(String name,int num) throws SQLException{
		ArrayList<AttendanceDto> list=new ArrayList<AttendanceDto>();
		String sql="select nalja, attendance.num,name,state from attendance,member where attendance.num=member.num "
				+ "and name=? and lecture=(select lecture from member where num=?) order by nalja desc, num asc";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setInt(2, num);
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
	

	public AttendanceDto selectOne(int num, Date nalja) throws SQLException {
		AttendanceDto bean=null;
		String sql = " select nalja,num,name,state from attendance natural join member where num=? and nalja=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, num);
		pstmt.setDate(2, nalja);
		rs = pstmt.executeQuery();
		try{
			if (rs.next()) {
				bean= new AttendanceDto();
				bean.setNalja(rs.getDate("nalja"));
				bean.setNum(rs.getInt("num"));
				bean.setName(rs.getString("name"));
				bean.setState(rs.getString("state"));
			}
		}finally{
			if (pstmt != null)pstmt.close();
			if (conn != null)conn.close();
		}
		return bean;
	}
	
	public int updateOne(int num, Date nalja , String state) throws SQLException{
		String sql="update attendance set state=? where num=? and nalja=?";
		int result=0;
		System.out.println("state = "+state);
		PreparedStatement pstmt=null;
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, state);
			pstmt.setInt(2, num);
			pstmt.setDate(3, nalja);
			result=pstmt.executeUpdate();
		}finally{
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		}
		return result;
	}

}