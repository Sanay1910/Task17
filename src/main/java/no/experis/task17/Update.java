package no.experis.task17;

import java.sql.*;

public class Update {

    private static Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:src/main/resources/task17.sqlite";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void person(int id,
                       String firstName,
                       String lastName,
                       String birth,
                       String addressID,
                       String relatives,
                       String personalEmail,
                       String workEmail,
                       int contactID
    ) {
        String sql = "UPDATE person SET firstName = ? , "
                + "lastName = ? , "
                + "birth = ? , "
                + "addressID = ? , "
                + "relatives = ? , "
                + "personalEmail = ? , "
                + "workEmail = ? ,"
                + "contactID = ?  "
                + "WHERE person.id = ? ";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setString(3, birth);
            pstmt.setString(4, addressID);
            pstmt.setString(5, relatives);
            pstmt.setString(6, personalEmail);
            pstmt.setString(7, workEmail);
            pstmt.setInt(8, contactID);
            pstmt.setInt(9, id);
            // update
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void contactNumber(int id, String work, String home, String mobile) {
        String sql = "UPDATE contactNumber SET work = ? , home = ? , mobile WHERE ContactNumber.id = ?";
        try(Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, work);
            pstmt.setString(2, home);
            pstmt.setString(3, mobile);
            pstmt.setInt(4, id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void homeAddress( int id, String address ) {
        String sql = "UPDATE homeAddress SET address = ? WHERE homeAddress.id = ?";
        try(Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, address);
            pstmt.setInt(2, id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
