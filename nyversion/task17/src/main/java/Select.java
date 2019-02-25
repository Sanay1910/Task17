import java.sql.*;

public class Select {

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

    public void person(){

        //id, firstname, lastname, birth, address, relatives, personalmail, workmail
        String sql = "SELECT " +
                "person.ID, FirstName, LastName, Birth, Address, Relatives, PersonalMail, WorkMail, contactNumber.mobile" +
                " FROM Person" +
                " INNER JOIN homeAddress ON homeAddress.ID = person.AddressID" +
                " INNER JOIN contactNumber ON contactNumber.ID = person.contactID";

        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            // loop through the result set
            while (rs.next()) {
                System.out.printf("%-10s", rs.getString("ID"));
                System.out.printf("%-15s", rs.getString("FirstName"));
                System.out.printf("%-15s", rs.getString("LastName"));
                System.out.printf("%-10s", rs.getString("Birth"));
                System.out.printf("%-15s", rs.getString("Address"));
                System.out.printf("%-20s", rs.getString("Relatives"));
                System.out.printf("%-20s", rs.getString("PersonalMail"));
                System.out.printf("%-20s", rs.getString("WorkMail"));
                System.out.printf("%-20s", rs.getString("mobile"));
                System.out.println();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
