package com.bitjeju.lms.sales.recruit.model;

import java.sql.*;

public class RecruitDao {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet re;

	public RecruitDao() {
		// TODO Auto-generated constructor stub
		String driver = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott";
		String password = "tiger";

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//catch

	}//constructor

	// ***********************업로드한 파일명과 모집공고 정보 DB에 입력**************************

	/*
	 * create table recruit (--모집공고게시판>>select * from lecture;>>모집공고 업로드하는 form>> 입력>>리쿠르트테이블에 insert
			recruit_name varchar2(150) not null,
			recruit_file_name varchar2(200),
			recruit_state varchar2(20), --공고없음, 모집전 ,모집중, 모집마감??
			recruit_num number primary key,
			foreign key(recruit_num) references lectures(lecture_num)
);
	 * 
	 * 
	 * */
	public void recruitUpload(String recruit_name, String file_name, String state) throws SQLException {
		
		String sql ="insert into recruit values (?,?,?,recruit_seq.nextval)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, recruit_name);
		pstmt.setString(2, file_name);
		pstmt.setString(3, state);
		pstmt.executeQuery();
		
		if(pstmt!=null) pstmt.close();
		if(conn!=null) conn.close();
		
	}//recruitupload
	
	
	
}
