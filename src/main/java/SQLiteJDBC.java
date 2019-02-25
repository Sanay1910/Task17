import java.sql.*;

public class SQLiteJDBC {

    public static void main(String [] args) {
        createNewDatabase("task17.sqlite");
    }

    public static void createNewDatabase( String fileName ) {
        String url = "jdbc:sqlite:C:\\Users\\saomoe\\Documents\\javaAssignments\\Week03\\src\\main\\resources\\" + fileName;

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void connectDB() {
        Connection conn = null;
        try {
            String url = "";
            conn = DriverManager.getConnection(url);
            System.out.println("Connected");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }




}
