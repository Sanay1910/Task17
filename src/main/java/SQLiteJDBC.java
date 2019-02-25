import java.sql.*;

public class SQLiteJDBC {

    public static void main(String [] args) {
        createNewTable();
    }

    public static void createNewDatabase( String fileName ) {
        String url = "jdbc:sqlite:src/main/resources/task17.sqlite";

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
            String url = "jdbc:sqlite:src/main/resources/task17.sqlite";
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



    public static void createNewTable() {
        // SQLite connection string
        String url = "jdbc:sqlite:src/main/resources/task17.sqlite";

        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS person (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	firstName text NOT NULL,\n"
                + "	lastName text NOT NULL,\n"
                + "	birth text NOT NULL,\n"
                + "	address text NOT NULL,\n"
                + "	relatives text NULL,\n"
                + "	personalMail text NULL,\n"
                + "	workMail text NULL\n"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }







}
