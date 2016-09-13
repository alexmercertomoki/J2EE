
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

import edu.cmu.bilei.beans.FavouriteBean;


public class FavouriteDAO {
	public void createFavouriteTable() {

		MysqlDataSource ds = new MysqlConnectionPoolDataSource();
		ds.setServerName("localhost");
		ds.setPort(3306);
		ds.setUser("root");
		ds.setPassword("12345");

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

			statement.executeBatch();

			  System.out.println("Favourite table created successfully!");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public List<FavouriteBean> read(int user_id) {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		List<FavouriteBean> favs = new ArrayList<FavouriteBean>();

		try {
			Class.forName("org.gjt.mm.mysql.Driver");
			conn = (Connection) DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1/test", "root", "12345");

			String sql = "select * from bhuang_favourite where user_id='"
					+ user_id + "';";
			ps = (PreparedStatement) conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				FavouriteBean f = new FavouriteBean();
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

	public void create(FavouriteBean favb) {

		Connection conn = null;
		PreparedStatement ps = null;

		try {

			Class.forName("org.gjt.mm.mysql.Driver");
			conn = (Connection) DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1/test", "root", "12345");

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
	
	public void update(String url,int click) {

		Connection conn = null;
		PreparedStatement ps = null;

		try {

			Class.forName("org.gjt.mm.mysql.Driver");
			conn = (Connection) DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1/test", "root", "12345");
			
			//update bhuang_favourite set click_count=2 where url='www.baidu.com';
			String sql = "update bhuang_favourite set click_count="+click +" where url='"+url+"';";

			ps = (PreparedStatement) conn.prepareStatement(sql);

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
