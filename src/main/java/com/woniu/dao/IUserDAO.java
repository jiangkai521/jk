package com.woniu.dao;

import java.util.List;

import com.woniu.pojo.Uphoto;
import com.woniu.pojo.User;

public interface IUserDAO {
	void save(Uphoto up);
	void update(User obj);
	void delete(Integer id);
	User findOne(Integer id);
	List<Uphoto> findAll();
	User findOneByUname(String name);
	void save(User obj);
}
