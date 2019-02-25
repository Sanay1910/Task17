import java.sql.*;

public class SQLiteJDBC {
    public static void main( String [] args) {

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
