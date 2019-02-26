import java.sql.*;

public class Insert {
    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:src/main/resources/people.sqlite";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void person(int ID, String firstName, String lastName, String birth, int addressID , String relatives, String personalMail, String workMail,int contactID) {
        String sql = "INSERT INTO person(ID,firstName,lastName,birth,addressID,relatives,personalMail,workMail,contactID) VALUES(?,?,?,?,?,?,?,?,?)";

        //id, firstname, lastname, birth, address, relatives, personalmail, workmail
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, ID);
            pstmt.setString(2, firstName);
            pstmt.setString(3,lastName);
            pstmt.setString(4,birth);
            pstmt.setInt(5,addressID);
            pstmt.setString(6,relatives);
            pstmt.setString(7,personalMail);
            pstmt.setString(8,workMail);
            pstmt.setInt(9,contactID);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void relationType(String relationType) {
        String url = "jdbc:sqlite:src/main/resources/people.sqlite";
        String sql = "INSERT INTO relationtype(relationship) VALUES(?)";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, relationType);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void relation(int fromPersonID, int toPersonID, int relation) {
        String url = "jdbc:sqlite:src/main/resources/people.sqlite";
        String sql = "INSERT INTO relation(fromPersonID, toPersonID, relation) VALUES(?,?,?)";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, fromPersonID);
            pstmt.setInt(2, toPersonID);
            pstmt.setInt(3, relation);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void homeAddress(int ID, String address) {
        String sql = "INSERT INTO homeAddress(ID,address) VALUES(?,?)";

        //id, firstname, lastname, birth, address, relatives, personalmail, workmail
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, ID);
            pstmt.setString(2,address);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void contactNumber(int ID, String work, String home, String mobile) {
        String sql = "INSERT INTO contactNumber(ID,work,home,mobile) VALUES(?,?,?,?)";

        //id, work, home, mobile
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, ID);
            pstmt.setString(2, work);
            pstmt.setString(3, home);
            pstmt.setString(4, mobile);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
