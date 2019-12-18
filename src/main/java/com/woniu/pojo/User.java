package com.woniu.pojo;

import java.io.Serializable;

public class User implements Serializable{
	private Integer uid;
	private String uname;
	private String upwd;
	private String urole;
	public User() {
		super();
	}
	public User(Integer uid, String uname, String upwd, String urole) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.upwd = upwd;
		this.urole = urole;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	public String getUrole() {
		return urole;
	}
	public void setUrole(String urole) {
		this.urole = urole;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", upwd=" + upwd + ", urole=" + urole + "]";
	}
	
}
