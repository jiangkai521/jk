package com.woniu.service;

import java.util.List;

import com.woniu.pojo.Uphoto;
import com.woniu.pojo.User;

public interface IUserService {

	User login(User user);

	void reg(Uphoto uphoto);

	List<Uphoto> findAll();

	void add(User user);

	void add(Uphoto up);

}
