package com.woniu.action;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.woniu.pojo.Uphoto;
import com.woniu.pojo.User;
import com.woniu.service.IUserService;
import com.woniu.service.impl.UserServiceImpl;

public class UserAction {
	IUserService us = new UserServiceImpl();
	private List<Uphoto> list;
	private User user;
	private Uphoto uphoto;
	private File photo;
	private String photoFileName;
	
	public File getPhoto() {
		return photo;
	}
	public void setPhoto(File photo) {
		this.photo = photo;
	}
	public String getPhotoFileName() {
		return photoFileName;
	}
	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}
	public List<Uphoto> getList() {
		return list;
	}
	public void setList(List<Uphoto> list) {
		this.list = list;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Uphoto getUphoto() {
		return uphoto;
	}
	public void setUphoto(Uphoto uphoto) {
		this.uphoto = uphoto;
	}
	
	
	public String login(){
		user=us.login(user);
		System.out.println("%%%%%%%%%%"+user);
		if(user!=null){
			ActionContext ac=ActionContext.getContext();
			Map<String,Object> session =ac.getSession();
			session.put("loginUser", user);
			
		}
		return "ok";
	}
	
	public String getA(){
		list=us.findAll();
//		System.out.println("@@@@@"+list);
		return "list";
	}
	public String add(){
		String path = ServletActionContext.getRequest().getServletContext().getRealPath("/upload");
		System.out.println(path);
		File dir = new File(path);
		if(!dir.exists()){
			dir.mkdirs();
		}
		photoFileName = photoFileName.substring(photoFileName.lastIndexOf("."));
		String fileName = UUID.randomUUID()+photoFileName;
		uphoto.setPhoto(fileName);
		try {
			FileUtils.copyFile(photo, new File(dir,fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("$$$$"+uphoto);
		us.reg(uphoto);
		return "ok";
	}
	public String addF(){
		us.add(uphoto);
		return "add";
	}
	
	
}
