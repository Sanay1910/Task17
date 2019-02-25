import java.sql.*;

public class Select {
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

    public static void selectPerson(){
        String sql =  "SELECT person.id, firstName, lastName, birth, address, relatives, personalEmail, workEmail, contact_id FROM person"
                + " INNER JOIN contactNumber ON contactNumber.id = person.contact_id";

        try (Connection conn = connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            // loop through the result set
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +  "\t");
                System.out.println("first name: " + rs.getString("firstName") + "\t");
                System.out.println("last name: " + rs.getString("lastName") + "\t");
                System.out.println("birthdate: " + rs.getString("birth") + "\t");
                System.out.println("Address: " + rs.getString("address") + "\t");
                System.out.println("relatives " + rs.getString("relatives") + "\t");
                System.out.println("personal email: " + rs.getString("personalEmail") + "\t");
                System.out.println("work email: " + rs.getString("workEmail") + "\t");
                System.out.println("contact_id: " + rs.getString("contact_id") + "\t");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void selectContact(){
        String sql =  "SELECT id, work, home, mobile FROM contactNumber";

        try (Connection conn = connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            // loop through the result set
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +  "\t");
                System.out.println("work number: " + rs.getString("work") + "\t");
                System.out.println("home number: " + rs.getString("home") + "\t");
                System.out.println("mobile number: " + rs.getString("mobile") + "\t");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
