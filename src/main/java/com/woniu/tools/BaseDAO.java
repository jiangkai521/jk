package com.woniu.tools;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.woniu.pojo.Uphoto;

public class BaseDAO<T> {
	private Connection conn;
	private PreparedStatement stat;
	private ResultSet rs;
	public void update(String sql,Object[] objs){
		try {
			conn = JdbcUtils.getConn();
			conn.setAutoCommit(false);
			//insert into stu values(null,?,?,?)
			//objs {stu.getSid(),stu.getSname(),stu.getAge()}
			stat = conn.prepareStatement(sql);
			for(int i=0;i<objs.length;i++){
				stat.setObject(i+1, objs[i]);
			}
			int row = stat.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public List<T> select(String sql,Object[] objs,Class c){
//		Card c = null;
		List<T> list = new ArrayList<T>();
		try {
			conn = JdbcUtils.getConn();
			conn.setAutoCommit(false);
			//insert into stu values(null,?,?,?)
			//objs {stu.getSid(),stu.getSname(),stu.getAge()}
			stat = conn.prepareStatement(sql);
//			stat.setObject(1, cid);
			for(int i=0;i<objs.length;i++){
				stat.setObject(i+1, objs[i]);
			}
			rs = stat.executeQuery();
			Method[] ms = c.getDeclaredMethods();
			while(rs.next()){
//				c = new Card();
				Object obj = c.newInstance();
//				c.setCid(rs.getInt("cid"));
//				c.setCno(rs.getString("cno"));
//				c.setCname(rs.getString("cname"));
//				c.setCmoney(rs.getDouble("cmoney"));
				for (Method m : ms) {
					String mName = m.getName();
					if(mName.startsWith("set")){
						String fieldName = mName.substring(3);
						Class[] cs = m.getParameterTypes();
						if(cs[0]==Integer.class){
							m.invoke(obj, rs.getInt(fieldName));
						}
						if(cs[0]==String.class){
							m.invoke(obj, rs.getString(fieldName));
						}
						if(cs[0]==Double.class){
							m.invoke(obj, rs.getDouble(fieldName));
						}
					}
				}
				list.add((T) obj);
				System.out.println("$$$$$$$$$$$"+list);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
//		return c;
		return list;
		
	}
}
