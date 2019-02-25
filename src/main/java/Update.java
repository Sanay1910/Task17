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

    public void updatePerson(int id,
                       String firstName,
                       String lastName,
                       String birth,
                       String address,
                       String relatives,
                       String personalEmail,
                       String workEmail,
                       int contact_id
                       ) {
        String sql = "UPDATE person SET firstName = ? , "
                + "lastName = ? , "
                + "birth = ? , "
                + "address = ? , "
                + "relatives = ? , "
                + "personalEmail = ? , "
                + "workEmail = ? ,"
                + "contact_id = ?  "
                + "WHERE person.id = ? ";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setString(3, birth);
            pstmt.setString(4, address);
            pstmt.setString(5, relatives);
            pstmt.setString(6, personalEmail);
            pstmt.setString(7, workEmail);
            pstmt.setInt(8, contact_id);
            pstmt.setInt(9, id);
            // update
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateContactNumber(int id, String work, String home, String mobile) {
        String sql = "UPDATE contactNumber SET work = ? , home = ? , mobile WHERE id = ?";
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


}
