package com.bitjeju.customer.model;

import java.sql.Date;

public class NoticeDto {
	
	int num,ref,serial,lev;
	String title,writer,content,filename;
	Date wtime;
	
	public NoticeDto() {
		
	}
	
	public NoticeDto(int num, int ref, int serial, int lev, String title,
			String writer, String content, String filename, Date wtime) {
		super();
		this.num = num;
		this.ref = ref;
		this.serial = serial;
		this.lev = lev;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.filename = filename;
		this.wtime = wtime;
	}




	public NoticeDto(int int1, String string, String string2, Date date) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Board2Dto [num=" + num + ", ref=" + ref + ", serial=" + serial
				+ ", lev=" + lev + ", title=" + title + ", writer=" + writer
				+ ", content=" + content + ", filename=" + filename
				+ ", wtime=" + wtime + "]";
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getRef() {
		return ref;
	}
	public void setRef(int ref) {
		this.ref = ref;
	}
	public int getSerial() {
		return serial;
	}
	public void setSerial(int serial) {
		this.serial = serial;
	}
	public int getLev() {
		return lev;
	}
	public void setLev(int lev) {
		this.lev = lev;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public Date getWtime() {
		return wtime;
	}
	public void setWtime(Date wtime) {
		this.wtime = wtime;
	}
	

}
