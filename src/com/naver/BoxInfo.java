package com.naver;

import java.io.Serializable;

public class BoxInfo implements Serializable{

	private static final long serialVersionUID = 1L;
	private int boxnum;
	private String id;
	private String item1;
	private String item2;
	private String item3;
	private int pw;
	public BoxInfo() {
		// TODO Auto-generated constructor stub
	}
	public BoxInfo(int boxnum, String id, String item1, String item2, String item3, int pw) {
		super();
		this.boxnum = boxnum;
		this.id = id;
		this.item1 = item1;
		this.item2 = item2;
		this.item3 = item3;
		this.pw = pw;
	}
	
	
	public BoxInfo(int boxnum, int pw) {
		super();
		this.boxnum = boxnum;
		this.pw = pw;
	}
	public BoxInfo(int boxnum) {
		super();
		this.boxnum = boxnum;
	}
	public int getBoxnum() {
		return boxnum;
	}
	public void setBoxnum(int boxnum) {
		this.boxnum = boxnum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getItem1() {
		return item1;
	}
	public void setItem1(String item1) {
		this.item1 = item1;
	}
	public String getItem2() {
		return item2;
	}
	public void setItem2(String item2) {
		this.item2 = item2;
	}
	public String getItem3() {
		return item3;
	}
	public void setItem3(String item3) {
		this.item3 = item3;
	}
	public int getPw() {
		return pw;
	}
	public void setPw(int pw) {
		this.pw = pw;
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
		BoxInfo other = (BoxInfo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	@Override
	   public String toString() {
	      return boxnum + "번 보관함 : " + id + " : " + item1 + " : " + item2 + " : " + item3;
	   }
	 
}
