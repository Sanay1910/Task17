import java.sql.*;

public class Insert {
    private Connection connect() {
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

    public void insertPerson(int id, String firstName, String lastName, String birth, String address,
                             String relatives,
                             String personalEmail,
                             String workEmail,
                             int contact_id)
    {
        String sql = "INSERT INTO person(id, firstName, lastName, birth, address, relatives, personalEmail, workEmail, contact_id) VALUES(?,?,?,?,?,?,?,?,?)";
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, firstName);
            pstmt.setString(3, lastName);
            pstmt.setString(4, birth);
            pstmt.setString(5, address);
            pstmt.setString(6, relatives);
            pstmt.setString(7, personalEmail);
            pstmt.setString(8, workEmail);
            pstmt.setInt(9, contact_id);


            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertContact(int id, String work, String home, String mobile) {
        String sql = "INSERT INTO contactNumber(id, work, home, mobile) VALUES(?,?,?,?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, work);
            pstmt.setString(3, home);
            pstmt.setString(4, mobile);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
