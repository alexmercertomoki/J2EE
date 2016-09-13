package edu.cmu.cs.webapp.todolist3.dao;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.cmu.cs.webapp.todolist3.databean.ItemBean;

public class ItemDAO {
    private List<Connection> connectionPool = new ArrayList<Connection>();

    private String jdbcDriver;
    private String jdbcURL;
    private String tableName;

    public ItemDAO(String jdbcDriver, String jdbcURL, String tableName)
            throws MyDAOException {
        this.jdbcDriver = jdbcDriver;
        this.jdbcURL = jdbcURL;
        this.tableName = tableName;

        if (!tableExists())
            createTable();
    }

    private synchronized Connection getConnection() throws MyDAOException {
        if (connectionPool.size() > 0) {
            return connectionPool.remove(connectionPool.size() - 1);
        }

        try {
            Class.forName(jdbcDriver);
        } catch (ClassNotFoundException e) {
            throw new MyDAOException(e);
        }

        try {
            return DriverManager.getConnection(jdbcURL);
        } catch (SQLException e) {
            throw new MyDAOException(e);
        }
    }

    private synchronized void releaseConnection(Connection con) {
        connectionPool.add(con);
    }

    public void addToTop(ItemBean item) throws MyDAOException {
        Connection con = null;
        try {
            con = getConnection();
            con.setAutoCommit(false);

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT MIN(position) FROM "
                    + tableName + " FOR UPDATE");
            rs.next();
            int minPos = rs.getInt("MIN(position)"); // Will return 0 if there
                                                     // are no items
            rs.close();
            stmt.close();

            item.setPosition(minPos - 1);

            PreparedStatement pstmt = con.prepareStatement("INSERT INTO "
                    + tableName
                    + " (item,position,ipAddress,userName) VALUES (?,?,?,?)");
            pstmt.setString(1, item.getItem());
            pstmt.setInt(2, item.getPosition());
            pstmt.setString(3, item.getIpAddress());
            pstmt.setString(4, item.getUserName());
            pstmt.executeUpdate();
            pstmt.close();

            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT LAST_INSERT_ID()");
            rs.next();
            item.setId(rs.getInt("LAST_INSERT_ID()"));

            con.commit();
            con.setAutoCommit(true);

            releaseConnection(con);

        } catch (SQLException e) {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e2) { /* ignore */
            }
            throw new MyDAOException(e);
        }
    }

    public void addToBottom(ItemBean item) throws MyDAOException {
        Connection con = null;
        try {
            con = getConnection();
            con.setAutoCommit(false);

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT MAX(position) FROM "
                    + tableName + " FOR UPDATE");
            rs.next();
            int maxPos = rs.getInt("MAX(position)"); // Will return 0 if there
                                                     // are no items
            rs.close();
            stmt.close();

            item.setPosition(maxPos + 1);

            PreparedStatement pstmt = con.prepareStatement("INSERT INTO "
                    + tableName
                    + " (item,position,ipAddress,userName) VALUES (?,?,?,?)");
            pstmt.setString(1, item.getItem());
            pstmt.setInt(2, item.getPosition());
            pstmt.setString(3, item.getIpAddress());
            pstmt.setString(4, item.getUserName());
            pstmt.executeUpdate();
            pstmt.close();

            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT LAST_INSERT_ID()");
            rs.next();
            item.setId(rs.getInt("LAST_INSERT_ID()"));

            con.commit();
            con.setAutoCommit(true);

            releaseConnection(con);

        } catch (SQLException e) {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e2) { /* ignore */
            }
            throw new MyDAOException(e);
        }
    }

    public void delete(int id) throws MyDAOException {
        Connection con = null;
        try {
            con = getConnection();

            Statement stmt = con.createStatement();
            stmt.executeUpdate("DELETE FROM " + tableName + " WHERE id=" + id);
            stmt.close();
            releaseConnection(con);
        } catch (SQLException e) {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e2) { /* ignore */
            }
            throw new MyDAOException(e);
        }
    }

    public ItemBean[] getItems() throws MyDAOException {
        Connection con = null;
        try {
            con = getConnection();

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM " + tableName);

            List<ItemBean> list = new ArrayList<ItemBean>();
            while (rs.next()) {
                ItemBean bean = new ItemBean();
                bean.setId(rs.getInt("id"));
                bean.setItem(rs.getString("item"));
                bean.setPosition(rs.getInt("position"));
                bean.setIpAddress(rs.getString("ipAddress"));
                bean.setUserName(rs.getString("userName"));
                list.add(bean);
            }
            stmt.close();
            releaseConnection(con);

            return list.toArray(new ItemBean[list.size()]);
        } catch (SQLException e) {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e2) { /* ignore */
            }
            throw new MyDAOException(e);
        }
    }

    public int size() throws MyDAOException {
        Connection con = null;
        try {
            con = getConnection();

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT COUNT(id) FROM "
                    + tableName);

            rs.next();
            int count = rs.getInt("COUNT(id)");

            stmt.close();
            releaseConnection(con);

            return count;

        } catch (SQLException e) {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e2) { /* ignore */
            }
            throw new MyDAOException(e);
        }
    }

    private boolean tableExists() throws MyDAOException {
        Connection con = null;
        try {
            con = getConnection();
            DatabaseMetaData metaData = con.getMetaData();
            ResultSet rs = metaData.getTables(null, null, tableName, null);

            boolean answer = rs.next();

            rs.close();
            releaseConnection(con);

            return answer;

        } catch (SQLException e) {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e2) { /* ignore */
            }
            throw new MyDAOException(e);
        }
    }

    private void createTable() throws MyDAOException {
        Connection con = getConnection();
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("CREATE TABLE " + tableName
                    + " (id INT NOT NULL AUTO_INCREMENT,"
                    + " ipAddress VARCHAR(50)," + " item VARCHAR(255),"
                    + " position INT NOT NULL DEFAULT 0, "
                    + " userName VARCHAR(50)," + " PRIMARY KEY(id))");
            stmt.close();
            releaseConnection(con);
        } catch (SQLException e) {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e2) { /* ignore */
            }
            throw new MyDAOException(e);
        }
    }
}
