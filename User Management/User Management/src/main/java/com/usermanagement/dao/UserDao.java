package com.usermanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.usermanagent.bean.Userbean;

public class UserDao {
	private static String url="Jdbc:mysql://localhost:3306/usermanagement";
	private static String user="root";
	private static String pass="Raksha@123";
	private static Connection con=null;
	private static Statement s=null;
	private static ResultSet rs =null;
	private static PreparedStatement ps=null;
	private static String checkQuery="select * from admin";
	private static String insert="insert into user(name,email,city) values(?,?,?)";
	private static String delete="delete from user where id=?";
	private static String selectUser="select * from user where id=?";
	private static String display="select * from user";
	private static String updateUser="update user set name=?,email=?,city=? where id=?";

public static boolean checkLogin(String username,String password)
{
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection(url, user, pass);
		s =con.createStatement();
		rs= s.executeQuery(checkQuery);
		while(rs.next())
		{
			String user= rs.getString("username");
			String pass=rs.getString("password");	 

			if(user.equals(username) && pass.equals(password))
			{
				return true;
			}
		}
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally
	{
		try {
			rs.close();
			s.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	return false;

}
public static void insertUserDetails(Userbean u)
{
	 try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection(url, user, pass);
		ps=con.prepareStatement(insert);
		ps.setString(1,u.getName());
		ps.setString(2,u.getEmail());
		ps.setString(3,u.getCity());
		ps.executeUpdate();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 finally
		{
			try {
			
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

public static void delete(int id)
{
	 try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, user, pass);
			ps=con.prepareStatement(delete);
			ps.setInt(1,id);
			ps.executeUpdate();
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 finally
			{
				try {
				
					ps.close();
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			}
public static  ArrayList<Userbean> display() {
	ArrayList<Userbean> au = new ArrayList<Userbean>();
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection(url, user, pass);
		s =con.createStatement();
		rs=s.executeQuery(display);
		while(rs.next())
		{
			int id=rs.getInt("id");
			String name=rs.getString("name");
			String email= rs.getString("email");
			String city=rs.getString("city");
			Userbean u=new Userbean(id, name, email, city);
			au.add(u);
		}
		} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	finally
	{
		try {
			rs.close();
			s.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	return au;
}
public static Userbean selectUser(int id1)
{
	Userbean u=null;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection(url, user, pass);
		ps=con.prepareStatement(selectUser);
	    ps.setInt(1,id1);
		rs=ps.executeQuery();
		if(rs.next())
		{
			int id=rs.getInt("id");
			String name=rs.getString("name");
			String email= rs.getString("email");
			String city=rs.getString("city");
			u=new Userbean(id, name, email, city);	
		}
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 finally
		{
			try {
			
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	return u;
}


public static  void updateUser(Userbean u)
{
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection(url,user, pass);
		ps=con.prepareStatement(updateUser);
		ps.setString(1,u.getName());
		ps.setString(2,u.getEmail());
		ps.setString(3,u.getCity());
		ps.setInt(4,u.getId());
		ps.executeUpdate();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally
	{
		try {
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
}