package com.bitjeju.customer.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;

import com.bitjeju.customer.model.NoticeDto;


public class NoticeDao {
	
	java.util.logging.Logger log=Logger.getGlobal();
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public NoticeDao() throws SQLException{
		String driver= "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott";
		String password = "tiger";
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		conn=DriverManager.getConnection(url, user, password);
	}
	
	public NoticeDao(int int1, String string, String string2) {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<NoticeDto> selectAll() throws SQLException{
		String sql="select * from notice";
		ArrayList<NoticeDto> list = new ArrayList<NoticeDto>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				NoticeDto bean = new NoticeDto();
				bean.setNum(rs.getInt("num"));
				bean.setTitle(rs.getString("title"));
				bean.setWriter(rs.getString("writer"));
				bean.setWtime(rs.getDate("wtime"));
				list.add(bean);
				log.info(bean.toString());
			}
		} finally{
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		}
		
		return list;
	}
	
	/*
	 * 
	 * 	int num, read_cnt;
	String title, writer, content, filename;
	Date wtime;
	
	
	
	 *    ntnum number primary key,
   title varchar2(100) not null,
   num number,
   wtime date,
   content varchar2(3000),
   read_cnt number,
	 */
	public int insertOne(String title,String writer) throws SQLException{
		String sql="insert into notice values (notice_seq.nextval,?,?,sysdate,?,null)";
		//ntnum title writer wtime content read_cnt
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, writer);
			return pstmt.executeUpdate();
		}finally{
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();	
		}
	}

	public Object selectOne(int num) throws SQLException {
		String sql="select * from notice where num=?";
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			if(rs.next()) return new NoticeDao(
					rs.getInt("num")
					,rs.getString("title")
					,rs.getString("writer")
					);
		}finally{
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
			
		}
		return null;
	}

	public int updateOne(int num, String title, String writer) throws SQLException {
		String sql="update notice set title=?,writer=? where num=?";
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(3, num);
			pstmt.setString(1, title);
			pstmt.setString(2, writer);
			return pstmt.executeUpdate();
		}finally{
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		}
	}

}

	
		
	
