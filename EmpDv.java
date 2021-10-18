package com.emp.dav;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.emp.entity.Employee;

public class EmpDv {
	public static Connection getConnection() throws ClassNotFoundException, SQLException
	{
	String dbDriver="com.mysql.jdbc.Driver";
	String url="jdbc:mysql://127.0.0.1:3306/";
	String dbname="emp";
	String username="root";
	String password="";
	Class.forName(dbDriver);
	Connection con=DriverManager.getConnection(url+dbname,username,password);
	return con;
	}
public static int save(Employee e)
	{
		int status=0;
		try
		{
			Connection con=EmpDv.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into demo(name,password,email)values(?,?,?)");
			ps.setString(1, e.getName());
			ps.setString(2, e.getPassword());
			ps.setString(3, e.getEmail());
			status=ps.executeUpdate();
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return status;
	}


public static List<Employee> getAllEmployees()
{
	List<Employee> lst=new ArrayList<Employee>();
	
	try {
		Connection con=EmpDv.getConnection();
		PreparedStatement ps=con.prepareStatement("select * from demo");
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			Employee e=new Employee();
			e.setId(rs.getInt(1));
			e.setName(rs.getString(2));
			e.setPassword(rs.getString(3));
			e.setEmail(rs.getString(4));
			
			lst.add(e);
			
			
			
			
		}
	}catch(Exception ex) {
		ex.printStackTrace();
	}
	
	return lst;
}

public static Employee getEmployeeById(int id) {
	Employee e=new Employee();
	try {
		Connection con=EmpDv.getConnection();
		PreparedStatement ps=con.prepareStatement("select * from demo where id=?");
		ps.setInt(1, id);
		
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{
			e.setId(rs.getInt(1));
			e.setName(rs.getString(2));
			e.setPassword(rs.getString(3));
			e.setEmail(rs.getString(4));
		}
		
	}catch(Exception ex) {
		ex.printStackTrace();
	}
	return e;
}

public static int update(Employee e)
{
	int status=0;
	try {
		Connection con=EmpDv.getConnection();
		PreparedStatement ps=con.prepareStatement("update demo set name=?,password=?,email=? where id=?");
		ps.setString(1, e.getName());
		ps.setString(2, e.getPassword());
		ps.setString(3,e.getEmail());
		ps.setInt(4, e.getId());
		status=ps.executeUpdate();
		
	}catch(Exception ex) {
		ex.printStackTrace();
	}
	return status;
}

}






	