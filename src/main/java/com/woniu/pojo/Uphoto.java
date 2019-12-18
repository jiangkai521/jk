package com.woniu.pojo;

import java.io.Serializable;

public class Uphoto implements Serializable{
	private Integer uid;
	private Integer pid;
	private String photo;
	private String prole;
	private String pstate;
	public Uphoto() {
		super();
	}
	public Uphoto(Integer uid, Integer pid, String photo, String prole, String pstate) {
		super();
		this.uid = uid;
		this.pid = pid;
		this.photo = photo;
		this.prole = prole;
		this.pstate = pstate;
	}
	
	public Uphoto(Integer uid, String photo, String prole, String pstate) {
		super();
		this.uid = uid;
		this.photo = photo;
		this.prole = prole;
		this.pstate = pstate;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getProle() {
		return prole;
	}
	public void setProle(String prole) {
		this.prole = prole;
	}
	public String getPstate() {
		return pstate;
	}
	public void setPstate(String pstate) {
		this.pstate = pstate;
	}
	@Override
	public String toString() {
		return "Uphoto [uid=" + uid + ", pid=" + pid + ", photo=" + photo + ", prole=" + prole + ", pstate=" + pstate
				+ "]";
	}
	

}
