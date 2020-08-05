package com.bit.attend.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class AttendDao {

	DataSource dataSource;
	PreparedStatement pstmt;
	ResultSet rs;
	Connection conn;
	
	public AttendDao() {
		// TODO Auto-generated constructor stub
		
		try {
			InitialContext init = new InitialContext();
			Context context = (Context) init.lookup("java:/comp/env");
			dataSource = (javax.sql.DataSource) context.lookup("jdbc/oracle");;
			
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public void updateAttend(int mnum, int att, int late, int absent) throws SQLException {
		String sql2 = "select att, late, absent from attend where mnum = ?"; //������ �⼮ ������ ������.
		conn = dataSource.getConnection();
		pstmt = conn.prepareStatement(sql2);
		pstmt.setInt(1, mnum);
		rs = pstmt.executeQuery();
		int oatt = 0;
		int olate = 0;
		int oabsent = 0;
		while(rs.next()) {
			oatt = rs.getInt("att");
			olate = rs.getInt("late");
			oabsent = rs.getInt("absent");
		}//while
	
		if(pstmt!=null) pstmt.close();
		String sql ="update attend set att=?, late=?, absent=? where mnum=?"; //�� �⼮���� ������Ʈ,
		
		//conn = dataSource.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, oatt+att);	//servlet���� ȣ���� �� att~absent���� �ֳľ��Ŀ� ���� 0�̳� 1�� �Ķ���ͷ� �ش�. 
		pstmt.setInt(2, olate+late);	//���� �⼮ �������� +1�̳� +0�� �Ѵ�. 
		pstmt.setInt(3, oabsent+absent);
		pstmt.setInt(4, mnum);
		pstmt.executeQuery();
		
		if(pstmt!=null) pstmt.close();
		if(conn!=null) conn.close();
		
	}//update
	
	
	public ArrayList<AttendDto> selectAll() throws SQLException{
		ArrayList<AttendDto> list = new ArrayList<AttendDto>();
		
		String sql = "select * from attend";
		AttendDto bean = null;
		conn = dataSource.getConnection();
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			bean = new AttendDto();
			bean.setMnum(rs.getInt("mnum"));
			bean.setName(rs.getString("name"));
			bean.setAtt(rs.getInt("att"));
			bean.setLate(rs.getInt("late"));
			bean.setAbsent(rs.getInt("absent"));
			list.add(bean);
		}//bean
		if(pstmt!=null) pstmt.close();
		if(conn!=null) conn.close();
		return list;
	}//selectAll
	
	
	
	
}
