package jdbc;

import java.sql.*;

public class PhoneListInsertTest {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: " + PhoneListInsertTest.class.getName()
                    + " <lastname> <firstname>");
            System.out.println("Usage: " + PhoneListInsertTest.class.getName()
                    + " <lastname> <firstname> <phonenumber>");
            return;
        }

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new AssertionError(e);
        }

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql:///test");
            Statement stmt = con.createStatement();
            int count;
            if (args.length == 3) {
                count = stmt
                        .executeUpdate("insert into phonelist (lastname,firstname,phonenumber) values ('"
                                + args[0]
                                + "','"
                                + args[1]
                                + "','"
                                + args[2]
                                + "')");
            } else {
                count = stmt
                        .executeUpdate("insert into phonelist (lastname,firstname) values ('"
                                + args[0] + "','" + args[1] + "')");
            }
            stmt.close();
            System.out.println("Added " + count + " entry to phonelist");
            con.close();
        } catch (SQLException e) {
            throw new AssertionError(e);
        }
    }
}
