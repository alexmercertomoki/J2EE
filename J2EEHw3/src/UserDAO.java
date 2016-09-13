
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import edu.cmu.bilei.beans.UserBean;


public class UserDAO {
	
	public void createUserTable(){
		
		 MysqlDataSource ds = new MysqlConnectionPoolDataSource();
		 ds.setServerName("localhost");
		 ds.setPort(3306);
	     ds.setUser("root");
	     ds.setPassword("12345");
		 
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
	            
	            statement.executeBatch();
	            
	            System.out.println("User Table created successfully!");
	            
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
		 
	}
	
	public UserBean read(String email){
		
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		UserBean user = new UserBean();
		
		
		try{
			Class.forName("org.gjt.mm.mysql.Driver");
			conn=(Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1/test", "root", "12345");
			
			String sql = "select * from bhuang_user where email='"+email+"';";
			ps=(PreparedStatement) conn.prepareStatement(sql);
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
	
	
	public void create(UserBean user){
		
		Connection conn=null;
		PreparedStatement ps=null;
		
		try{
			
			Class.forName("org.gjt.mm.mysql.Driver");
			conn=(Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1/test", "root", "12345");			
			
			
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
	
	

}
