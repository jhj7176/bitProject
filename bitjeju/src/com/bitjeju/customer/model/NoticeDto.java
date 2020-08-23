package com.bitjeju.customer.model;

import java.sql.Date;

public class NoticeDto {

	int num, read_cnt;
	String title, writer, content, filename;
	Date wtime;

	public NoticeDto() {

	}

	@Override
	public String toString() {
		return "NoticeDto [num=" + num + ", read_cnt=" + read_cnt + ", title=" + title + ", writer=" + writer
				+ ", content=" + content + ", filename=" + filename + ", wtime=" + wtime + "]";
	}

	public NoticeDto(int num, int read_cnt, String title, String writer, String content, String filename, Date wtime) {
		super();
		this.num = num;
		this.read_cnt = read_cnt;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.filename = filename;
		this.wtime = wtime;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getRead_cnt() {
		return read_cnt;
	}

	public void setRead_cnt(int read_cnt) {
		this.read_cnt = read_cnt;
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
