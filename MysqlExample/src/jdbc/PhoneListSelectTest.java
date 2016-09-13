package jdbc;

import java.sql.*;

public class PhoneListSelectTest {
    public static void main(String[] args) {
        String sql = "select * from phonelist";

        if (args.length > 0) {
            try {
                int id = Integer.parseInt(args[0]);
                sql = sql + " where id=" + id;
            } catch (NumberFormatException e) {
                sql = sql + " where lastname='" + args[0] + "'";
            }
        }

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new AssertionError(e);
        }

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql:///test");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String last = rs.getString("lastname");
                String first = rs.getString("firstname");
                String phone = rs.getString("phonenumber");
                System.out.println(id + "  " + phone + "  " + last + ", " + first);
            }
            rs.close();
            stmt.close();
            System.out.println("Successfully selected from phonelist");
            con.close();
        } catch (SQLException e) {
            throw new AssertionError(e);
        }
    }
}
