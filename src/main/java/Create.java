import java.sql.*;

public class Create {

    public static void person() {
        // SQLite connection string
        String url = "jdbc:sqlite:src/main/resources/people.sqlite";

        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS person (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	firstName text NOT NULL,\n"
                + "	lastName text NOT NULL,\n"
                + "	birth text NOT NULL,\n"
                + "	addressID integer,\n"
                + "	relatives text NULL,\n"
                + "	personalMail text NULL,\n"
                + "	workMail text NULL,\n"
                + " contactID integer NOT NULL,\n"
                + " FOREIGN KEY(addressID) REFERENCES homeAddress (ID),"
                + " FOREIGN KEY(contactID) REFERENCES contactNumber (ID)"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void relation(){
        // SQLite connection string
        String url = "jdbc:sqlite:src/main/resources/people.sqlite";

        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS relation (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	fromPersonID int NOT NULL,\n"
                + "	toPersonID int NOT NULL,\n"
                + "	relation int NOT NULL,\n"
                + "	FOREIGN KEY(fromPersonID) REFERENCES person(ID),\n"
                + "	FOREIGN KEY(toPersonID) REFERENCES person(ID),\n"
                + "	FOREIGN KEY(relation) REFERENCES relationType(ID)\n"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void relationType(){
        // SQLite connection string
        String url = "jdbc:sqlite:src/main/resources/people.sqlite";

        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS relationType (\n"
                + "	ID integer PRIMARY KEY,\n"
                + "	Relationship text NOT NULL\n"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void homeAddress() {
        // SQLite connection string
        String url = "jdbc:sqlite:src/main/resources/people.sqlite";

        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS homeAddress (\n"
                + "	ID integer PRIMARY KEY,\n"
                + "	address text NOT NULL\n"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void contactNumber() {
        // SQLite connection string
        String url = "jdbc:sqlite:src/main/resources/people.sqlite";

        // SQL statement for creating a new table
        //ID, Work, Home, Mobile
        String sql = "CREATE TABLE IF NOT EXISTS contactNumber (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	work text NULL UNIQUE,\n"
                + "	home text NULL UNIQUE,\n"
                + "	mobile text NOT NULL UNIQUE\n"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void familyMember() {
        // SQLite connection string
        String url = "jdbc:sqlite:src/main/resources/people.sqlite";

        // SQL statement for creating a new table
        //ID, Work, Home, Mobile
        String sql = "CREATE TABLE IF NOT EXISTS contactNumber (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	work text NULL UNIQUE,\n"
                + "	home text NULL UNIQUE,\n"
                + "	mobile text NOT NULL UNIQUE\n"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void newDatabase(String fileName) {

        String url = "jdbc:sqlite:src/main/resources/" + fileName;

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


}


