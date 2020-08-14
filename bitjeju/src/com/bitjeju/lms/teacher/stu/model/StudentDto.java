package com.bitjeju.lms.teacher.stu.model;

import java.sql.Date;
import java.util.ArrayList;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

public class StudentDto {
	
	private int num, lecture_room, lecture_num, exam1, exam2, exam3;
	//학생 회원번호, 강의실 강좌번호,시험성적, 연락처
	private Date start_day, end_day;
	private String name, teacher_name, lecture_name, phone, id_email;
	//학생이름, 강사이름, 강좌명
	private ArrayList<String> attList;
	//출석테이블 정보를 담은 리스트
	private ArrayList<Date> attNaljaList;
	




	public String getId_email() {
		return id_email;
	}

	public void setId_email(String id_email) {
		this.id_email = id_email;
	}

	public String getLecture_name() {
		return lecture_name;
	}

	public void setLecture_name(String lecture_name) {
		this.lecture_name = lecture_name;
	}

	public StudentDto() {
		// TODO Auto-generated constructor stub
	}
	
	public double attRate() {
		int cnt = 0;//출석 카운트.
		for (int i=0 ; i<attList.size();i++) {//리스트 사이즈 = 총 수업들은 일 수 
			if(attList.get(i).equals("출석")) { 		//총 수업일 중 '출석'한 날
				cnt++;	//출석하면 카운트 +1	
			}//if
		}//for
		double ar = 0;
		if(attList.size()!=0) {
			ar = cnt*100/attList.size()*1.0;
		}
		
		return ar;//출석한날/총수업일 
	}
	
	public double classProgress() {//실제 수업일수/전체교육기간
		return attList.size()*100/90*1.0;
	}
	
	public int cntAtt() {
		int cnt=0;
		for (int i=0 ; i<attList.size();i++) {//리스트 사이즈 = 총 수업들은 일 수 
			if(attList.get(i).equals("출석")) { 		//총 수업일 중 '출석'한 날
				cnt++;	//출석하면 카운트 +1	
			}//if
		}//for
		return cnt;
	}
	public int cntLate() {
		int cnt=0;
		for (int i=0 ; i<attList.size();i++) {//리스트 사이즈 = 총 수업들은 일 수 
			if(attList.get(i).equals("지각")) { 		//총 수업일 중 '지각'한 날
				cnt++;	//지각하면 카운트 +1	
			}//if
		}//for
		return cnt;
	}
	public int cntEarly() {
		int cnt=0;
		for (int i=0 ; i<attList.size();i++) {//리스트 사이즈 = 총 수업들은 일 수 
			if(attList.get(i).equals("조퇴")) { 		//총 수업일 중 '조퇴'한 날
				cnt++;	//조퇴하면 카운트 +1	
			}//if
		}//for
		return cnt;
	}
	public int cntAbsent() {
		int cnt=0;
		for (int i=0 ; i<attList.size();i++) {//리스트 사이즈 = 총 수업들은 일 수 
			if(attList.get(i).equals("결석")) { 		//총 수업일 중 '결석'한 날
				cnt++;	//결석하면 카운트 +1	
			}//if
		}//for
		return cnt;
	}

	
	
	public ArrayList<String> getAttList() {
		return attList;
	}



	public void setAttList(ArrayList<String> attList) {
		this.attList = attList;
	}



	public ArrayList<Date> getAttNaljaList() {
		return attNaljaList;
	}



	public void setAttNaljaList(ArrayList<Date> attNaljaList) {
		this.attNaljaList = attNaljaList;
	}



	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getLecture_room() {
		return lecture_room;
	}
	public void setLecture_room(int lecture_room) {
		this.lecture_room = lecture_room;
	}
	public int getLecture_num() {
		return lecture_num;
	}
	public void setLecture_num(int lecture_num) {
		this.lecture_num = lecture_num;
	}
	public int getExam1() {
		return exam1;
	}
	public void setExam1(int exam1) {
		this.exam1 = exam1;
	}
	public int getExam2() {
		return exam2;
	}
	public void setExam2(int exam2) {
		this.exam2 = exam2;
	}
	public int getExam3() {
		return exam3;
	}
	public void setExam3(int exam3) {
		this.exam3 = exam3;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getStart_day() {
		return start_day;
	}
	public void setStart_day(Date start_day) {
		this.start_day = start_day;
	}
	public Date getEnd_day() {
		return end_day;
	}
	public void setEnd_day(Date end_day) {
		this.end_day = end_day;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTeacher_name() {
		return teacher_name;
	}
	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}



	
	

}
