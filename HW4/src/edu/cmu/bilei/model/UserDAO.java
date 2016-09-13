package edu.cmu.bilei.model;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import edu.cmu.bilei.beans.UserBean;


public class UserDAO {
	// create user table 
	public void createUserTable(){
		
		 MysqlDataSource ds = new MysqlConnectionPoolDataSource();
		 ds.setServerName("localhost");
		 ds.setPort(3306);
	     ds.setUser("");
	     ds.setPassword("");
		 
	     try {
	            Connection connection = null ; 
	            connection =  (Connection) ds.getConnection();
	            Statement statement = (Statement) connection.createStatement();
              // create the DB .. 
	            statement.addBatch("CREATE DATABASE IF NOT EXISTS test" ) ;
	            
	            // use DB ..
	            statement.addBatch("USE test") ; 

	            // create table ...
	            statement.addBatch("drop table if exists bhuang_favourite;");
	            statement.addBatch("drop table if exists bhuang_user;");
	            
	            statement.addBatch("CREATE TABLE bhuang_user (user_id int(10) "
	            		+ "not null auto_increment, email varchar(50),"
	            		+ "first_name char(30) not null,last_name char(30) not null,"
	            		+ "password char(30) not null,"
	            		+ "PRIMARY KEY (user_id));" );
	            
	            
	            statement.addBatch("insert into bhuang_user (email, first_name, last_name, password) values('123@gmail.com',"
	            		+ " 'bilei', 'huang', '12345')");
	            
	            statement.addBatch("insert into bhuang_user (email, first_name, last_name, password) values('345@gmail.com',"
	            		+ " 'hao', 'fu', '12345')");
	            
	            statement.addBatch("insert into bhuang_user (email, first_name, last_name, password) values('567@gmail.com',"
	            		+ " 'tianyue', 'xiao', '12345')");
	            
	            statement.executeBatch();
	            
	            System.out.println("User Table created successfully! and 3 records inserted successfully");
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		 
	}
	// read user info with an email 
	public UserBean read(String email){
		
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		UserBean user = new UserBean();
		
		
		try{
			Class.forName("org.gjt.mm.mysql.Driver");
			conn=(Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1/test", "", "");
			
			String sql = "select * from bhuang_user where email=?;";
			ps=(PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1,email);
			rs=ps.executeQuery();			
			
		
			
			while(rs.next()){
				
				user.setUserId(rs.getInt("user_id"));
				user.setEmail(rs.getString("email"));
				user.setFirstName(rs.getString("first_name"));
				user.setLastName(rs.getString("last_name"));
				user.setPassword(rs.getString("password"));
		
			}
		}
		catch(SQLException se){
			try{
				conn.rollback();
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
		}
		catch(Exception e){
			try{
				conn.rollback();
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
		}
		finally{
			try{
				rs.close();
				ps.close();
				conn.close();
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
		}
		
		return user;
	}
	
	// create a user 
	public void create(UserBean user){
		
		Connection conn=null;
		PreparedStatement ps=null;
		
		try{
			
			Class.forName("org.gjt.mm.mysql.Driver");
			conn=(Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1/test", "", "");			
			
			
			String sql="insert into bhuang_user (email,first_name,last_name,password) values(?,?,?,?)";
			
			ps = (PreparedStatement) conn.prepareStatement(sql);
			
			
			ps.setString(1, user.getEmail());
			ps.setString(2,user.getFirstName());
			ps.setString(3, user.getLastName());
			ps.setString(4, user.getPassword());
			
			ps.executeUpdate();
			
			
		}
		catch(SQLException se){
			try{

			}
			catch(Exception ex){
				ex.printStackTrace();
			}
		}
		catch(Exception e){
			try{
				conn.rollback();
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
		}
		finally{
			try{
				conn.close();
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
		}
		
		
		
	}
	
	
public List<UserBean> userInfo(){
		
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		UserBean user;
		List<UserBean> list = new ArrayList<UserBean>();
		
		try{
			Class.forName("org.gjt.mm.mysql.Driver");
			conn=(Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1/test", "", "");
			
			String sql = "select * from bhuang_user";
			ps=(PreparedStatement) conn.prepareStatement(sql);
			rs=ps.executeQuery();			
			
		
			
			while(rs.next()){
				
				user = new UserBean();
				user.setUserId(rs.getInt("user_id"));
				user.setEmail(rs.getString("email"));
				user.setFirstName(rs.getString("first_name"));
				user.setLastName(rs.getString("last_name"));
				user.setPassword(rs.getString("password"));
				
				list.add(user);
			}
		}
		catch(SQLException se){
			try{
				conn.rollback();
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
		}
		catch(Exception e){
			try{
				conn.rollback();
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
		}
		finally{
			try{
				rs.close();
				ps.close();
				conn.close();
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
		}
		
		return list;
	}
	
public UserBean readWithId(int userId){
	
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	UserBean user = new UserBean();
	
	
	try{
		Class.forName("org.gjt.mm.mysql.Driver");
		conn=(Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1/test", "", "");
		
		String sql = "select * from bhuang_user where user_id=?;";
		
		ps=(PreparedStatement) conn.prepareStatement(sql);
		ps.setInt(1, userId);
		rs=ps.executeQuery();			
	
		
		while(rs.next()){
			
			user.setUserId(rs.getInt("user_id"));
			user.setEmail(rs.getString("email"));
			user.setFirstName(rs.getString("first_name"));
			user.setLastName(rs.getString("last_name"));
			user.setPassword(rs.getString("password"));
	
		}
	}
	catch(SQLException se){
		try{
			conn.rollback();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	catch(Exception e){
		try{
			conn.rollback();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	finally{
		try{
			rs.close();
			ps.close();
			conn.close();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	return user;
}
	
public void changePass(String password,int userId){
	
	Connection conn=null;
	PreparedStatement ps=null;
	
	try{
		
		Class.forName("org.gjt.mm.mysql.Driver");
		conn=(Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1/test", "", "");			
		
		
		String sql="update bhuang_user set password=? where user_id=?";
		
		ps = (PreparedStatement) conn.prepareStatement(sql);
		
		ps.setString(1, password);
		ps.setInt(2, userId);
		
		ps.executeUpdate();
		
		
	}
	catch(SQLException se){
		try{

		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	catch(Exception e){
		try{
			conn.rollback();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	finally{
		try{
			conn.close();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
	
}



}
