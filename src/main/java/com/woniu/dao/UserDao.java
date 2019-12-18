//package com.woniu.dao;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//
//
//import com.woniu.beans.Users;
//import com.woniu.pojo.Uphoto;
//import com.woniu.pojo.User;
//import com.woniu.tools.JdbcUtils;
//import com.woniu.tools.JkConnect;
//
//
//
//
//public class UserDao {
//	public boolean isExit(User u) throws SQLException{
//
//		Connection conn=JdbcUtils.getConn();
//		
//		
//		
//		PreparedStatement ps = conn.prepareStatement("select * from users where user_name=? and user_pwd=?");
//		
//		ps.setString(1, u.getUname());
//		
//		ps.setString(2, u.getUpwd());
//
//		ResultSet rs=ps.executeQuery();
//		
//		if(rs.next()){
//			return true;
//		}
//		else{
//			return false;
//		}
//	}
//		public List<Uphoto> getAllUphoto(){
//			Connection conn=null;
//			List <Uphoto> l=new ArrayList<Uphoto>();
//			try {
//				conn=JdbcUtils.getConn();
//
//				Statement ps=conn.createStatement();
//				ResultSet rs=ps.executeQuery("select * from uphoto");
//						
//				
//			while(rs.next()) {
//				int ui=rs.getInt("uid");
//				
//				String un=rs.getString("user_name");
//				String up=rs.getString("user_pwd");
//				String ur=rs.getString("user_role");
//				String us=rs.getString("user_status");
//				String uo=rs.getString("user_photo");
//				Uphoto u=new Uphoto(ui,un,up,ur,us,uo);
//					
//					l.add(u);
//					
//				}
//			
//			
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//				
//			}
//			finally{
//				JdbcUtils.closeconn(conn);
//			}
//			return l;
//		}	
//		
//		public  void addUsers(Uphoto up) throws SQLException{
//			Connection conn=null;
//			    
//			try {
//				conn=JdbcUtils.getConn();
//				PreparedStatement ps=conn.prepareStatement("insert into users(user_name,user_pwd,user_role,user_status,user_photo)values(?,?,?,?,?)");
//			ps.setString(1,up.getUser_name());
//			System.out.println("######"+up.getUser_name());
//			ps.setString(2, up.getUser_pwd());
//			ps.setString(3, up.getUser_role());
//			ps.setString(4, up.getUser_status());
//			ps.setString(5, up.getUser_photo());
////			System.out.println(u.getUser_pwd());
//			ps.executeUpdate();
//			} 
//			finally{
//				JdbcUtils.closeconn(conn);
//			}
//		}
//	} 
//
