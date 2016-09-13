package jdbc;

import java.sql.*;

public class PhoneListInsertTest2 {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: " + PhoneListInsertTest2.class.getName()
                    + " <lastname> <firstname>");
            System.out.println("Usage: " + PhoneListInsertTest2.class.getName()
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
            PreparedStatement pstmt = con
                    .prepareStatement("insert into phonelist (lastname,firstname,phonenumber) values (?,?,?)");
            pstmt.setString(1, args[0]);
            pstmt.setString(2, args[1]);
            if (args.length > 2) {
                pstmt.setString(3, args[2]);
            } else {
                pstmt.setString(3, null);
            }
            int count = pstmt.executeUpdate();
            pstmt.close();
            System.out.println("Added " + count + " entry to phonelist");
            con.close();
        } catch (SQLException e) {
            throw new AssertionError(e);
        }
    }
}
