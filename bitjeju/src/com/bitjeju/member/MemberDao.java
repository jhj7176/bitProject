package com.bitjeju.member;

import java.sql.*;
import java.util.ArrayList;

public class MemberDao {

	private Connection conn;
	private ResultSet rs;
	private PreparedStatement pstmt;

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
		} // tryCatch

	}// constructor

	public MemberDto loginValidation(String id, String password) throws SQLException {

		String sql = "select num,id_email,name,dept,lvl,password,phone,lecture from member natural join bitjejudept where id_email=? and password=?";
		// id�� pw ��ġ�ϴ� ȸ���� ������ ��� �����´�.
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, password);
		System.out.println(sql);
		rs = pstmt.executeQuery();

		MemberDto bean = null;
		if (rs.next()) {
			bean = new MemberDto();
			bean.setNum(rs.getInt("num"));
			bean.setId_email(rs.getString("id_email"));
			bean.setName(rs.getString("name"));
			bean.setDept(rs.getString("dept"));
			bean.setLvl(rs.getInt("lvl"));
			bean.setPassword(rs.getString("password"));
			bean.setPhone(rs.getInt("phone"));
			bean.setLecture(rs.getString("lecture"));

		} else {
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
			return new MemberDto("fail"); // ��ü������ id_email�� ���ж�� �����ϰ� ��ȯ.
		}
		if (pstmt != null)
			pstmt.close();
		if (conn != null)
			conn.close();
		// if
		return bean; // �α��� �����ϸ� ȸ�������� ���� bean�� ��ȯ
	}// login����

	public ArrayList<MemberDto> selectAll(int pageNum, String key, String word) throws SQLException {
		ArrayList<MemberDto> list = new ArrayList<MemberDto>();

		int startNum = 1 + (pageNum - 1) * 5;
		int endNum = 5 + (pageNum - 1) * 5;// �������� �Խñ� ��
		// �Խñ� �÷��� ���� or �۾���
		// �Խñ� �˻���
//		if (key == null)
//			key = "title";
//		if (word == null)
//			word = "";

		String sql = "select * from (select num,id_email, name, dept, lvl, phone, lecture, rownum as rwn from ";
		sql += "(select * from member natural join bitjejudept where " + key + " like '%" + word + "%')) ";
		sql += "where rwn between " + startNum + " and " + endNum;
		System.out.println(sql);

		MemberDto bean = null;

		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();

		while (rs.next()) {
			bean = new MemberDto();
			bean.setNum(rs.getInt("num"));
			bean.setId_email(rs.getString("id_email"));
			bean.setName(rs.getString("name"));
			bean.setDept(rs.getString("dept"));
			bean.setLvl(rs.getInt("lvl"));
			bean.setPhone(rs.getInt("phone"));
			bean.setLecture(rs.getString("lecture"));
			list.add(bean);

		} // while

		if (pstmt != null)
			pstmt.close();
		if (conn != null)
			conn.close();

		return list;
	}// selectAll

	public int totalMember(String key, String word) throws SQLException {// �˻��Ҷ��� ���ǿ� �´� ��� row���� ���� ��ȯ.
		String sql = "select count(*) as total from (select rownum as rwn from ";
		sql += "(select * from member natural join bitjejudept where " + key + " like '%" + word + "%')) ";
		// String sql = "select count(*) as total from member";
		int totalMember = -1;
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		if (rs.next())
			totalMember = rs.getInt("total");

		if (pstmt != null)
			pstmt.close();
		if (conn != null)
			conn.close();
		return totalMember;
	}

	public int totalStudent(String key, String word) throws SQLException {

		String sql = "select count(*) as total from (select rownum as rwn from ";
		sql += "(select * from member natural join bitjejudept where " + key + " like '%" + word
				+ "%' and dept ='������')) ";
		// String sql = "select count(*) as total from member where lvl=2";
		int totalStudent = -1;
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		if (rs.next())
			totalStudent = rs.getInt("total");

		if (pstmt != null)
			pstmt.close();
		if (conn != null)
			conn.close();
		return totalStudent;
	}

	public ArrayList<MemberDto> stuSelectAll(int pageNum, String key, String word) throws SQLException {
		ArrayList<MemberDto> list = new ArrayList<MemberDto>();
		// String sql ="select * from member where dept='������'";
		MemberDto bean = null;

		int startNum = 1 + (pageNum - 1) * 5;
		int endNum = 5 + (pageNum - 1) * 5;// �������� �Խñ� ��

		String sql = "select * from (select num,id_email, name, dept, lvl, phone, lecture, rownum as rwn from ";
		sql += "(select * from member natural join bitjejudept where " + key + " like '%" + word
				+ "%' and dept ='������')) ";
		sql += "where rwn between " + startNum + " and " + endNum;
		System.out.println(sql);
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();

		while (rs.next()) {
			bean = new MemberDto();
			bean.setNum(rs.getInt("num"));
			bean.setId_email(rs.getString("id_email"));
			bean.setName(rs.getString("name"));
			bean.setDept(rs.getString("dept"));
			bean.setLvl(rs.getInt("lvl"));
			bean.setPhone(rs.getInt("phone"));
			bean.setLecture(rs.getString("lecture"));
			list.add(bean);

		} // while

		if (pstmt != null)
			pstmt.close();
		if (conn != null)
			conn.close();

		return list;
	}// stselectAll()

	public MemberDto selectOne(int num) throws SQLException {
		// String sql = "select * from member where num=?";
		String sql = "select num, id_email, name, dept, lvl, phone, "
				+ "lecture from member natural join bitjejudept where num=?";
		MemberDto bean = null;
//.........
		/*
		 * String sqldept = "select dept from bitjejudept where lvl=?";
		 * 
		 * select num, id_email, name, dept, lvl, phone, lecture from member natural
		 * join bitjeju
		 * 
		 */
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, num);
		rs = pstmt.executeQuery();
		if (rs.next()) {
			bean = new MemberDto();
			bean.setNum(rs.getInt("num"));
			bean.setId_email(rs.getString("id_email"));
			bean.setName(rs.getString("name"));
			bean.setDept(rs.getString("dept"));
			bean.setLvl(rs.getInt("lvl"));
			bean.setPhone(rs.getInt("phone"));
			bean.setLecture(rs.getString("lecture"));

		}

		if (pstmt != null)
			pstmt.close();
		if (conn != null)
			conn.close();

		return bean;
	}// selectOne

	public void deleteOne(int num, String email) throws SQLException {
		String sql = "delete from member where num=? and id_email=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, num);
		pstmt.setString(2, email);
		System.out.println(sql);
		pstmt.executeQuery();
		if (pstmt != null)
			pstmt.close();
		if (conn != null)
			conn.close();
	}// delete

	public void insertOne(String emailid, String name, String dept, String pw, int phone) throws SQLException {
		// ��������Ҷ�,
		int lvl = -1;
		if (dept.equals("����")) {
			lvl = 3;
		} else if (dept.equals("����")) {
			lvl = 4;
		} else if (dept.equals("����")) {
			lvl = 5;
		} else if (dept.equals("ȸ��")) {
			lvl = 4;
		} else if (dept.equals("���")) {
			lvl = 3;
		} else if (dept.equals("������")) { // �μ��� ���� ���� �ڵ��ο�
			lvl = 6;
		}
		String sql = "insert into member values (member_seq.nextval||member_seq.nextval,";
		sql += "?,?,?,?,?,null)";
//�̸��� �̸� �μ� ���� ��� ��ȭ��ȣ ���¸� 

		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, emailid);
		pstmt.setString(2, name);
		pstmt.setInt(3, lvl);
		pstmt.setString(4, pw);
		pstmt.setInt(5, phone);
		System.out.println(sql);
		rs = pstmt.executeQuery();

		if (pstmt != null)
			pstmt.close();
		if (conn != null)
			conn.close();

	}// insert

	public int signUp(String id_email, String name, String password, int phone) throws SQLException {

		// insert into member values
		// (member_seq.nextval||member_seq.currval,'teacher6@email.com',
		// '������','����',3,'password'
		// ,01012341235,null);

		String sql2 = "select id_email from member where id_email = ?";
		pstmt = conn.prepareStatement(sql2);
		pstmt.setString(1, id_email);
		System.out.println(sql2);
		rs = pstmt.executeQuery();
		if(rs.next()) {
		
			return -1;
		}	
		
		if (pstmt != null)
			pstmt.close();

		String sql = "insert into member values (member_seq.nextval||member_seq.currval" + ",?,?,0,?,?,null)";

		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id_email);
		pstmt.setString(2, name);
		pstmt.setString(3, password);
		pstmt.setInt(4, phone);
		System.out.println(sql);
		pstmt.executeQuery();

		if (pstmt != null)
			pstmt.close();
		if (conn != null)
			conn.close();
		return 1;

	}// signUp

}// classEnd
