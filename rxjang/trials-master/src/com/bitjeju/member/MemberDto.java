package com.bitjeju.member;

public class MemberDto {
	private int num;
	private String id_email;
	private String name;
	private int lvl;
	private String password;
	private int phone;
	private String lecture;
	
	public MemberDto() {}
	
	public MemberDto(int num, String name) {
		super();
		this.num = num;
		this.name = name;
	}

	public MemberDto(int num, String id_email, String name, int lvl,
			String password, int phone, String lecture) {
		super();
		this.num = num;
		this.id_email = id_email;
		this.name = name;
		this.lvl = lvl;
		this.password = password;
		this.phone = phone;
		this.lecture = lecture;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getId_email() {
		return id_email;
	}
	public void setId_email(String id_email) {
		this.id_email = id_email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLvl() {
		return lvl;
	}
	public void setLvl(int lvl) {
		this.lvl = lvl;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getLecture() {
		return lecture;
	}
	public void setLecture(String lecture) {
		this.lecture = lecture;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((id_email == null) ? 0 : id_email.hashCode());
		result = prime * result + ((lecture == null) ? 0 : lecture.hashCode());
		result = prime * result + lvl;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + num;
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result + phone;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MemberDto other = (MemberDto) obj;
		if (id_email == null) {
			if (other.id_email != null)
				return false;
		} else if (!id_email.equals(other.id_email))
			return false;
		if (lecture == null) {
			if (other.lecture != null)
				return false;
		} else if (!lecture.equals(other.lecture))
			return false;
		if (lvl != other.lvl)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (num != other.num)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phone != other.phone)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "memberDto [num=" + num + ", id_email=" + id_email + ", name="
				+ name + ", lvl=" + lvl + ", password=" + password + ", phone="
				+ phone + ", lecture=" + lecture + "]";
	}
	
}
