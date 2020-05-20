package com.naver;
import java.io.Serializable;

public class PersonInfo implements Serializable{

	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private int ph;
	public PersonInfo() {
		// TODO Auto-generated constructor stub
	}
	public PersonInfo(String id, String name, int ph) {
		super();
		this.id = id;
		this.name = name;
		this.ph = ph;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPh() {
		return ph;
	}
	public void setPh(int ph) {
		this.ph = ph;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		PersonInfo other = (PersonInfo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "회원 ID:" + id + ", 회원 이름:" + name + ", 회원 폰번호:" + ph;
	}
	

}
