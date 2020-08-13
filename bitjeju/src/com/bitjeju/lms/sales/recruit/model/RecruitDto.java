package com.bitjeju.lms.sales.recruit.model;

public class RecruitDto {

	private String recruit_name, recruit_file_name, recruit_state;
	private int recruit_num;

	
	public RecruitDto() {
		// TODO Auto-generated constructor stub
	}
	
	public RecruitDto(String recruit_name, String recruit_file_name, String recruit_state, int recruit_num) {
		super();
		this.recruit_name = recruit_name;
		this.recruit_file_name = recruit_file_name;
		this.recruit_state = recruit_state;
		this.recruit_num = recruit_num;
	}
	@Override
	public String toString() {
		return "RecruitDto [recruit_name=" + recruit_name + ", recruit_file_name=" + recruit_file_name
				+ ", recruit_state=" + recruit_state + ", recruit_num=" + recruit_num + "]";
	}
	public String getRecruit_name() {
		return recruit_name;
	}
	public void setRecruit_name(String recruit_name) {
		this.recruit_name = recruit_name;
	}
	public String getRecruit_file_name() {
		return recruit_file_name;
	}
	public void setRecruit_file_name(String recruit_file_name) {
		this.recruit_file_name = recruit_file_name;
	}
	public String getRecruit_state() {
		return recruit_state;
	}
	public void setRecruit_state(String recruit_state) {
		this.recruit_state = recruit_state;
	}
	public int getRecruit_num() {
		return recruit_num;
	}
	public void setRecruit_num(int recruit_num) {
		this.recruit_num = recruit_num;
	}
	
	

}



