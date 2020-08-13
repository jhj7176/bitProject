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

	// ***********************���ε��� ���ϸ�� �������� ���� DB�� �Է�**************************

	/*
	 * create table recruit (--��������Խ���>>select * from lecture;>>�������� ���ε��ϴ� form>> �Է�>>����Ʈ���̺� insert
			recruit_name varchar2(150) not null,
			recruit_file_name varchar2(200),
			recruit_state varchar2(20), --�������, ������ ,������, ��������??
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
