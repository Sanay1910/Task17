import java.sql.*;
import java.util.ArrayList;

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
                System.out.printf("%-20s", rs.getString("Mobile"));
                System.out.println();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void relatives(){
        String sql = "SELECT p1.firstName as personName, p2.firstName as relativeName, relationship" +
                     " FROM relation INNER JOIN person p1 ON relation.fromPersonID = p1.ID" +
                     " INNER JOIN person p2 ON relation.toPersonID = p2.ID" +
                     " INNER JOIN relationType ON relation.relation = relationType.id " ;

        String url = "jdbc:sqlite:src/main/resources/people.sqlite";
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){


            while (rs.next()) {
                System.out.printf("%-10s", rs.getString("personName"));
                System.out.printf("%-10s", rs.getString("relativeName"));
                System.out.printf("%-10s\n", rs.getString("relationship"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void personColumns(String [] choices, ArrayList<String> personSelect){

        String sel = "";
        for (int i = 0; i < choices.length; i++) {
            sel += personSelect.get(Integer.parseInt(choices[i])-1);
            if(i != choices.length-1) sel += ", ";
        }

        /*String sql = "SELECT " +
                "person.ID, FirstName, LastName, Birth, Address, Relatives, PersonalMail, WorkMail, contactNumber.mobile" +
                " FROM Person" +
                " INNER JOIN homeAddress ON homeAddress.ID = person.AddressID" +
                " INNER JOIN contactNumber ON contactNumber.ID = person.contactID";
        */

        String sql = "SELECT " + sel + " FROM Person" +
                " INNER JOIN homeAddress ON homeAddress.ID = person.AddressID" +
                " INNER JOIN contactNumber ON contactNumber.ID = person.contactID" +
                " INNER JOIN person p1 ON relation.fromPersonID = p1.ID" +
                " INNER JOIN person p2 ON relation.toPersonID = p2.ID" +
                " INNER JOIN relationType ON relation.relation = relationType.id";

        System.out.println("sql: " + sql);

        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            // loop through the result set
            String format = "%-10s%-30s%s%n";

            //id, firstname, lastname, birth, address, relatives, personalmail, workmail, ContactNumber.Work,
            // ContactNumber.Home, ContactNumber.Mobile
            while(rs.next()) {
                String option = "";
                for (int i = 0; i < choices.length; i++) {
                    option = personSelect.get(Integer.parseInt(choices[i])-1);

                    if(option.equals("person.ID")) System.out.printf("%-10s", rs.getString("ID"));

                    if(option.equals("FirstName")) System.out.printf("%-15s", rs.getString(option));

                    if(option.equals("LastName") || option.equals("Region") || option.equals("Country")) System.out.printf("%-20s", rs.getString(option));

                    if(option.equals("Birth") || option.equals("Fax")) System.out.printf("%-30s", rs.getString(option));

                    if(option.equals("Address") || option.equals("ContactTitle")) System.out.printf("%-35s", rs.getString(option));

                    if(option.equals("Relatives")) System.out.printf("%-15s", rs.getString(option));

                    if(option.equals("PersonalMail")) System.out.printf("%-15s", rs.getString(option));

                    if(option.equals("WorkMail")) System.out.printf("%-15s", rs.getString(option));

                    if(option.equals("ContactNumber.Work")) System.out.printf("%-15s", rs.getString("Work"));

                    if(option.equals("ContactNumber.Home")) System.out.printf("%-15s", rs.getString("Home"));

                    if(option.equals("ContactNumber.Mobile")) System.out.printf("%-15s", rs.getString("Mobile"));


                }
                System.out.println();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
