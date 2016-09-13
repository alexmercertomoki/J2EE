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

import edu.cmu.bilei.beans.FavoriteBean;

// the favorite  DAO 
public class FavoriteDAO {
	// creating table on start 
	public void createFavouriteTable() {

		MysqlDataSource ds = new MysqlConnectionPoolDataSource();
		ds.setServerName("localhost");
		ds.setPort(3306);
		ds.setUser("");
		ds.setPassword("");

		try {
			Connection connection = null;
			connection = (Connection) ds.getConnection();
			Statement statement = (Statement) connection.createStatement();
			// create the DB ..
			statement.addBatch("CREATE DATABASE IF NOT EXISTS test");

			// use DB ..
			statement.addBatch("USE test");

			// create table ...
			statement.addBatch("drop table if exists bhuang_favourite;");

			statement
					.addBatch("CREATE TABLE bhuang_favourite(fav_id INT(10) NOT NULL AUTO_INCREMENT, "
							+ "user_id INT(10),URL text, comment text, "
							+ "click_count int(11),primary key(fav_id),"
							+ "foreign key(user_id) references bhuang_user(user_id));");
			
			statement.addBatch("insert into bhuang_favourite (user_id,url,comment,click_count) values (1, 'www.baidu.com','I love baidu',0);");
			statement.addBatch("insert into bhuang_favourite (user_id,url,comment,click_count) values (2, 'www.google.com','I love google',0);");
			statement.addBatch("insert into bhuang_favourite (user_id,url,comment,click_count) values (3, 'www.taobao.com','I love taobao',0);");


			statement.executeBatch();

			  System.out.println("Favourite table created successfully! And each favourite for 1 person ");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// reading the favourites using usr id 
	public List<FavoriteBean> read(int user_id) {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		List<FavoriteBean> favs = new ArrayList<FavoriteBean>();

		try {
			Class.forName("org.gjt.mm.mysql.Driver");
			conn = (Connection) DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1/test", "", "");

			String sql = "select * from bhuang_favourite where user_id=?;";
					
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setInt(1, user_id);
			rs = ps.executeQuery();

			while (rs.next()) {
				FavoriteBean f = new FavoriteBean();
				f.setUser_id(user_id);
				f.setFav_id(rs.getInt("fav_id"));
				f.setComment(rs.getString("comment"));
				f.setURL(rs.getString("URL"));
				f.setClick_count(rs.getInt("click_count"));
				favs.add(f);
			}
		} catch (SQLException se) {
			try {
				conn.rollback();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		return favs;
	}
	// create a new favorite with favorite  bean 
	public void create(FavoriteBean favb) {

		Connection conn = null;
		PreparedStatement ps = null;

		try {

			Class.forName("org.gjt.mm.mysql.Driver");
			conn = (Connection) DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1/test", "", "");

			String sql = "insert into bhuang_favourite (user_id,URL,comment,click_count) values(?,?,?,?)";

			ps = (PreparedStatement) conn.prepareStatement(sql);

			ps.setInt(1, favb.getUser_id());
			ps.setString(2, favb.getURL());
			ps.setString(3, favb.getComment());
			ps.setInt(4, favb.getClick_count());

			ps.executeUpdate();

		} catch (SQLException se) {
			try {
				conn.rollback();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} finally {
			try {
				conn.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

	}
	// update number of clicks 
	public void update(String url,int click) {

		Connection conn = null;
		PreparedStatement ps = null;

		try {

			Class.forName("org.gjt.mm.mysql.Driver");
			conn = (Connection) DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1/test", "", "");
			
			//update bhuang_favourite set click_count=2 where url='www.baidu.com';
			String sql = "update bhuang_favourite set click_count=? where url=?;";

			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setInt(1, click);
			ps.setString(2, url);
			ps.executeUpdate();

		} catch (SQLException se) {
			try {
				conn.rollback();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} finally {
			try {
				conn.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

	}
	
	
	public List<FavoriteBean> viewall() {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		List<FavoriteBean> favs = new ArrayList<FavoriteBean>();

		try {
			Class.forName("org.gjt.mm.mysql.Driver");
			conn = (Connection) DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1/test", "", "");

			String sql = "select * from bhuang_favourite";
				
			ps = (PreparedStatement) conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				FavoriteBean f = new FavoriteBean();
				f.setUser_id(rs.getInt("user_id"));
				f.setFav_id(rs.getInt("fav_id"));
				f.setComment(rs.getString("comment"));
				f.setURL(rs.getString("URL"));
				f.setClick_count(rs.getInt("click_count"));
				favs.add(f);
			}
		} catch (SQLException se) {
			try {
				conn.rollback();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		return favs;
	}
	
	public void delete(int favId) {

		Connection conn = null;
		PreparedStatement ps = null;

		try {

			Class.forName("org.gjt.mm.mysql.Driver");
			conn = (Connection) DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1/test", "", "");
			
			//update bhuang_favourite set click_count=2 where url='www.baidu.com';
			String sql = "delete from bhuang_favourite where fav_id=?;";

			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setInt(1, favId);
			ps.executeUpdate();

		} catch (SQLException se) {
			try {
				conn.rollback();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} finally {
			try {
				conn.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

	}
	
	
	

}
