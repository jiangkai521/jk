package com.woniu.dao.impl;

import java.util.List;

import com.woniu.dao.IUserDAO;
import com.woniu.pojo.Uphoto;
import com.woniu.pojo.User;
import com.woniu.tools.BaseDAO;


public class UserDAOImpl implements IUserDAO {
	BaseDAO<User> bd = new BaseDAO<User>();
	BaseDAO<Uphoto> upd = new BaseDAO<Uphoto>();
	
	@Override
	public void save(User obj) {
		String sql = "insert into user values(?,?,?,?,?,?)";
		Object[] objs = {obj.getUid(),obj.getUname(),obj.getUpwd(),obj.getUrole()};
		bd.update(sql, objs);
	}

	@Override
	public void update(User obj) {
		// TODO Auto-generated method stub
		String sql = "update user set uname=?,upwd=?,uphoto=?,usex=?,rid=? where uid=?";
		Object[] objs = {obj.getUname(),obj.getUpwd(),obj.getUrole(),obj.getUid()};
		bd.update(sql, objs);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		String sql = "delete from user where uid=?";
		Object[] objs = {id};
		bd.update(sql, objs);
	}

	@Override
	public User findOne(Integer id) {
		String sql = "select * from user where uid=?";
		Object[] objs = {id};
		List<User> users = bd.select(sql, objs,User.class);
		return users.size()==0?null:users.get(0);
	}

	@Override
	public List<Uphoto> findAll() {
		String sql = "select * from uphoto";
		Object[] objs = {};
	
		List<Uphoto> up = upd.select(sql, objs,Uphoto.class);
		return up;
	}

	/*@Override
	public User login(User obj) {
		String sql = "select * from user where uname=? and upwd=?";
		Object[] objs = {obj.getUname(),obj.getUpwd()};
		List<User> users = bd.select(sql, objs,User.class);
		return users.size()==0?null:users.get(0);
	}*/

	@Override
	public User findOneByUname(String name) {
		String sql = "select * from user where uname=?";
		Object[] objs = {name};
		List<User> users = bd.select(sql, objs,User.class);
		return users.size()==0?null:users.get(0);
	}

	@Override
	public void save(Uphoto obj) {
		// TODO Auto-generated method stub
		String sql = "insert into uphoto(uid,photo,prole,pstate)values(?,?,?,?)";
		Object[] objs = {obj.getPid(),obj.getPhoto(),obj.getProle(),obj.getPstate()};
		System.out.println("TTTTTTTTTt"+obj.getPhoto());
		bd.update(sql, objs);
	}

}
