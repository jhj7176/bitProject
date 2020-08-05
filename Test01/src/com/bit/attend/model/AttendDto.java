package com.bit.attend.model;

import java.sql.Date;

public class AttendDto {

	private int att, late, absent, mnum;
	private Date attdate;
	private String attendance;
	
	
	public String getAttendance() {
		return attendance;
	}
	public void setAttendance(String attendance) {
		this.attendance = attendance;
	}
	public int getAtt() {
		return att;
	}
	public void setAtt(int att) {
		this.att = att;
	}
	public int getLate() {
		return late;
	}
	public void setLate(int late) {
		this.late = late;
	}
	public int getAbsent() {
		return absent;
	}
	public void setAbsent(int absent) {
		this.absent = absent;
	}
	public int getMnum() {
		return mnum;
	}
	public void setMnum(int mnum) {
		this.mnum = mnum;
	}
	public Date getAttdate() {
		return attdate;
	}
	public void setAttdate(Date attDate) {
		// TODO Auto-generated method stub
		this.attdate = attDate;
		
	}


	
	
	
	
}
