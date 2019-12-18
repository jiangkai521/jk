package com.woniu.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.woniu.dao.IUserDAO;
import com.woniu.dao.impl.UserDAOImpl;
import com.woniu.pojo.Uphoto;
import com.woniu.pojo.User;
import com.woniu.service.IUserService;
import com.woniu.tools.JdbcUtils;


public class UserServiceImpl implements IUserService {
	IUserDAO ud = new UserDAOImpl();

	@Override
	public User login(User user) {
		Connection conn = null;
		try {
			conn = JdbcUtils.getConn();
			User temp = ud.findOneByUname(user.getUname());
			if (temp != null && user.getUpwd().equals(temp.getUpwd())) {
				return temp;
			}
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			JdbcUtils.closeConn();
		}
		return user;
	}

	@Override
	public void reg(Uphoto up) {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn = JdbcUtils.getConn();
			User temp = ud.findOneByUname(up.getPhoto());
			if (temp == null) {
//				user.setUrole("1");
				ud.save(up);
			}
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			JdbcUtils.closeConn();
		}
	}

	@Override
	public List<Uphoto> findAll() {
		List<Uphoto> up = new ArrayList<Uphoto>();
		// ������Ӷ���
		Connection conn = null;
		// ������
		try {
			conn = JdbcUtils.getConn();
			// ����dao����
			up = ud.findAll();
			// �����ύ
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// ����ع�
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			// �ر����Ӷ���
			JdbcUtils.closeConn();
		}
		return up;
	}

	@Override
	public void add(Uphoto up) {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn = JdbcUtils.getConn();
			User temp = ud.findOneByUname(up.getPhoto());
			if (temp == null) {
			
				ud.save(up);
			}
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			JdbcUtils.closeConn();
		}
	}

	@Override
	public void add(User user) {
		// TODO Auto-generated method stub
		
	}

}
