package com.bitjeju.lms.teacher.grade.model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GradeDao {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public GradeDao() throws SQLException {
		String driver="oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="scott";
		String password="tiger";
		
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		conn=DriverManager.getConnection(url,user,password);
	}
	
	public ArrayList<GradeDto> selectAll(int teacherNum) throws SQLException{
		ArrayList<GradeDto> list=new ArrayList<GradeDto>();
		//String sql="select grade.num,exam1,exam2,exam3, name from grade, member where grade.num=member.num";
		String sql="select grade.num,exam1,exam2,exam3, name from grade, "
				+ "(select num,name from  member where lvl=2 and lecture = "
				+ "(select lecture from member where num = ?)) m where grade.num=m.num";
		
		
		/* 선생님 번호 있음 선생님 번호로 선생님 과목 알아내고  이과목명으로 해당과목을 수강하는 수강생번호 (과목이 같ㅌ음 멤버테이블). 
		 * 
		 * select grade.num,exam1,exam2,exam3, name from grade, member where grade.num=( select num from  member where lecture = (select lecture from member where num = 100))";
		 * 
		 * select num from  member where lecture = (select lecture from member where num = 100); 
		 * 
		 * select 번호, 학생ㅇ이름, 점수들 from grade
		 */
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, teacherNum);
			rs=pstmt.executeQuery();
			while(rs.next()){
				list.add(new GradeDto(rs.getInt("num"),rs.getInt("exam1"),rs.getInt("exam2"),rs.getInt("exam3"),rs.getString("name")));
			}
			
		}finally{
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		}
		return list;
	}
	
	public int updateOne(int num,String exam, int grade) throws SQLException{
		String sql="update grade set "+exam+"=? where num=?";
		int result=0;
		PreparedStatement pstmt=null;
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, grade);
			pstmt.setInt(2, num);
			pstmt.executeQuery();
		}finally{
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		}
		return result;
	}
}