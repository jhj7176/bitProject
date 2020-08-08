package com.bitjeju.lms.staff.lecture.model;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import java.sql.*;

public class LectureDao {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public LectureDao() {
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
		} // tryCatch
	}// constructor

	public ArrayList<LectureDto> selectAll() throws SQLException {

		ArrayList<LectureDto> list = new ArrayList<LectureDto>();
		String sql = "select * from lectures";
		LectureDto bean = null;

		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();

		while (rs.next()) {
			bean = new LectureDto();
			bean.setLecture_name(rs.getString("lecture_name"));
			bean.setStart_day(rs.getDate("start_day"));
			bean.setEnd_day(rs.getDate("end_day"));
			bean.setNum(rs.getInt("num"));
			bean.setLecture_room(rs.getInt("lecture_room"));
			bean.setLecture_num(rs.getInt("lecture_num"));
			list.add(bean);
		} // while

		if (pstmt != null)
			pstmt.close();
		if (conn != null)
			conn.close();

		return list;
	}// selectAll()
	
	public LectureDto selectOne(int lecture_num) throws SQLException {
		LectureDto bean = null;
		String sql = "select lecture_name, name, lecture_num, num, lecture_room, start_day, end_day";
			   sql+= " from lectures natural join member where lecture_num=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, lecture_num);
		rs = pstmt.executeQuery();

		while (rs.next()) {
			bean = new LectureDto();
			bean.setLecture_name(rs.getString("lecture_name"));
			bean.setStart_day(rs.getDate("start_day"));
			bean.setEnd_day(rs.getDate("end_day"));
			bean.setNum(rs.getInt("num"));
			bean.setLecture_room(rs.getInt("lecture_room"));
			bean.setLecture_num(rs.getInt("lecture_num"));
			bean.setName(rs.getString("name"));
		} // while
		
		if (pstmt != null)
			pstmt.close();
		if (conn != null)
			conn.close();
		return bean;
	}//selectOne
	
	public void insertLecture(String lecture_name,Date start_day,Date end_day,int num,int lecture_room) throws SQLException {
		/*insert into lectures values ('산업기사취득과정A',sysdate,sysdate,22,401,lectures_seq.nextval);
		 */		
		String sql = "insert into lectures values (?,?,?,?,?,lectures_seq.nextval);";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, lecture_name);
		pstmt.setDate(2, start_day);
		pstmt.setDate(3, end_day);
		pstmt.setInt(4, num);
		pstmt.setInt(5, lecture_room);
		pstmt.executeQuery();
		
		if (pstmt != null)
			pstmt.close();
		if (conn != null)
			conn.close();
		
	}//insert
	

}
